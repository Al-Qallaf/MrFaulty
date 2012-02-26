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



public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;  

    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		if (request.getPathInfo() != null)
		{
			String reqired = request.getPathInfo().substring(1);
			System.out.println("Hathaaa men fog "+reqired);	
		}
		System.out.println("I'm in doGet in SearchServlet......");
		ArrayList<Fault> faults = new ArrayList<Fault>();
		faults = FaultService.queryAll();
		request.setAttribute("Faults", faults);
		
		request.setAttribute("switch", "Pass");
		RequestDispatcher rd= request.getRequestDispatcher("/faultsearch.jsp");
		rd.forward(request, response);
		return;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("I'm in doPost in SearchServlet......");
		//String reqired = request.getPathInfo().substring(1);	
		String TheFaultId= request.getParameter("FaultId"); 
		boolean OnlyNumbers= TheFaultId.matches("^[0-9]+$");
		request.setAttribute("Fault", null);
		
		if (OnlyNumbers)
		{
			System.out.println(" ");
			int Faultid= Integer.parseInt(TheFaultId);
			Fault fault = new Fault();
			fault = FaultService.queryByFaultId(Faultid);
			request.setAttribute("Fault", fault);
			request.setAttribute("switch", "dontpass");
			System.out.println("the returned value is "+ request.getAttribute("Fault"));	
		}
		
		System.out.println("I'm in doPost in SearchServlet, Going now to dispatcher..");
		RequestDispatcher rd= request.getRequestDispatcher("/faultsearch.jsp");
		rd.forward(request, response);
		return;
		
	}

}
