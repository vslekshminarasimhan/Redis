package com.ge.healthcare.autosc.onwatch.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import com.ge.healthcare.autosc.onwatch.model.TaskListTag;
import com.ge.healthcare.autosc.onwatch.repository.TaskListTagRepository;

 
@Service
public class TaskListTagServiceImpl implements TaskListTagService {
	
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TaskListTagServiceImpl.class);
	
	 public static final String REDIS_KEY = "TaskListTag_KEY_"; 
	
    @Autowired
    TaskListTagRepository repository;
       
    @Autowired
    private RedisTemplate redisTemplate;
     
    public List<TaskListTag> getAllTaskListTags()
    {
        List<TaskListTag> taskListTagList = (List<TaskListTag>) repository.findAll();
            return taskListTagList;
    }
     
    public Optional<TaskListTag> getTaskListTagById(Long id) {
    	String key = REDIS_KEY + id;
    	
          ValueOperations<String, TaskListTag> operations = redisTemplate.opsForValue();
          boolean hasKey = redisTemplate.hasKey(key);
          
          System.out.println("The value of hasKey============"+hasKey);
        
          if (hasKey) {
        	  TaskListTag  taskListTag = operations.get(key);
        	System.out.println("TaskListTagServiceImpl.findCityById() : From RedisCache >> " + taskListTag.toString());
            return Optional.ofNullable(taskListTag);
          }
          else {
        	 
         Optional<TaskListTag> taskListTag = repository.findById(id);
         System.out.println("TaskListTagServiceImpl.findTaskListTagById() : From DAO >>"+taskListTag.toString());
         TaskListTag taskListTag2 = taskListTag.get();

        // From Dao
          operations.set(key, taskListTag2, 300, TimeUnit.SECONDS);
          return taskListTag;
          }
    }
    
 
    public TaskListTag createOrUpdateTaskListTag(TaskListTag taskListTag) {
    	//System.out.println("TaskListTag SystemId Valiue"+taskListTag.getSystemId());
    	repository.save(taskListTag);
       return taskListTag;
    } 
     
    public void deleteTaskListTagById(Long id) {
        Optional<TaskListTag> taskListTag = repository.findById(id);
    } 
    
    
}