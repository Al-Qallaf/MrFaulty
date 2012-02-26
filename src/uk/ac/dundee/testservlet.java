package uk.ac.dundee;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import uk.ac.dundee.service.Fault;
import uk.ac.dundee.service.FaultService;


public class testservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Object Integer = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public testservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String reqired = request.getPathInfo().substring(1);
		boolean OnlyNumbers= reqired.matches("^[0-9]+$");
		
		//try
		if (OnlyNumbers)
		{
			System.out.println("The click number " + OnlyNumbers);
			
			
		}
		
		ArrayList<Fault> faults = new ArrayList<Fault>();
		faults = FaultService.queryByUserId(4);
		request.setAttribute("Faults", faults);
		//Iterator<Fault> iterator;
		//iterator = faults.iterator();
		//Fault fault;
		
		//while (iterator.hasNext())
		//{
		//	fault = (Fault)iterator.next();
		//	System.out.println("Data from iterator " + fault.getAction()+"   " + fault.getUserid());
		//}
		//System.out.println("I'm in servlet "+ request.getPathTranslated());
		RequestDispatcher rd= request.getRequestDispatcher("/test.jsp");
		rd.forward(request, response);
		return;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
}
