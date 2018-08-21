<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<script language="javascript">

function validate()
{   
	var name   = document.getElementById("name").value;
	var age    = document.getElementById("age").value;
    var email  = document.getElementById("email").value;
    var pass   = document.getElementById("pass").value;
    var cpass  = document.getElementById("cpass").value;

	//alert("name = "+ name + "  pass = "+ pass);
	if(name=="")
	{
		alert("User name can not be blank");
		return false;
	}
	if(age=="")
	{
		alert("Age can not be blank");
		return false;
	}
	if(email=="")
	{
		alert("email can not be blank");
		return false;
	}
	
	if(pass=="")
	{
		alert("password can not be blank");
		return false;
	}
	if(pass!=cpass)
	{
		alert("password not match");
		return false;
	}
	
	
 	document.form.submit();

}

function fillEmailId(val)
{
	document.getElementById("email").value=val;
}

</script>

<% Integer msg=(Integer)request.getAttribute("msg"); %>

</head>
<body bgcolor="#42f4b3">

<form action="register" name ="form" method="post"> 
<% 
if(msg!=null){
	if(msg==1){
%>
		
		<h1> user already exist</h1>
	<%}
	
	if(msg==2){
	%>
		<h1> you have successfully register now go to <a href="login.jsp">login page</a></h1> 
	<%}
}%>



name            : <input type ="text"     name=   "name"   id="name"><br>
age             :<input type = "text"     name=   "age"    id="age"><br>
email           :<input type = "text"     name=   "email"  id="email" onkeypress="filluserIDId(this.value)"><br>
user Id		    :<input type = "text"     name=   "userId" id="userId" ><br>  
Choose Password :<input type = "password" name=   "pass"   id="pass"><br>
Confirm Password:<input type = "password" name=   "cpass"  id="cpass"><br>
<input type = "button" value = "submit"   onclick="validate()"> 

</form>

</body>
</html>