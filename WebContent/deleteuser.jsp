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
	<form action="deleteuserservlet" method="POST">
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
	<table>
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