package uk.ac.dundee;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import uk.ac.dundee.service.LoginService;
import uk.ac.dundee.service.User;


public class ListUsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ListUsersServlet() {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		if (request.getSession().getAttribute("user_object_session") == null)
		{
				RequestDispatcher rd= request.getRequestDispatcher("/login.jsp");
				rd.forward(request, response);
				return;	
		}
		request.setAttribute("TheUsers", null);
		RequestDispatcher rd= request.getRequestDispatcher("/listusers.jsp");
		rd.forward(request, response);
		return;
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String showbutton = request.getParameter("userPrivilege");
		
		if ( showbutton != null  ||  showbutton != "" ) 
		{
			String TheUserPrivilege= showbutton;
			System.out.println("The parameter is" + TheUserPrivilege);
			
			ArrayList<User> listusers = new ArrayList<User>();
			listusers = LoginService.ListUserType(TheUserPrivilege);
			request.setAttribute("TheUsers", listusers);					
		}
		
		RequestDispatcher rd= request.getRequestDispatcher("/listusers.jsp");
		rd.forward(request, response);
		return;
		
	}

}
