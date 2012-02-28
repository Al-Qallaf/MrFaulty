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


public class AssignFaultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;   
 
    public AssignFaultServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		if (request.getSession().getAttribute("user_object_session") == null)
		{
				RequestDispatcher rd= request.getRequestDispatcher("login.jsp");
				rd.forward(request, response);
				return;	
		}
		request.setAttribute("switch", "Pass");
		RequestDispatcher rd= request.getRequestDispatcher("/assignfault.jsp");
		rd.forward(request, response);
		return;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		String Findbutton = request.getParameter("Find");
		String AssignButton = request.getParameter("Assign");
		System.out.println("It's "+ AssignButton + "     It's "+ Findbutton);
		
		if ( request.getParameter("Find") != null )
		{
			String TheFaultId= request.getParameter("FaultId");
			System.out.println("The new parameter is" + request.getParameter("investigated_by"));
			boolean OnlyNumbers= TheFaultId.matches("^[0-9]+$");
			request.setAttribute("Fault", null);
			request.getSession().setAttribute("fault_Id_session", TheFaultId);
			
			if (OnlyNumbers)
			{
				int Faultid= Integer.parseInt(TheFaultId);
				Fault fault = new Fault();
				fault = FaultService.queryByFaultId(Faultid);
				request.setAttribute("Fault", fault);
				request.setAttribute("switch", "dontpass");
				System.out.println("the returned value is "+ request.getAttribute("Fault"));
				
				ArrayList<User> listdevusers = new ArrayList<User>();
				listdevusers = LoginService.ListUserType("developer");
				//request.setAttribute("DevUsers", listdevusers);
				
				ArrayList<User> listadmusers = new ArrayList<User>();
				listadmusers = LoginService.ListUserType("administrator");
				//request.setAttribute("AdmUsers", listadmusers);
				
				ArrayList<User> newList = new ArrayList<User>();
				newList.addAll(listdevusers);
				newList.addAll(listadmusers);
				request.setAttribute("Users", newList);	
			}
		}
		
		if ( request.getParameter("Assign") != null )
		{
			String TheFaultId= (String) request.getSession().getAttribute("fault_Id_session");
		
			int TheFid = Integer.parseInt(TheFaultId);
			
			FaultService fs = new FaultService();
			Fault faulty= new Fault();
			faulty=fs.queryByFaultId(TheFid);
			
			faulty.setInvestigated_by(request.getParameter("investigated_by"));
			fs.update(faulty);
			
			
		}
		
		
		RequestDispatcher rd= request.getRequestDispatcher("/assignfault.jsp");
		rd.forward(request, response);
		return;
	}

}
