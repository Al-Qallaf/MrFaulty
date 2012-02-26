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
 * Servlet implementation class InsertFault
 */

public class InsertFault extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertFault() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
/*		ArrayList<Fault> faults = new ArrayList<Fault>();
		//faults = FaultService.query(theUserId);
		faults = FaultService.query(3);
		request.setAttribute("Faults", faults);
		//Iterator<Fault> iterator;
		//iterator = faults.iterator();
		//Fault fault;
		
		//while (iterator.hasNext())
		//{
		//	fault = (Fault)iterator.next();
		//	System.out.println("Data from iterator " + fault.getAction()+"   " + fault.getUserid());
		//	
		//}
		System.out.println("I'm in InsertFault, in doGet");
		RequestDispatcher rd= request.getRequestDispatcher("/reporter.jsp");
		rd.forward(request, response);
		//response.sendRedirect("reporter.jsp");
*/	
		User user= (User)  request.getSession().getAttribute("user_object_session");

		ArrayList<Fault> faults = new ArrayList<Fault>();
		faults = FaultService.queryByUserId(user.getUserId());
		request.setAttribute("Faults", faults);
		//Iterator<Fault> iterator;
		//iterator = faults.iterator();
		//Fault fault;
		
		//while (iterator.hasNext())
		//{
		//	fault = (Fault)iterator.next();
		//	System.out.println("Data from iterator " + fault.getAction()+"   " + fault.getUserid());
		//}
		System.out.println("I'm in InsertFault servlet, doGet");
		RequestDispatcher rd= request.getRequestDispatcher("/reporter.jsp");
		rd.forward(request, response);
		//return;
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String theUsername, theProject, theRelease, theSummary, theDetails;
		int theUserId;
		
		User user= (User)  request.getSession().getAttribute("user_object_session");
		theUserId = user.getUserId();
		
		//theUsername = request.getParameter("username"); no need for this
		theProject = request.getParameter("project");
		theRelease = request.getParameter("version");
		theSummary = request.getParameter("summary");
		theDetails = request.getParameter("details");
		
		
		Fault newf = new Fault();
		newf.setUserid(theUserId);
		newf.setProject(theProject); // put list loaded from db 
		newf.setRelease(theRelease);
		newf.setSummary(theSummary);
		newf.setDetails(theDetails);
		newf.setState("New");
		
		FaultService fs = new FaultService();
		fs.insert(newf);
		//request.getSession().setAttribute("user_object_session", user); no need but maybe later.
		//System.out.println("in the session is this user id " + user.getUserId());
		System.out.println("I'm in InsertFault servlet, doPost");
		//RequestDispatcher rd= request.getRequestDispatcher("/reporter.jsp");
		//rd.forward(request, response);
		System.out.println("in the session is this user id " + user.getPrivilege());
		if (user.getPrivilege().equals("administrator"))
		{
			response.sendRedirect("/MrFaulty/admdev/");
			return;
		}
		response.sendRedirect("/MrFaulty/insert");
		//return;
	}

}
