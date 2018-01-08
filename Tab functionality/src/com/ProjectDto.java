package com;

import java.util.ArrayList;
import java.util.List;

public class ProjectDto {
	
	private String projectName;
	private String projectDescription;
	private String currentStatus;
	private String area;
	private List<String> projectDescriptionList= new ArrayList<String>();
	
	private List<String> currentStatusList=new ArrayList<String>();
	
	
	
	
	
	
	public List<String> getCurrentStatusList() {
		return currentStatusList;
	}
	public void setCurrentStatusList(List<String> currentStatusList) {
		this.currentStatusList = currentStatusList;
	}

	
	public List<String> getProjectDescriptionList() {
		return projectDescriptionList;
	}
	public boolean setProjectDescriptionList(List<String> projectDescriptionList) {
		this.projectDescriptionList = projectDescriptionList;
		return false;
	}
	public String getCurrentStatus() {
		return currentStatus;
	}
	public void setCurrentStatus(String currentStatus) {
		this.currentStatus = currentStatus;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getProjectDescription() {
		return projectDescription;
	}
	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}
	@Override
	public String toString() {
		return "ProjectDto [projectName=" + projectName
				+ ", projectDescription=" + projectDescription
				+ ", currentStatus=" + currentStatus + ", area=" + area
				+ ",  projectDescriptionList="
				+ projectDescriptionList + "]";
	}
	
	 

}
