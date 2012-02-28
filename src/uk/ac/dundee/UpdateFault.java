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


public class UpdateFault extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateFault() {
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
		ArrayList<User> listusers = new ArrayList<User>();
		listusers = LoginService.ListUserType("developer");
		request.setAttribute("Users", listusers);
	
		RequestDispatcher rd= request.getRequestDispatcher("updatefault.jsp");
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try
		{
		String TheFaultId= request.getParameter("FaultId"); 
		boolean OnlyNumbers= TheFaultId.matches("^[0-9]+$");
		String project, version, summary; 
		
		if (OnlyNumbers)
		{	
			int Faultid= Integer.parseInt(TheFaultId);
			Fault fault = new Fault();
			fault = FaultService.queryByFaultId(Faultid);

			
			if (request.getParameter("project") != "" )
				fault.setProject(request.getParameter("project").toString());
				
			if (request.getParameter("version").toString() != "")
				fault.setRelease(request.getParameter("version").toString());
			
			if (request.getParameter("summary") != "")
				fault.setSummary(request.getParameter("summary").toString());
			
			if (request.getParameter("details").toString() != "")
				fault.setDetails(request.getParameter("details").toString());
			
			if (request.getParameter("status").toString() != "")
				fault.setState(request.getParameter("status").toString());
				
			if (request.getParameter("action").toString() != "")
				fault.setAction(request.getParameter("action").toString());			
										
			if (request.getParameter("investigated_by").toString() != "")
				fault.setInvestigated_by(request.getParameter("investigated_by").toString());
			boolean updatedFault;
			updatedFault= FaultService.update(fault);
			System.out.println(updatedFault);
		}
		
		ArrayList<User> listusers = new ArrayList<User>();
		listusers = LoginService.ListUserType("developer");
		request.setAttribute("Users", listusers);
		
		RequestDispatcher rd= request.getRequestDispatcher("updatefault.jsp");
		rd.forward(request, response);
		return;
		}
		catch (Exception e) 
		{
			System.out.println("catch---->"+ e.getMessage() );
		}
	}

}
