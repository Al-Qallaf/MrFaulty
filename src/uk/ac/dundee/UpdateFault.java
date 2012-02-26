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

/**
 * Servlet implementation class UpdateFault
 */
//@WebServlet("/UpdateFault")
public class UpdateFault extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateFault() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		ArrayList<User> listusers = new ArrayList<User>();
		listusers = LoginService.ListUserType("developer");
		request.setAttribute("Users", listusers);
	
		RequestDispatcher rd= request.getRequestDispatcher("updatefault.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		System.out.println("I'm in doPost in SearchServlet......");
		try
		{
		String TheFaultId= request.getParameter("FaultId"); 
		boolean OnlyNumbers= TheFaultId.matches("^[0-9]+$");
		//request.setAttribute("Fault", null);
		
		if (OnlyNumbers)
		{	
			System.out.println(" it is number ");
			int Faultid= Integer.parseInt(TheFaultId);
			Fault fault = new Fault();
			fault = FaultService.queryByFaultId(Faultid);
			//request.setAttribute("Fault", fault);
			//request.setAttribute("switch", "dontpass");
			System.out.println("the returned value is "+ request.getParameter("Fault"));
			
			if (request.getParameter("project").toString() != null )
				fault.setProject(request.getParameter("project").toString());
				
			if (request.getParameter("version").toString() != null)
				fault.setRelease(request.getParameter("version").toString());
			
			if (request.getParameter("summary").toString() != null)
				fault.setSummary(request.getParameter("summary").toString());
			
			if (request.getParameter("details").toString() != null)
				fault.setDetails(request.getParameter("details").toString());
			
			if (request.getParameter("status").toString() != null)
				fault.setState(request.getParameter("status").toString());
				
			if (request.getParameter("action").toString() != null)
				fault.setAction(request.getParameter("action").toString());			
										
			if (request.getParameter("investigated_by").toString() != null)
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

	
	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		System.out.println("I'm in Puttttt");
		
	}

}
