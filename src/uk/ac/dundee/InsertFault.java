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
       
 
    public InsertFault() {
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
		User user= (User)  request.getSession().getAttribute("user_object_session");
		
		if (request.getSession().getAttribute("user_object_session") == null)
		{
				RequestDispatcher rd= request.getRequestDispatcher("/login.jsp");
				rd.forward(request, response);
				return;	
		}
		
		ArrayList<Fault> faults = new ArrayList<Fault>();
		faults = FaultService.queryByUserId(user.getUserId());
		request.setAttribute("Faults", faults);
		
		RequestDispatcher rd= request.getRequestDispatcher("/reporter.jsp");
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String theProject, theRelease, theSummary, theDetails;
		int theUserId;
		
		User user= (User)  request.getSession().getAttribute("user_object_session");
		theUserId = user.getUserId();
		
		theProject = request.getParameter("project");
		theRelease = request.getParameter("version");
		theSummary = request.getParameter("summary");
		theDetails = request.getParameter("details");
		
		
		Fault newf = new Fault();
		newf.setUserid(theUserId);
		newf.setProject(theProject);
		newf.setRelease(theRelease);
		newf.setSummary(theSummary);
		newf.setDetails(theDetails);
		newf.setState("New");
		
		FaultService fs = new FaultService();
		fs.insert(newf);
		
		if (user.getPrivilege().equals("administrator"))
		{
			response.sendRedirect("/MrFaulty/admdev/");
			return;
		}
		response.sendRedirect("/MrFaulty/insert");
		
	}

}
