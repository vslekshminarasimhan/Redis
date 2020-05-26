package com.ge.healthcare.autosc.onwatch.model;

import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TBL_TASKLISTTAG")
//@JacksonXmlRootElement(localName = "AutoSC")
@XmlRootElement
public class TaskListTag implements Serializable {
	
	private static final long serialVersionUID = -1L;



	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
    private Long id;
	
	
	@Column(name="systemid")
    private String systemId;
	
    
    @Column(name="modeltype")
    private String modelType;

    @Column(name="iipversion")
    private String iipVersion;
    
    @Column(name="taskliststatus")
    private String taskListStatus;
    
    @Column(name="failed")
    private boolean failed;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSystemId() {
		return systemId;
	}

	public void setSystemId(String systemId) {
		this.systemId = systemId;
	}

	public String getModelType() {
		return modelType;
	}

	public void setModelType(String modelType) {
		this.modelType = modelType;
	}

	public String getIipVersion() {
		return iipVersion;
	}

	public void setIipVersion(String iipVersion) {
		this.iipVersion = iipVersion;
	}

	public String getTaskListStatus() {
		return taskListStatus;
	}

	public void setTaskListStatus(String taskListStatus) {
		this.taskListStatus = taskListStatus;
	}

	public boolean isFailed() {
		return failed;
	}

	public void setFailed(boolean failed) {
		this.failed = failed;
	}

    
}

