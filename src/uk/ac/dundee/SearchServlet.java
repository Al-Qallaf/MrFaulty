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
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		if (request.getSession().getAttribute("user_object_session") == null)
		{
				RequestDispatcher rd= request.getRequestDispatcher("/login.jsp");
				rd.forward(request, response);
				return;	
		}
		try{
			
			
			String required=null;
			String controller= "";
		
			if (request.getPathInfo() != null)
			{
				required = request.getPathInfo().substring(1);
				if (required.contains("json"))
				{
						controller="json";
				}
			}
			
			ArrayList<Fault> faults = new ArrayList<Fault>();
			faults = FaultService.queryAll();
			request.setAttribute("Faults", faults);

			
			switch (controller) {
			case "json":
				RequestDispatcher rdjson=request.getRequestDispatcher("/generatejson");
				rdjson.forward(request,response);
				break;

			default:
				request.setAttribute("switch", "Pass");
				RequestDispatcher rd= request.getRequestDispatcher("/faultsearch.jsp");
				rd.forward(request, response);
				break;
			} 			}
		catch (Exception e) 
			{
				System.out.println("Error "+ e.getMessage());
			}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{	
		String TheFaultId= request.getParameter("FaultId"); 
		boolean OnlyNumbers= TheFaultId.matches("^[0-9]+$");
		request.setAttribute("Fault", null);
		
		if (OnlyNumbers)
		{
			int Faultid= Integer.parseInt(TheFaultId);
			Fault fault = new Fault();
			fault = FaultService.queryByFaultId(Faultid);
			request.setAttribute("Fault", fault);
			request.setAttribute("switch", "dontpass");	
		}
		
		RequestDispatcher rd= request.getRequestDispatcher("/faultsearch.jsp");
		rd.forward(request, response);
		return;
		
	}

}
