package uk.ac.dundee;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import uk.ac.dundee.service.Fault;
import uk.ac.dundee.service.FaultService;
import uk.ac.dundee.service.LoginService;
import uk.ac.dundee.service.User;



public class SearchUserFault extends HttpServlet {
	private static final long serialVersionUID = 1L;  

    public SearchUserFault() {
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
		RequestDispatcher rd= request.getRequestDispatcher("/searchuserfault.jsp");
		rd.forward(request, response);
		return;
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{	
		String TheUserId= request.getParameter("userid"); 
		boolean OnlyNumbers= TheUserId.matches("^[0-9]+$");
		request.setAttribute("Fault", null);
		
		if (OnlyNumbers)
		{
			int Userid= Integer.parseInt(TheUserId);
			User theuser= new User();
			theuser= LoginService.queryByUserId(Userid);
			request.setAttribute("user", theuser);
			
			ArrayList<Fault> faults = new ArrayList<Fault>();
			faults = FaultService.queryByUserId(Userid);
			request.setAttribute("faults", faults);	
		}
		
		RequestDispatcher rd= request.getRequestDispatcher("/searchuserfault.jsp");
		rd.forward(request, response);
		return;
		
	}

}
