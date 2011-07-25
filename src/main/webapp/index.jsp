<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
<h2>Login</h2>
<c:if test="${not empty errorMessage}">
<p>
    Login Error:<br />
    ${errorMessage}
</p>
</c:if>
<form action="./LoginController" method="post" >
    <p>
	    User:<br />
	    <input type="text" name="name" />
    </p>
    <p>
        Password:<br />
	   <input type="password" name="password" />
	</p>
	<p>
	   <input type="submit" value="OK" />
	</p>
</form>
</body>
</html>
