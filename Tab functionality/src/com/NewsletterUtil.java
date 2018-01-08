package com;

import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;



public class NewsletterUtil {
	
	
	public static Date convertDate(java.sql.Date date){
		
		Date commentdate =new Date();
	
		
		
		return commentdate;
		
	}
	
	public static List<String> convertParagraphs(String text){
		//String text="As one of the famous quote goes \" A lot of people failed at what you accomplished simply because they were busy finding the problems whereas you were busy finding the solutions.\" \r \n Keep up the spirit and nothing can stop you from reaching the top. My sincere thanks to each one of you for the amazing spirit of team work, commitment and collaboration showcased across several of the critical deliverables we had in the recent past. \r \nI would also like to appreciate the success story of PRISM completing 6 months into the steady state. This was indeed a change we all embarked upon, embracing all the challenges that came our way. Thanks to all those who were directly or indirectly involved in churning this opportunity into success. Bravo. Well done Team! ";
		
		List <String> convertedList= new ArrayList<String>();
	//	String text=leadermessage.getLeaderMessageString().toString();
		
		if(text==null|| text==""){
			
		}
		else{
		String[] paragraphs= text.split("\\|");
		
		convertedList= Arrays.asList(paragraphs);
		}
		return convertedList;
		
	}
	public static String getMonth(){
		String monthString="";
		
		int month = 0;
        java.util.Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        month = cal.get(Calendar.MONTH);// here 0 is considered as jan
        int dayOfMonth=cal.get(Calendar.DAY_OF_MONTH);
      
        System.out.println("day of month" +dayOfMonth);
        
        if(month==0){
        	if(dayOfMonth<=10){
        	month=11-1;
        	}
        	else{
        		month=11;
        	}
        	
        }
        else{
        	if(dayOfMonth<=10){
        		month=month-2;
        	}
        	else{
        		 month = month - 1;
        	}
       
        }
        DateFormatSymbols dfs = new DateFormatSymbols();
        String[] months = dfs.getMonths();
        if (month >= 0 && month <= 11 ) {
            monthString = months[month];
        }
		System.out.println(" month" +monthString);
		return monthString;
		
		
	}
	public static List<String> getAreas(List<String> areas){
		
		Set<String> uniqueAreaList=new HashSet<>();
		uniqueAreaList.addAll(areas);
		areas.clear();
		areas.addAll(uniqueAreaList);
		System.out.println("unique areas" +areas.toString());
		
			  
		return areas;
		
		
	}
	public static String convertStringWithoutSpaces(String text){
		
		String convertedString="";
	convertedString=text.replaceAll("\\s", "");
	
	System.out.println("convereted String" +convertedString);
		
		return convertedString;
		
		
	}
	public static List<String> convertParagraphsToList(String text){
		//String text="As one of the famous quote goes \" A lot of people failed at what you accomplished simply because they were busy finding the problems whereas you were busy finding the solutions.\" \r \n Keep up the spirit and nothing can stop you from reaching the top. My sincere thanks to each one of you for the amazing spirit of team work, commitment and collaboration showcased across several of the critical deliverables we had in the recent past. \r \nI would also like to appreciate the success story of PRISM completing 6 months into the steady state. This was indeed a change we all embarked upon, embracing all the challenges that came our way. Thanks to all those who were directly or indirectly involved in churning this opportunity into success. Bravo. Well done Team! ";
		
		List <String> convertedList= new ArrayList<String>();
	//	String text=leadermessage.getLeaderMessageString().toString();
		
		if(text==null|| text==""){
			
		}
		else{
		String[] paragraphs= text.split("\\s*& \\s*");
		
		convertedList= Arrays.asList(paragraphs);
		}
		return convertedList;
		
	}
	public static String getPreviousMonth(String month){
		
		
		Date date = null;
		try {
			date = new SimpleDateFormat("MMMM").parse(month);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		System.out.println("hello");
		System.out.println("in util"+cal.get(Calendar.MONTH));
		return month;
		
	}

}
