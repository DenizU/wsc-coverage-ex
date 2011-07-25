<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" session="false" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Show customers</title>
<!-- Style the list and error class a little -->
<style type="text/css">
    #customerList {
        padding:0;
        margin:0;
    }
    
    #customerList li {
        list-style-type:none;
        margin-bottom:10px;
    }
    .error {
        color: red;
        font-weight: bold;
    }
</style>
</head>
<body>
<h2>Kunden:</h2>
<c:if test="${not empty message}">
    <p>
    <c:out value="${message}" escapeXml="true" />
    </p>
</c:if>
<p>
<a href="./newCustomer.app">Neuen Kunden anlegen</a><br />
<a href="./showCustomers.app">Alle Kunden anzeigen</a><br />
<form:form method="POST">
Suchen <form:input path="searchString" /> <input type="submit" value="OK" />
</form:form>
</p>
<c:if test="${empty customers}">
    <h3>Keine Kundendaten vorhanden</h3>
</c:if>
<c:if test="${not empty customers}">
    
	<table border="1">
	<tr>
	   <th>Kunden-nr.</th>
	   <th>Name</th>
	   <th>Vorname</th>
	   <th>Tel.</th>
	   <th>Email</th>
	   <th>Adresse(n)</th>
	</tr>
	<c:forEach var="customer" items="${customers}">
	   <tr>
		   <td>
		   <c:out value="${customer.customerId}" escapeXml="true" />
		   <a href="./deleteCustomer.app?customerId=${customer.customerId}">löschen</a>
		   <a href="./editCustomer.app?customerId=${customer.customerId}">bearbeiten</a>
		   </td>
		   <td><c:out value="${customer.surname}" escapeXml="true" /></td>
		   <td><c:out value="${customer.name}" escapeXml="true" /></td>
		   <td><c:out value="${customer.phone}" escapeXml="true" /></td>
		   <td><c:out value="${customer.email}" escapeXml="true" /></td>
		   <td>
		   <!-- customer's addresses -->
		   <c:forEach var="address" items="${customer.addresses}">
		   <c:out value="${address.street} ${address.number} in ${address.postal} ${address.city} - Primaer:${address.isPrimary}" escapeXml="true" /><br />
		   </c:forEach>
		   </td>
	   </tr>
	</c:forEach>
	</table>
	
	<!-- paging -->
    <p>
        <c:if test="${offset > 0}">
            <c:if test="${isSearch == true}">
                <a href="./searchCustomer.app?offset=${offset-20}&searchString=${searchString}">Vorherige Seite</a>
            </c:if>
            <c:if test="${isSearch == false}">
                <a href="./showCustomers.app?offset=${offset-20}">Vorherige Seite</a>
            </c:if>
        </c:if>
        <c:if test="${limitedByMaxRows == true}">
            <c:if test="${isSearch == true}">
                <a href="./searchCustomer.app?offset=${offset+20}&searchString=${searchString}">Nächste Seite</a>
            </c:if>
            <c:if test="${isSearch == false}">
                <a href="./showCustomers.app?offset=${offset+20}">Nächste Seite</a>
            </c:if>
        </c:if>
    </p>
    
</c:if>
</body>
</html>