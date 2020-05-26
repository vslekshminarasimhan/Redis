package com.ge.healthcare.autosc.onwatch.service;


import java.util.List;
import java.util.Optional;

import com.ge.healthcare.autosc.onwatch.model.TaskListTag;



public interface TaskListTagService {
	
	  
    public List<TaskListTag> getAllTaskListTags();
   // public Optional<TaskListTag> getTaskListTagById(Long id);
    public String getTaskListTagById(Long id);
    public TaskListTag createOrUpdateTaskListTag(TaskListTag taskListTag);
    public void deleteTaskListTagById(Long id);
   
   
}
