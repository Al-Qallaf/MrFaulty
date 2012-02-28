package uk.ac.dundee;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import uk.ac.dundee.service.LoginService;
import uk.ac.dundee.service.User;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		RequestDispatcher rd= request.getRequestDispatcher("/login.jsp");
		rd.forward(request, response);
		return;
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String theUsername, thePassword;
		
		theUsername = request.getParameter("userId");
		thePassword = request.getParameter("password");
		
		LoginService checkloginValidity = new LoginService();
		User user = checkloginValidity.authenticate(theUsername, thePassword);
	
		if (user != null)
		{
			request.getSession().setAttribute("user_object_session", user);
		
			switch (user.getPrivilege())
			{
				case "administrator":
				{
					response.sendRedirect("/MrFaulty/admdev/"); 
					return;
				}
				case "reporter":
				{	
					response.sendRedirect("/MrFaulty/insert");
					return;
				}
				case "developer":
				{
					response.sendRedirect("/MrFaulty/admdev/"); 
					return;
				}
			}
		}
		else
		{
			System.out.println(user);
			response.sendRedirect("login.jsp");
		}
	}
}
