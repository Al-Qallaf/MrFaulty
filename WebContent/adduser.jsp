<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1256">
<title>Add Users</title>
</head>
<body>
	<h1 align="center">MR Faulty</h1>
	<p align="right"><a href="/MrFaulty/logout" style=" text-align: right;">Logout</a></p>
	<hr>
	<a href="/MrFaulty/admdev/">Back</a>
	<br>
	<label>Write User Information :</label>
	<form action="adduser" method="post">
		<table border="1" cellpadding="1" cellspacing="1"
			style="width: 500px;">
			<tbody>
				<tr>
					<td>Username</td>
					<td><input name="UserName" type="text" /></td>
				</tr>
				<tr>
					<td>First Name</td>
					<td><input name="FirstName" type="text" /></td>
				</tr>
				<tr>
					<td>Last Name</td>
					<td><input name="LastName" type="text" /></td>
				</tr>
				<tr>
					<td>Email</td>
					<td><input name="Email" type="text" /></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input name="Password1" type="text" /></td>
				</tr>
				<tr>
					<td>Retype Password</td>
					<td><input name="password2" type="text" /></td>
				</tr>
				<tr>
					<td>Privilege</td>
					<td><select name="Privilege">
							<option value="administrator">administrator</option>
							<option value="developer">developer</option>
							<option value="reporter">reporter</option>
					</select></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td><input type="submit" value="Add User"/></td>
				</tr>
			</tbody>
		</table>
	</form>
	<p>&nbsp;</p>



</body>
</html>