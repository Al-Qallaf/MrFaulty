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
 * Servlet implementation class AddUser
 */

public class AddUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		RequestDispatcher rd= request.getRequestDispatcher("adduser.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		User newUser = new User();
		
		newUser.setUserName(request.getParameter("UserName"));
		newUser.setFirst_Name(request.getParameter("FirstName"));
		newUser.setLast_Name(request.getParameter("LastName"));
		newUser.setPassword(request.getParameter("Password1"));
		newUser.setEmail(request.getParameter("Email"));
		newUser.setPrivilege(request.getParameter("Privilege"));
		
		boolean create;
		LoginService NU = new LoginService();
		create=NU.adduser(newUser);
		
		response.sendRedirect("/MrFaulty/adduser");
		return;
		
	}

}
