<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256" import="java.util.*"
	import="uk.ac.dundee.service.*" import="uk.ac.dundee.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1256">
<title>Mr Faulty Reporter Page</title>
</head>
<body>
	<h1 align="center">MR Faulty</h1>
	<p align="right"><a href="/MrFaulty/logout" style=" text-align: right;">Logout</a></p>
	<hr>
	<h3>Report The Fault, Please.</h3>
	<%
		User user = (User) session.getAttribute("user_object_session");
	%>
	Hello
	<%=user.getFirst_Name()%>
	<%=user.getLast_Name()%>
	<form action="insert" method="post">
		<table border="1" cellpadding="1" cellspacing="1"
			style="width: 500px;">
			<tbody>
				<tr>
					<td>Submit by</td>
					<td><label for="username"><%=user.getUserName()%></label></td>
				</tr>
				<tr>
					<td>Project</td>
					<td><input name="project" type="text" /></td>
				</tr>
				<tr>
					<td>Version</td>
					<td><input name="version" type="text" /></td>
				</tr>
				<tr>
					<td>Summary</td>
					<td><input name="summary" type="text" /></td>
				</tr>
				<tr>
					<td>Details</td>
					<td><br /> <textarea cols="9" name="details" rows="15"
							style="width: 375px; height: 183px;"></textarea></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" /></td>
				</tr>
			</tbody>
		</table>

	</form>

	<%
		ArrayList<Fault> faultss = new ArrayList<Fault>();
		//faults = FaultService.query(theUserId);
		//faultss = FaultService.query(3);
		faultss = (ArrayList<Fault>) request.getAttribute("Faults");
		Iterator<Fault> iterator;
		iterator = faultss.iterator();
		Fault fault;
	%>	
		<label><h3> The Submited Faults :</h3></label>
		<table border="1">
			<thead>
		<tr>
			<th scope="col">Details
				&nbsp;</th>
			<th scope="col">Fault ID
				&nbsp;</th>
			<th scope="col">Project
				&nbsp;</th>
			<th scope="col">Summary
				&nbsp;</th>
			<th scope="col">Action
				&nbsp;</th>
			<th scope="col">Status
				&nbsp;</th>
		</tr>
	
	<% 
		while (iterator.hasNext()) {
			fault = (Fault) iterator.next();
	%>
		
		<tr>
			<td><a href="/MrFaulty/details/<%=fault.getFaultid()%>">Details</a></td>
			<td><%=fault.getFaultid()%></td>
			<td><%=fault.getProject()%></td>
			<td><%=fault.getSummary()%></td>
			<td><%=fault.getAction()%></td>
			<td><%=fault.getState()%></td>
		</tr>
	<%
		}
	%>
	</table>
</body>
</html>