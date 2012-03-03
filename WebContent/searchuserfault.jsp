<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256" import="java.util.*" import="uk.ac.dundee.service.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Search faults by User ID, Or Faults Assigned to </title>
</head>
<body>
	<h1 align="center">MR Faulty</h1>
	<p align="right"><a href="/MrFaulty/logout" style=" text-align: right;">Logout</a></p>
	<hr>
	<a href="/MrFaulty/admdev/">Back</a><br>
<form action="/MrFaulty/searchuserfault" method="POST">
	<label> Enter User ID :</label>
	<input type="text" name="userid"/>
	<input type="submit" value="Show Faults"/>
	
</form>

	<%
		if (request.getAttribute("faults") != null)
		{
		User user = new User();
		user= (User) request.getAttribute("user");
			
		ArrayList<Fault> faultss = new ArrayList<Fault>();
		faultss = (ArrayList<Fault>) request.getAttribute("faults");
		Iterator<Fault> iterator;
		iterator = faultss.iterator();
		Fault fault;
	%>
		<table border="1">
	<thead>
		<tr>
			<th scope="col">Details
				</th>
			<th scope="col">User ID
				</th>
			<th scope="col">UserName
				</th>
			<th scope="col">Project
				</th>
			<th scope="col">Version
				</th>
			<th scope="col">Status
				</th>
			<th scope="col">Summary
				</th>
		</tr>
	</thead>
	<% 
		while (iterator.hasNext()) {
			fault = (Fault) iterator.next();
	%>

		<tr>
			<td><a href="/MrFaulty/details/<%=fault.getFaultid()%>">Details</a></td>
			<td><%=fault.getUserid()%></td>
			<td><%=user.getUserName()%></td>
			<td><%=fault.getProject()%></td>
			<td><%=fault.getRelease()%></td>
			<td><%=fault.getState()%></td>
			<td><%=fault.getSummary()%></td>
		</tr>
	<%
		}}
	%>
	</table>
</body>
</html>