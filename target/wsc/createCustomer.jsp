<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create new customer</title>
<style>
    .error {
        color: red;
        font-weight: bold;
    }
</style>
</head>
<body>
<h2>Neuen Kunden anlegen</h2>
<form:form method="POST">
    <p>
    Nachname: <form:input path="surname" /><form:errors path="surname" cssClass="error" />
    </p>
    <p>
    Vorname: <form:input path="name" /><form:errors path="name" cssClass="error" />
    </p>
    <p>
    Telefonnummer: <form:input path="phone" /><form:errors path="phone" cssClass="error" />
    </p>
    <p>
    Email(optional): <form:input path="email" /><form:errors path="email" cssClass="error" />
    </p>
    
    
    <c:forEach var="i" begin="0" end="${addressCount - 1}" step="1" varStatus="loop">
        <h3>Adresse ${loop.index + 1}:</h3>
        <p>
        Strasse: <form:input path="addresses[${loop.index}].street" /><form:errors path="addresses[${loop.index}].street" cssClass="error" />
        </p>
        <p>
        Hausnr.: <form:input path="addresses[${loop.index}].number" /><form:errors path="addresses[${loop.index}].number" cssClass="error" />
        </p>
        <p>
	    PLZ: <form:input path="addresses[${loop.index}].postal" /><form:errors path="addresses[${loop.index}].postal" cssClass="error" />
	    </p>
	    <p>
	    Ort: <form:input path="addresses[${loop.index}].city" /><form:errors path="addresses[${loop.index}].city" cssClass="error" />
	    </p>
	    <p>
	    Als primäre Adresse? <form:radiobutton path="primary" value="${loop.index}" /><form:errors path="primary" cssClass="error" />
	    </p>
    </c:forEach>
    <input type="submit" value="Submit" />
</form:form>

</body>
</html>