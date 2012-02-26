package uk.ac.dundee;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import uk.ac.dundee.service.LoginService;
import uk.ac.dundee.service.User;

/**
 * Servlet implementation class LoginServlet
 */
//@WebServlet("/login")
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
		//Redirect from servlet to jsp.
		//He I dont want to have content here, you should redirect to main page and which it show the contect.
		if (user != null) // the module is boolean now
		{
			request.getSession().setAttribute("user_object_session", user);
		
			//request.setAttribute("user_object_session", user); //what is the difference here and down on(here error why).
			switch (user.getPrivilege())
			{
				case "administrator":
				{
					System.out.println("You are Administrator..........");	
					response.sendRedirect("/MrFaulty/admdev/"); // we can redirect to servlet(put servlet path)
					return;
				}
				case "reporter":
				{	
					//RequestDispatcher rd= request.getRequestDispatcher("/insert");
					//rd.forward(request, response);
					response.sendRedirect("/MrFaulty/insert"); // we can redirect to servlet(put servlet path)
					return;
				}
				case "developer":
				{
					response.sendRedirect("/MrFaulty/admdev/"); // we can redirect to servlet(put servlet path)
					//RequestDispatcher rd= request.getRequestDispatcher("/MrFaulty/admdev/*");
					//rd.forward(request, response);
					return;
				}
			//User user = LoginService.getUserDetails(theUsername);
			//System.out.println("here "+user.getPassword());
			//return;
			}
		}
		else
		{
			System.out.println(user);
			response.sendRedirect("login.jsp");
		}
	}
}
