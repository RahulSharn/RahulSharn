package com;

import java.util.ArrayList;
import java.util.List;

import com.ActivitiesDao;
import com.NewsletterUtil;
import com.ProjectDto;
import com.opensymphony.xwork2.ActionSupport;

public class ActivitiesAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String success= "SUCCESS";
	
	List<ProjectDto> activities=new ArrayList<ProjectDto>();
	ProjectDto activity= new ProjectDto();
	
	List <String> uniqueAreas= new ArrayList<String>();
	public String execute(){
		
		activities= ActivitiesDao.getActivitiesDetails();
		
		for(int i=0; i<activities.size();i++){
			String Area=activities.get(i).getArea();
			String text= activities.get(i).getProjectDescription().toString();
			String currentStatus=activities.get(i).getCurrentStatus().toString();
			activities.get(i).setProjectDescriptionList(NewsletterUtil.convertParagraphs(text));
			activities.get(i).setCurrentStatusList(NewsletterUtil.convertParagraphs(currentStatus));
			uniqueAreas.add(Area);
			
		}
		
		
		uniqueAreas=NewsletterUtil.getAreas(uniqueAreas);
		
		System.out.println("actvities" +activities.toString());
		
		
		
		
		return success;
	
	}
	
	public ProjectDto getActivity() {
		return activity;
	}

	public void setActivity(ProjectDto activity) {
		this.activity = activity;
	}

	public String getSuccess() {
		return success;
	}
	public void setSuccess(String success) {
		this.success = success;
	}
	public List<ProjectDto> getActivities() {
		return activities;
	}
	public void setActivities(List<ProjectDto> activities) {
		this.activities = activities;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<String> getUniqueAreas() {
		return uniqueAreas;
	}

	public void setUniqueAreas(List<String> uniqueAreas) {
		this.uniqueAreas = uniqueAreas;
	}

	
}
