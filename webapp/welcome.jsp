<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>

	<%	
		//G�r s� man inte kan klicka back n�r man �r utloggad f�r att komma tbx till s�kra sidor. 
			response.setHeader("Cache-Control","no-cache");
			response.setHeader("Cache-Control","no-store");
			response.setHeader("Pragma","no-cache");
			response.setDateHeader ("Expires", 0);
		//Kollar s� att man �r inloggad.
		if(session.getAttribute("uname") == null){
			response.sendRedirect("login.jsp");
		}
	%>
		<form action="Logout">
		<input type="submit" value="Logout">
	</form>
	Welcome ${uname} 
	<br>
	<a href="videos.jsp" >Videos</a>
</body>
</html>