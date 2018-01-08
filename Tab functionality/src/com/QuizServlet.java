package com;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;




import com.ActivitiesDao;
import com.ProjectDto;

/**
 * Servlet implementation class QuizServlet
 */
@WebServlet("/QuizServlet")
public class QuizServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuizServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<ProjectDto> act=new ArrayList<ProjectDto>();
		act=ActivitiesDao.getActivitiesDetails();
		JSONArray jsonarray= new JSONArray();
		
		for(int i=0;i<act.size();i++)
		{
			JSONObject obj = new JSONObject();
			//obj.put("issueno", quiz.get(i).getIssueno());
			obj.put("projectName",act.get(i).getProjectName());
			
			String text=act.get(i).getProjectDescription();
			obj.put("projectDescription",act.get(i).getProjectDescription());
			obj.put("currentStatus", act.get(i).getCurrentStatus());
			obj.put("area", act.get(i).getArea());
			
			jsonarray.put(obj);
				
		}
		System.out.println("Json in Servelt"+ jsonarray.toString());
		
	    response.getWriter().print(jsonarray.toString());
		}

}
