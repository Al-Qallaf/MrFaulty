<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256" import="java.util.*" import="uk.ac.dundee.service.*" import="uk.ac.dundee.testservlet"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Test area</title>
</head>
<body>
<%
		ArrayList<Fault> faultss = new ArrayList<Fault>();
		//faults = FaultService.query(theUserId);
		//faultss = FaultService.query(3);
		faultss = (ArrayList<Fault>) request.getAttribute("Faults");
		Iterator<Fault> iterator;
		iterator = faultss.iterator();
		Fault fault;
		while (iterator.hasNext())
		{
			fault = (Fault)iterator.next();
				%>
			<table>
			    <tr> <td><a href="/MrFaulty/testservlet/<%=fault.getFaultid()%>" id="3" name="fid"><%=fault.getFaultid()%> </a></td> 
			    	 <td><%=fault.getProject()%> </td>
			    	 <td><%=fault.getRelease()%> </td>
			    	 <td><%=fault.getSummary()%> </td>
			    	 <td><%=fault.getState()%> </td>
			    </tr>
			</table>
	<%	}
%>
</body>
</html>