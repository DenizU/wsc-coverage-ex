<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" session="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delete customer</title>
</head>
<body>
<h3>Kunde ${customerId} und alle zugeordneten Adressen wirklich löschen?</h3>
<form:form method="POST">
    
    <input type="submit" value="Submit" />
</form:form>
<a href="./showCustomers.app">Zurück</a>
</body>
</html>