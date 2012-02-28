<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256" import="java.util.*" import="uk.ac.dundee.service.Fault"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Fault Search</title>


</head>
<body>
	<h1 align="center">MR Faulty</h1>
	<p align="right"><a href="/MrFaulty/logout" style=" text-align: right;">Logout</a></p>
	<hr>


<form action="/MrFaulty/search" method="POST">
	<input type="text" name="FaultId">
	<input type="submit"  value="Show Fault">
</form>

<a href="/MrFaulty/search/all"><button>List All Faults</button></a>

<%      
		
	    //if (request.getAttribute("switch"));
	    String signal = (String) request.getAttribute("switch");
	    System.out.println("Ooooooooo"+ signal);
	    if (signal.toString() == "Pass")
	    {
	    System.out.println("I'm Inside if statement...");
		ArrayList<Fault> faultss = new ArrayList<Fault>();
		faultss = (ArrayList<Fault>) request.getAttribute("Faults");
		Iterator<Fault> iterator;
		iterator = faultss.iterator();
		Fault fault;
		while (iterator.hasNext())
		{
			fault = (Fault)iterator.next();
				%>
			<table>
			    <tr> <td><a href="/MrFaulty/details/<%=fault.getFaultid()%>"><%=fault.getFaultid()%> </a></td> 
			    	 <td><%=fault.getProject()%> </td>
			    	 <td><%=fault.getRelease()%> </td>
			    	 <td><%=fault.getSummary()%> </td>
			    	 <td><%=fault.getState()%> </td>
			    </tr>
			</table>
	<%	}}
	else
	    if (request.getAttribute("Fault") != null)
	    {
	     Fault fault = (Fault) request.getAttribute("Fault");
	     System.out.println(fault.getFaultid());
	     
	 %>
			<table>
			    <tr> <td><a href="/MrFaulty/details/<%=fault.getFaultid()%>"><%=fault.getFaultid()%> </a></td> 
			    	 <td><%=fault.getProject()%> </td>
			    	 <td><%=fault.getRelease()%> </td>
			    	 <td><%=fault.getSummary()%> </td>
			    	 <td><%=fault.getState()%> </td>
			    </tr>
			</table>
	  <%   
	    }
	  %>

</body>
</html>