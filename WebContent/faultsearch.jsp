<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256" import="java.util.*" import="uk.ac.dundee.service.Fault" import="uk.ac.dundee.service.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Fault Search</title>

<script type="text/javascript"
	src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript">
	function loadall()
	{
	$.get("/MrFaulty/search/all/json", function(data) {
		//alert("Data Loaded: " + data);

		data = data["Faults"];
		for ( var i in data) {
			var Faultid = data[i]["Faultid"];
			$("#contentt").append(
					$("<li></li>").append(
							$("<a></a>").attr("href","/MrFaulty/details/" + Faultid).text("Details").click()));
			//$("#contentt").append("<h1>Details: "+Faultid+"</h1>");
			$("#contentt").append("<table></table>");
				
			var table = $("#contentt");
			table.append($("<tr><td>State : </td><td>" + data[i]["State"] + "</td></tr>"));
			table.append($("<tr><td>Project : </td><td>" + data[i]["Project"] + "</td></tr>"));
			table.append($("<tr><td>Summary : </td><td>" + data[i]["Summary"] + "</td></tr>"));
		}}, "json");
	}
</script>
</head>
<body>
	<h1 align="center">MR Faulty</h1>
	<p align="right"><a href="/MrFaulty/logout" style=" text-align: right;">Logout</a></p>
	<hr>
	<a href="/MrFaulty/admdev/">Back</a><br>
			


<form action="/MrFaulty/search" method="POST">
	<label>Enter Fault ID :</label>
	<input type="text" name="FaultId">
	<input type="submit"  value="Show Fault">
</form>

<a href="/MrFaulty/search/all"><button>List All Faults</button></a>
	<div id="contentt" style="background-color: yellow; position: absolute; top: auto; left: 507px; width: 210px; height: auto;"></div>
<INPUT type="BUTTON" value="Show All Faults (Json/Jquery)"  ONCLICK="loadall()">

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