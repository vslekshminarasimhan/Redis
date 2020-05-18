package com.ge.healthcare.autosc.onwatch.model;

import javax.persistence.Table;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TBL_TASKLISTTAG")
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














/*public class TaskListTag {
	
	private static final long serialVersionUID = -1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
    private Long id;
    
    
    @Column(name="province")
    private String province;

    @Column(name="city")
    private String cityName;

 
    @Column(name="description")
	private String description;
   
    public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

	

}
*/