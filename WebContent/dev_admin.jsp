<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256" import="java.util.*" import="uk.ac.dundee.service.Fault" import="uk.ac.dundee.service.User" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Welcome To Mr Faulty</title>
</head>
<body>
	<h1 align="center">MR Faulty</h1>
	<p align="right"><a href="/MrFaulty/logout" style=" text-align: right;">Logout</a></p>
	<hr>

<%User user= (User)  request.getSession().getAttribute("user_object_session");%>

<% if (user.getPrivilege().equals("administrator"))
{%>
<table>
			   <tr>
			    	 <td><a href="/MrFaulty/search">Search Fault</a></td>
			     	 <td><a href="/MrFaulty/assignfaultservlet">Assign Fault</a></td> 
			    	 <td><a href="/MrFaulty/insert">Add Fault</a></td>
			    	 <td><a href="/MrFaulty/update">Update Fault</a></td>
			    	 <td><a href="/MrFaulty/delete/">Delete Fault</a></td>
			    	 <td><a href="/MrFaulty/devfaultassigned">Dev Assigned Faults</a></td>
			    </tr>
</table>
<table>
			    <tr> <td><a href="/MrFaulty/adduser">Add User</a></td> 
			    	 <td><a href="/MrFaulty/deleteuserservlet/">Delete User</a></td>
			    	 <td><a href="/MrFaulty/list">List Users</a></td>
			    	 <td><a href="/MrFaulty/searchuserfault">List User Faults</a></td>
			    </tr>
</table>
<%} %>



<% if (user.getPrivilege().equals("developer"))
{%>
<table>
			   <tr>
			    	 <td><a href="/MrFaulty/search">Search Fault</a></td> 
			    	 <td><a href="/MrFaulty/update">Update Fault</a></td>
			    	 <td><a href="/MrFaulty/searchuserfault">List User Faults</a></td>
			    </tr>
</table>

<%} %>





<%
		ArrayList<Fault> faultss = new ArrayList<Fault>();
		//faults = FaultService.query(theUserId);
		//faultss = FaultService.query(3);
		faultss = (ArrayList<Fault>) request.getAttribute("Faults");
		Iterator<Fault> iterator;
		iterator = faultss.iterator();
		Fault fault;
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
<%
		while (iterator.hasNext())
		{
			fault = (Fault)iterator.next();
			if (fault.getState().equals("New")) 
			{
%>

			    <tr> <td><a href="/MrFaulty/details/<%=fault.getFaultid()%>">Details</a></td> 
			    	 <td><%=fault.getProject()%> </td>
			    	 <td><%=fault.getRelease()%> </td>
			    	 <td><%=fault.getSummary()%> </td>
			    	 <td><%=fault.getState()%> </td>
			    </tr>
			
<%          }
			
		}
%>
		</table>
</body>
</html>