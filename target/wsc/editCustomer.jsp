<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit customer</title>
<style>
    .error {
        color: red;
        font-weight: bold;
    }
</style>
</head>
<body>
<c:if test="${command.customer.customerId > 0}">
<h2>
<c:out value="Kunde ${command.customer.surname}, ${command.customer.name}(#${command.customer.customerId}) bearbeiten" escapeXml="true" />
</h2>
<c:if test="${not empty message}" >
    <h3><c:out value="${message}" escapeXml="true" /></h3>
</c:if>
<form:form method="POST">
    <p>
    Nachname: <form:input path="customer.surname" /><form:errors path="customer.surname" cssClass="error" />
    </p>
    <p>
    Vorname: <form:input path="customer.name" /><form:errors path="customer.name" cssClass="error" />
    </p>
    <p>
    Telefonnummer: <form:input path="customer.phone" /><form:errors path="customer.phone" cssClass="error" />
    </p>
    <p>
    Email: <form:input path="customer.email" /><form:errors path="customer.email" cssClass="error" />
    </p>
    <p>
    Anzahl zusätzlicher Adressen <form:input path="additionalAddresses" size="3" /><form:errors path="additionalAddresses" cssClass="error" />
    </p>
    
    <c:if test="${not empty command.customer.addresses}">
    <c:forEach var="i" begin="0" end="${command.customer.addressCount - 1}" step="1" varStatus="loop" >
        <h3>Adresse ${loop.index + 1}:</h3> 
        Adresse löschen? <form:checkbox path="deleteAddress" value="${command.customer.addresses[loop.index].addressId}" />
        <p>
        Strasse: <form:input path="customer.addresses[${loop.index}].street" /><form:errors path="customer.addresses[${loop.index}].street" cssClass="error" />
        </p>
        <p>
        Hausnr.: <form:input path="customer.addresses[${loop.index}].number" /><form:errors path="customer.addresses[${loop.index}].number" cssClass="error" />
        </p>
        <p>
        PLZ: <form:input path="customer.addresses[${loop.index}].postal" /><form:errors path="customer.addresses[${loop.index}].postal" cssClass="error" />
        </p>
        <p>
        Ort: <form:input path="customer.addresses[${loop.index}].city" /><form:errors path="customer.addresses[${loop.index}].city" cssClass="error" />
        </p>
        <p>
        Als primäre Adresse? <form:radiobutton path="primary" value="${loop.index}"/><form:errors path="primary" cssClass="error" />
        </p>
    </c:forEach>
    </c:if>
    <form:hidden path="newAddresses" />
    <input type="submit" value="OK" />
</form:form>
</c:if>
<c:if test="${command.customer.customerId <= 0}" >
Ungültige / keine Kundennummer angegeben.
<a href="./showCustomers.app" >Zurück zur Übersicht</a>
</c:if>
</body>
</html>