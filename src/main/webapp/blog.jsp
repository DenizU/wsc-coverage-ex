<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Blog Entries</title>
</head>

<body>
<a href="${createblogurl}">Add entry</a>
<h1>Blog entries:</h1>
<ul>
    <c:forEach var="item" items="${blogEntries}">
        <li>
        Title: <b>${item.title}</b><br />
        Author: ${item.author} - Date: ${item.creationDate}<br />
        Content: ${item.content}<br />
        </li>
    </c:forEach>
</ul>
</body>
</html>