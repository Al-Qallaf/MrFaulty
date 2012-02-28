package uk.ac.dundee.service;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    public Logout() {
        super();
    
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		request.getSession().setAttribute("user_object_session", null);
		RequestDispatcher rd= request.getRequestDispatcher("/login.jsp");
		rd.forward(request, response);
		return;
	}

}
