<!--  Error page is shown if a protected resource
      is requested while the user is not logged in -->
<%@ page session="false" isErrorPage="true" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Access error</title>
</head>
<body>
Access denied!<br />
Log in first to access the resource<br />
<a href="./index.jsp">Login</a>
</body>
</html>