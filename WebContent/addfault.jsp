<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256" import="uk.ac.dundee.service.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1256">
<title>Add Fault</title>
</head>
<body>
	<h1 align="center">MR Faulty</h1>
	<p align="right"><a href="/MrFaulty/logout" style=" text-align: right;">Logout</a></p>
	<hr>
	<% 
		User user = (User) session.getAttribute("user_object_session");
	%>
	<a href="/MrFaulty/admdev/">Back</a>
	<br>
	<label>Write User Information :</label>
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
					<td><input type="submit" name="Add Fault" value="Add Fault"/></td>
				</tr>
			</tbody>
		</table>

	</form>

</body>
</html>