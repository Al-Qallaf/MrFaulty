<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256" import="uk.ac.dundee.service.Fault"  import="java.util.*" import="uk.ac.dundee.service.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1256">
<title>Assign Fault</title>
</head>
<body>
	<form action="/MrFaulty/assignfaultservlet" method="POST">
		<input type="text" name="FaultId" />
		<input type="submit" name="Find" value="Show Fault" />
	</form>
	<form action="/MrFaulty/assignfaultservlet" method="POST"">
	<input type="submit" name="Assign" value="Assign" />
	<%
		if (request.getAttribute("Fault") != null) {
			Fault fault = (Fault) request.getAttribute("Fault");
			System.out.println(fault.getFaultid());
	%>
	<table>
		<tr>
			<td><a href="/MrFaulty/Search/<%=fault.getFaultid()%>"><%=fault.getFaultid()%>
			</a></td>
			<td><%=fault.getProject()%></td>
			<td><%=fault.getRelease()%></td>
			<td><%=fault.getSummary()%></td>
			<td><%=fault.getState()%></td>
			<td><%=fault.getUserid()%></td>
			<td><select name="investigated_by">
					<%
					
					%>
							<%
							ArrayList<User> user = new ArrayList<User>();
							user = (ArrayList<User>) request.getAttribute("Users");
							Iterator<User> iterator;
							iterator = user.iterator();
							User theUser;
							while (iterator.hasNext()) 
							{
								theUser = (User) iterator.next();
							%>
					<option value="<%=theUser.getUserName()%>"><%=theUser.getUserName()%></option>
							<%
							}
							%>

			</select></td>
		</tr>
	</table>
	<%
		}
	%>
</form>
</body>
</html>