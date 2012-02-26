<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256" import="uk.ac.dundee.service.Fault"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1256">
<title>Delete Fault</title>
</head>
<body>
	<form action="delete" method="POST">
		<input type="text" name="FaultId"> 
		<input type="submit" value="Find Fault">
	</form>
	<%
		String signal = (String) request.getAttribute("control");
	    System.out.println("Ooooooooo"+ signal);
	    if (signal.toString() == "doPost")
	    {
		Fault fault = new Fault();
		fault = (Fault) request.getAttribute("theFault");
	%>
	<table>
		<tr>
			<td><a href="/MrFaulty/delete/<%=fault.getFaultid()%>">Delete</a></td>
			<td><%=fault.getProject()%></td>
			<td><%=fault.getRelease()%></td>
			<td><%=fault.getSummary()%></td>
			<td><%=fault.getState()%></td>
		</tr>
	</table>
	<%}%>
</body>
</html>