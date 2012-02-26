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

/**
 * Servlet implementation class Adm_Dev_main
 */

public class Adm_Dev_main extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Adm_Dev_main() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{	
		/*String reqired = request.getPathInfo().substring(1);
		System.out.println("Hathaaaaa elly dakhel el pathinfo----> "+reqired);	
		boolean OnlyNumbers= reqired.matches("^[0-9]+$");
		if (OnlyNumbers)
		{
			System.out.println("The click number " + OnlyNumbers +" The number is"+ reqired);
			
		}
		else
		{
			switch (reqired)
			{
				case "addfault":
				{
					//RequestDispatcher rd= request.getRequestDispatcher("/addfault.jsp");
					//rd.forward(request, response);
					//return;
					response.sendRedirect("/MrFaulty/insert");
					return;
				}
				case "updatefault":
				{	
					//RequestDispatcher rd= request.getRequestDispatcher("/insert");
					//rd.forward(request, response);
					response.sendRedirect("/MrFaulty/insert");
					return;
				}
				case "deletefault":
				{
					//response.sendRedirect("/MrFaulty/deletefault.jsp");
					System.out.println("Ana inside delete");
					RequestDispatcher rd= request.getRequestDispatcher("/delete/");
					rd.forward(request, response);
					return;
				}
			}
		}*/
		
		User user= (User)  request.getSession().getAttribute("user_object_session");
		
		ArrayList<Fault> faults = new ArrayList<Fault>();
		faults = FaultService.queryByUserId(user.getUserId());
		request.setAttribute("Faults", faults);
		
		System.out.println("I'm in doGet in Adm_Dev_main");
		RequestDispatcher rd= request.getRequestDispatcher("/dev_admin.jsp");
		rd.forward(request, response);
		//return;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
