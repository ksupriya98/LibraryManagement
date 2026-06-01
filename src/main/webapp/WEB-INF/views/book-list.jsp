<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Library Books</h2>
<a href="showForm">Add Book</a>
<table border="1">
<tr>
    <th>Title</th>
    <th>Author</th>
    <th>Category</th>
</tr>
<c:forEach var="book" items="${books}">
<tr>
    <td>${book.title}</td>
    <td>${book.author}</td>
    <td>${book.category}</td>
</tr>
</c:forEach>
</table>
</body>
</html>