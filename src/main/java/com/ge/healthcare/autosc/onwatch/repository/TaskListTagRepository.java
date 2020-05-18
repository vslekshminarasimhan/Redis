package com.ge.healthcare.autosc.onwatch.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ge.healthcare.autosc.onwatch.model.TaskListTag;



 
@Repository
public interface TaskListTagRepository  extends CrudRepository<TaskListTag, Long> {
	
}