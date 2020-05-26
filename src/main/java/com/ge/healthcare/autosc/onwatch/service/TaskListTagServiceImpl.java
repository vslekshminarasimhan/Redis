package com.ge.healthcare.autosc.onwatch.service;

import java.io.File;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.transform.Result;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import com.ge.healthcare.autosc.onwatch.model.TaskListTag;
import com.ge.healthcare.autosc.onwatch.repository.TaskListTagRepository;

 
@Service
public class TaskListTagServiceImpl implements TaskListTagService {
	
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TaskListTagServiceImpl.class);
	
	private static final String REDIS_KEY = "TaskList_KEY_"; 
	
    @Autowired
    TaskListTagRepository repository;
       
   // @Autowired
   // private RedisTemplate redisTemplate;
    
     @Autowired
     private StringRedisTemplate redisTemplate;
       
     
    public List<TaskListTag> getAllTaskListTags()
    {
        List<TaskListTag> taskListTagList = (List<TaskListTag>) repository.findAll();
            return taskListTagList;
    }
     
 //   public Optional<TaskListTag> getTaskListTagById(Long id) {
    public String getTaskListTagById(Long id) {
    	String key = REDIS_KEY + id;
    	
        //  ValueOperations<String, TaskListTag> operations = redisTemplate.opsForValue();
          
          //Checking for StringXML
          ValueOperations<String, String> operationsStr = redisTemplate.opsForValue();
          
          boolean hasKey = redisTemplate.hasKey(key);
          
          System.out.println("The value of hasKey============"+hasKey);
        
          if (hasKey) {
        	  //TaskListTag  taskListTag = operations.get(key);
        	  String taskListTagStr = operationsStr.get(key);
        	System.out.println("TaskListTagServiceImpl.findCityById() : From RedisCache >> " + taskListTagStr);
        	
           // return Optional.ofNullable(taskListTag);
        	return taskListTagStr;
          }
          else {
        	 
         Optional<TaskListTag> taskListTag = repository.findById(id);
         System.out.println("TaskListTagServiceImpl.findTaskListTagById() : From DAO >>"+taskListTag.toString());
         
         TaskListTag taskListTag2 = taskListTag.get();
         LOGGER.info("======================================");
         LOGGER.info("The value is being picked up from DAO"+taskListTag2);
         LOGGER.info("======================================");

         
         String taskListTagXMLStr = jaxbObjectToXML(taskListTag2);
         

         
        // From Dao
          // before changing to string xml// operations.set(key, taskListTag2, 300, TimeUnit.SECONDS);
         
         //Tyring with String XML Now  and removing the timeout from 300 seconds.
         operationsStr.set(key, taskListTagXMLStr);
      
         
    
          return taskListTagXMLStr;
          }
    }
    
    
    
    
    
    
    
    
    
    public String jaxbObjectToXML(TaskListTag taskListTag) 
    {
    	 String xmlContent="";
        try
        {
            //Create JAXB Context
            JAXBContext jaxbContext = JAXBContext.newInstance(TaskListTag.class);
             
          
            //Create Marshaller
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
 
            //Required formatting??
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
 

            
            //Print XML String to Console
            StringWriter sw = new StringWriter();
             
            //Write XML to StringWriter
            jaxbMarshaller.marshal(taskListTag, sw);
   
      
            
             
            //Verify XML Content
             xmlContent = sw.toString();
            System.out.println("The value of xmlContent String"+ xmlContent );
 
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return xmlContent;
    }
    
    
    
    
    public File jaxbObjectToXMLFile(TaskListTag tasgListTag) {
    

        // convert book object to XML file
       // marshaller.marshal(book, file);
    	
    	
    	File file = new File("taskListTag.xml");
    	 try
         {
             //Create JAXB Context
             JAXBContext jaxbContext = JAXBContext.newInstance(TaskListTag.class);
              
           
             //Create Marshaller
             Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
  
             //Required formatting??
             jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
  

     

              
             //Write XML to File
             jaxbMarshaller.marshal(tasgListTag, file);
         }
    	 catch(Exception e) {}
    	
    	
    	return file;
    	
    	
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