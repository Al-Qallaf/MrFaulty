package uk.ac.dundee;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import uk.ac.dundee.service.Fault;
import uk.ac.dundee.service.FaultService;



public class FaultDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FaultDetails() {
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
    	String TheFaultId = request.getPathInfo().substring(1);
		boolean OnlyNumbers= TheFaultId.matches("^[0-9]+$");
		if (OnlyNumbers)
		{
			System.out.println("The click number " + OnlyNumbers +" The number is"+ TheFaultId);
			
			int theId = Integer.parseInt(TheFaultId);
			Fault thefault = new Fault();
			thefault= FaultService.queryByFaultId(theId);
			request.setAttribute("FaultDetails", thefault);
			
		}
		
		RequestDispatcher rd= request.getRequestDispatcher("/details.jsp");
		rd.forward(request, response);
	
	}
}