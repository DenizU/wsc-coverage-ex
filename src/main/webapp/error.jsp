<!--  Error page is shown if an exception 
      of type de.tum.in.ibis.UserAuthenticationException
      is caught  -->
<%@ page session="false" isErrorPage="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Error!</title>
</head>
<body>
<h1>Error</h1>
<p>
Error while trying to authenticate!<br />
Reason:<br />
<!--  Display the message stored in the exception object -->
<b>${pageContext.exception.message}</b><br />
</p>
</body>
</html>