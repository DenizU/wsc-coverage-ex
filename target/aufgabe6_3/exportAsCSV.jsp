<%@ page language="java" contentType="text/csv; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" session="false" 
%><%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"
%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><sql:setDataSource
	var="remoteDataSource" driver="com.mysql.jdbc.Driver"
	url="jdbc:mysql://192.168.201.100:3306/db_user2" user="user2"
	password="65Upg"
 /><sql:query var="customers" dataSource="${remoteDataSource}">

    SELECT kundennummer, nachname, vorname, telefonnummer, email
    FROM kunden
    
</sql:query><c:out value="kundennummer;nachname;vorname;telefonnummer;email;adressen" />
<c:forEach var="row" items="${customers.rows}"
><sql:query var="addresses" dataSource="${remoteDataSource}">
    SELECT id, strasse, hausnummer, plz, ort, primaer
    FROM kunden_adressen
    WHERE kundennummer=<c:out value="${row.kundennummer}" />
    </sql:query><c:out 
    value="${row.kundennummer};${row.nachname};${row.vorname};${row.telefonnummer};${row.email};" escapeXml="false"
    /><c:forEach var="addressRow" items="${addresses.rows}"
    ><c:out value="${addressRow.strasse} ${addressRow.hausnummer}, ${addressRow.plz} ${addressRow.ort} primär:${addressRow.primaer}
    ;;;;;" 
        /></c:forEach>
        </c:forEach>