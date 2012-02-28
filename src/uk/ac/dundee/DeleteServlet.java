package uk.ac.dundee;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import uk.ac.dundee.service.Fault;
import uk.ac.dundee.service.FaultService;


public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public DeleteServlet() {
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
		try
		{
			String FaultId = request.getPathInfo().substring(1);
			boolean OnlyNumbers= FaultId.matches("^[0-9]+$");
			if (OnlyNumbers)
			{
				FaultService fs= new FaultService();
				fs.delete(Integer.parseInt(FaultId));	
			}
		request.setAttribute("control", "doGet");
		 
		RequestDispatcher rd= request.getRequestDispatcher("/deletefault.jsp");
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
		String TheFaultId= request.getParameter("FaultId"); 
		boolean OnlyNumbers= TheFaultId.matches("^[0-9]+$");
		request.setAttribute("Fault", null);
		
		if (OnlyNumbers)
			{
			int Faultid= Integer.parseInt(TheFaultId);
			Fault fault = new Fault();
			fault = FaultService.queryByFaultId(Faultid);
			request.setAttribute("theFault", fault);	
			}
		
		RequestDispatcher rd= request.getRequestDispatcher("/deletefault.jsp");
		rd.forward(request, response);
		return;
		}
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
		}
	}
}
