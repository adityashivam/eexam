<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head > 
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"><script language="javascript">

function save()
{
	document.form.submit();
}

</script>
<title>Online Exam</title>
</head>
<body bgcolor="#42f4b3">
<% String message = (String)request.getAttribute("msg"); %>

<form action="login" name ="form" method="post">
<table align="center" style="margin-top: 8em;  height: 15em; width: 25em" bgcolor="#4162f4">
   
 	<tr>
		<td colspan="2">
		<%if(message != null){ %>
		<h2> you are not a valid user</h2>
		<%} %>
		<td>
	</tr>

	<tr>
		<td><b>Username:</b></td>
		<td><input type = "text" name= "userid" ></td>
	</tr>
	
	<tr>
		<td><b>Password:</b></td>
		<td><input type = "password" name= "pass" > </td>
	</tr>
	
	<tr>
		<td colspan="2" align="center">
		<input type = "button" value = "Submit" onclick="save()" > 
		<input type = "button" value = "Forget Password" onclick="save()" > 
		</td>
	</tr>
	
	
	<tr>               
		<td colspan="2" align=right>if you don't have user id <a href="register.jsp"> click here </a> </td>
	    <td colspan="2" align=right>RANKLIST <a href="Leaderboard"> click here </a> </td>
		
	</tr>
	
</table>     


</form>
</body>
</html>