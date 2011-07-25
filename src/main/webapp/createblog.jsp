<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create Blog Entry</title>
</head>
<body>
<h2>Add a new Blog Entry</h2>

<c:url value="/CreateBlogEntryController" var="actionURL" scope="page"></c:url>
<form action="${actionURL}" method="post">

<c:if test="${formError=='true'}">
<h4>One or more fields(marked with *) are not filled correctly!</h4>
</c:if>

<p>
<c:if test="${titleError=='true'}">
    *
</c:if>

Title:<br />
<c:choose>
    <c:when test="${formError=='true'}">
        <input type="text" name="title" value="${titleValue}" />
    </c:when>
    <c:otherwise>
        <input type="text" name="title" value="" />
    </c:otherwise>
</c:choose>
</p>
   
<p>
<c:if test="${contentError=='true'}">
    *
</c:if>

Content:<br />
<textarea cols="50" rows="10" name="content"><c:if test="${formError=='true'}"><c:out value="${contentValue}" /></c:if></textarea>
</p>

<input type="submit" value="OK" />
</form>
</body>
</html>