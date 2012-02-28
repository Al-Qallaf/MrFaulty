<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256" import="uk.ac.dundee.service.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Delete Users</title>
</head>
<body>
<body>
	<h1 align="center">MR Faulty</h1>
	<p align="right"><a href="/MrFaulty/logout" style=" text-align: right;">Logout</a></p>
	<hr>
		<a href="/MrFaulty/admdev/">Back</a>
	<br>
	<form action="deleteuserservlet" method="POST">
		<label>Enter User ID: </label>
		<input type="text" name="UserId"> 
		<input type="submit" value="Find User By ID">
	</form>
	
	<%
		String signal = (String) request.getAttribute("control");
	    System.out.println("Ooooooooo"+ signal);
	    if (signal.toString() == "doPost")
	    {
		User theUser = new User();
		theUser = (User) request.getAttribute("theUser");
	%>
	
	<table border="1">
	<thead>
		<tr>
			<th scope="col">Delete
				</th>
			<th scope="col">Username
				</th>
			<th scope="col">First Name
				</th>
			<th scope="col">Last Name
				</th>
			<th scope="col">Authority
				</th>
		</tr>
	</thead>
		<tr>
			<td><a href="/MrFaulty/deleteuserservlet/<%=theUser.getUserId()%>">Delete</a></td>
			<td><%=theUser.getUserName()%></td>
			<td><%=theUser.getFirst_Name()%></td>
			<td><%=theUser.getLast_Name()%></td>
			<td><%=theUser.getPrivilege()%></td>
		</tr>
	</table>
	<%}%>
</body>
</body>
</html>