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
	<h1 align="center">MR Faulty</h1>
	<p align="right"><a href="/MrFaulty/logout" style=" text-align: right;">Logout</a></p>
	<hr>
		<a href="/MrFaulty/admdev/">Back</a>
	<br>
	<form action="delete" method="POST">
		<label>Enter Fault ID :</label>
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
	<table border="1">
			<thead>
		<tr>
			<th scope="col">Fault ID
				&nbsp;</th>
			<th scope="col">Project
				&nbsp;</th>
			<th scope="col">Version
				&nbsp;</th>
			<th scope="col">Summary
				&nbsp;</th>
			<th scope="col">Status
				&nbsp;</th>
		</tr>
	</thead>
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