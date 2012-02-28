<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"  import="java.util.*" import="uk.ac.dundee.service.User" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1256">
<title>List The users</title>
</head>
<body>
	<h1 align="center">MR Faulty</h1>
	<p align="right"><a href="/MrFaulty/logout" style=" text-align: right;">Logout</a></p>
	<hr>
	<a href="/MrFaulty/admdev/">Back</a>
	<br>
	
	<form action="/MrFaulty/list" method="POST"> 
		<label>Choose User Type From Menu :</label>
		<select name="userPrivilege">
			<option value=""></option>
			<option value="reporter">Reporters</option>
			<option value="developer">Developers</option>
			<option value="administrator">Administrators</option>
		</select> 
		<input type="submit" name="Show" value="Show" />
	</form>

	<%
		if (request.getAttribute("TheUsers") != null) 
			{
			ArrayList<User> listusers = new ArrayList<User>();
			listusers = (ArrayList<User>) request.getAttribute("TheUsers");
			Iterator<User> iterator;
			iterator = listusers.iterator();
			User user;
	%>
			<table border="1">
	<thead>
		<tr>
			<th scope="col">User Name
				</th>
			<th scope="col">First Name
				</th>
			<th scope="col">Last Name
				</th>
			<th scope="col">Email
				</th>
		</tr>
	</thead>
	<%
			while (iterator.hasNext())
			{
				user = (User)iterator.next();
	%>
				
				    <tr>  
				    	 <td><%=user.getUserName()%> </td>
				    	 <td><%=user.getFirst_Name()%> </td>
				    	 <td><%=user.getLast_Name()%> </td>
				    	 <td><%=user.getEmail()%> </td>
				    </tr>
				
	<%}}
	%>
</table>

</body>
</html>