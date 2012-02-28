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
import uk.ac.dundee.service.User;



public class Adm_Dev_main extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Adm_Dev_main() {
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
		
		ArrayList<Fault> faults = new ArrayList<Fault>();
		faults = FaultService.queryNewFaults();
		request.setAttribute("Faults", faults);
		
		System.out.println("I'm in doGet in Adm_Dev_main");
		RequestDispatcher rd= request.getRequestDispatcher("/dev_admin.jsp");
		rd.forward(request, response);
		
	}

}
