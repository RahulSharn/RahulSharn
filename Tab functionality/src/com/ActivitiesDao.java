package com;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

import com.ProjectDto;



public class ActivitiesDao {
	

	

public static List<ProjectDto> getActivitiesDetails(){
	
	List<ProjectDto> activities=new ArrayList<ProjectDto>();
	
	Connection conn=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	
	try {
		
		conn=DBConnector.getConnection();
		ps=conn.prepareStatement("SELECT * FROM RAHUL.ACTIVITIES");
		
		rs=ps.executeQuery();
		if(rs!=null){
			while(rs.next()){
				ProjectDto activity=new ProjectDto();
				activity.setArea((rs.getString("AREA")).toUpperCase());
				
				activity.setCurrentStatus(rs.getString("CURRENTSTATUS"));
				
				activity.setProjectDescription(rs.getString("PROJECTDESCRIPTION"));
				activity.setProjectName(rs.getString("PROJECTNAME"));
				
				activities.add(activity);			
				
		
	}}
	}catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	finally{
		try {
			DBConnector.closeConnection(conn);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	return activities;
	
	

	

	



	
		
	

}
}