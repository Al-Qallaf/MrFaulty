<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256" import="uk.ac.dundee.service.Fault"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1256">
<title>Insert title here</title>
</head>
<body>
	<h1 align="center">MR Faulty</h1>
	<p align="right"><a href="/MrFaulty/logout" style=" text-align: right;">Logout</a></p>
	<hr>
		<a href="/MrFaulty/admdev/">Back</a>
	<br>
	<label>The fault Information :</label>
<% 
Fault TheFault= new Fault();
TheFault = (Fault) request.getAttribute("FaultDetails");

 %>

	<table border="1" cellpadding="1" cellspacing="1" style="width: 500px;">
		<tbody>
			<tr>
				<td>Fault ID</td>
				<td><input name="FaultId" type="text"  value="<%=TheFault.getFaultid() %>"/></td>
			</tr>
			<tr>
				<td>Project</td>
				<td><input name="project" type="text" value="<%=TheFault.getProject()%>"/></td>
			</tr>
			<tr>
				<td>Version</td>
				<td><input name="version" type="text" value="<%=TheFault.getRelease()%>"/></td>
			</tr>
			<tr>
				<td>Summary</td>
				<td><input name="summary" type="text" value="<%=TheFault.getSummary()%>"/></td>
			</tr>
			<tr>
				<td>Details</td>
				<td><br /> <textarea cols="9" name="details" rows="15"
						style="width: 375px; height: 183px;" ><%=TheFault.getDetails()%></textarea></td>
			</tr>
			<tr>
				<td>Status</td>
				<td><input name="status" type="text" value="<%=TheFault.getState()%>"/></td>
			</tr>
			<tr>
				<td>Action</td>
				<td><input name="Action" type="text" value="<%=TheFault.getAction()%>"/></td>
			</tr>
			<tr>
				<td>Developer</td>

				<td><input name="Reporter" type="text" value="<%=TheFault.getInvestigated_by()%>"/></td>

			</tr>
			
		</tbody>
	</table>

</body>
</html>