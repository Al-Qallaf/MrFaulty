<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256" import="java.util.*" import="uk.ac.dundee.service.Fault" import="uk.ac.dundee.service.User" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1256">
<title>Update Fault</title>
</head>
<body>
	<h1 align="center">MR Faulty</h1>
	<p align="right"><a href="/MrFaulty/logout" style=" text-align: right;">Logout</a></p>
	<hr>
	
	<form action="update" method="Post">
		<table border="1" cellpadding="1" cellspacing="1"
			style="width: 500px;">
			<tbody>
				<tr>
					<td>Enter Fault ID</td>
					<td><input name="FaultId" type="text"></td>
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
					<td>Status</td>
					<td><select name="status">
							<option value=""></option>
							<option value="New">New</option>
							<option value="In Progress">In Progress</option>
							<option value="In Test">In Test</option>
							<option value="Deferred">Deferred</option>
							<option value="Closed">Closed</option></select></td>
				</tr>
				<tr>
					<td>Action</td>
					<td><select name="action">
							<option value=""></option>
							<option value="Fixed">Fixed</option>
							<option value="Duplicated">Duplicated</option>
							<option value="Awaiting Info">Awaiting Info</option></select></td>
				</tr>
				<tr>
					<td>Reporter</td>
					
					<td><select name="investigated_by">      
		<%System.out.println("Im hereeeeeeeeeeeeeeeee "); %>
<% 		ArrayList<User> user = new ArrayList<User>();
		user = (ArrayList<User>) request.getAttribute("Users");
		Iterator<User> iterator;
		iterator = user.iterator();
		User theUser;
		while (iterator.hasNext())
		{
			theUser = (User)iterator.next();
%>			
			    <option value="<%=theUser.getUserName()%>"><%=theUser.getUserName()%></option>
<%
	    }  %>
					
					</select></td>
				
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td><input type="submit" value="Update Fault"/></td>
				</tr>
			</tbody>
		</table>
	</form>
	<p></p>

</body>

</body>
</html>