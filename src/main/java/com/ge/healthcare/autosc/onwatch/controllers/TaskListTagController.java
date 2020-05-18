package com.ge.healthcare.autosc.onwatch.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ge.healthcare.autosc.onwatch.model.TaskListTag;
import com.ge.healthcare.autosc.onwatch.service.TaskListTagService;
 

 
@RestController
@RequestMapping("/api")
public class TaskListTagController {
	
    @Autowired
    TaskListTagService service;
 
    @GetMapping("/tasklisttags")
    public ResponseEntity<List<TaskListTag>> getAllTaskListTags() {
        List<TaskListTag> list = service.getAllTaskListTags();
        return new ResponseEntity<List<TaskListTag>>(list, new HttpHeaders(), HttpStatus.OK);
    }
 
    @GetMapping("/tasklisttags/{id}")
    public Optional<TaskListTag> getTaskListTagById(@PathVariable("id") Long id) {
    	Optional<TaskListTag> taskListTag = service.getTaskListTagById(id);
        return taskListTag;
    }
 
    @PostMapping("/tasklisttags")
    public TaskListTag createOrUpdateTaskListTag(@RequestBody TaskListTag taskListTag) {
    
    	TaskListTag taskListTagDetails = service.createOrUpdateTaskListTag(taskListTag);
        return taskListTagDetails;
    }
 
    @DeleteMapping("/{id}")
    public HttpStatus[] deleteTaskListTagById(@PathVariable("id") Long id) {
        service.deleteTaskListTagById(id);
        return HttpStatus.values();
    }
 
}