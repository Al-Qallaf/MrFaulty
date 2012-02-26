package uk.ac.dundee;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import uk.ac.dundee.service.LoginService;
import uk.ac.dundee.service.User;


public class DeleteUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DeleteUserServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try
		{
			String UserId = request.getPathInfo().substring(1);
			System.out.println("Hathaaa awal shay "+UserId);	
			boolean OnlyNumbers= UserId.matches("^[0-9]+$");
			if (OnlyNumbers)
			{
				LoginService ls= new LoginService();
				ls.deleteuser(Integer.parseInt(UserId));	
			}
		request.setAttribute("control", "doGet");
		 
		RequestDispatcher rd= request.getRequestDispatcher("/deleteuser.jsp");
		rd.forward(request, response);
		return;
		}
		catch (Exception e) 
		{
			System.out.println("error -->" + e.getMessage());	
		}	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try
		{
		request.setAttribute("control", "doPost");
		String TheUserId= request.getParameter("UserId"); 
		boolean OnlyNumbers= TheUserId.matches("^[0-9]+$");
		//request.setAttribute("", null);
		
		if (OnlyNumbers)
			{
			int Userid= Integer.parseInt(TheUserId);
			User user = new User();
			user = LoginService.queryByUserId(Userid);
			request.setAttribute("theUser", user);
			System.out.println("the returned value is "+ request.getAttribute("UserId"));	
			}
		
		RequestDispatcher rd= request.getRequestDispatcher("/deleteuser.jsp");
		rd.forward(request, response);
		return;
		}
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
		}
	
	}

}
