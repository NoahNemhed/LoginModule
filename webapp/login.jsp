<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="styles.css">
<title>Login</title>
</head>
<body>


		<a href="Register.jsp">Register</a>

		<br>
		<form action="Login" method="post">
		
		Enter Username : <input type="text" name="uname">
		<br>
		Enter Password : <input type="password" name="pword">
		<br>
		<input type="submit" value="Submit">
		<div style="color:red">${errorMessage}</div>
		<div style="color:red">${Failed}</div>
		<div style="color:green">${Sucsess}</div>
		</form>
		
</body>
</html>
