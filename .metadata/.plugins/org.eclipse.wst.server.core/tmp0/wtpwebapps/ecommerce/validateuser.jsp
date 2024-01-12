<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>User credentials</h1>

<table>
<thead><tr>
<th>User name</th>
<th>User dob</th>
<th>Phone number</th>
<th>email</th>
<th>Password</th>

<th>Choice</th>
</tr></thead>
<tbody>
<c:forEach var="user" items="${list1}">
<tr>
<td><c:out value="${user.username}"></c:out></td>
<td><c:out value="${user.dob}"></c:out></td>
<td><c:out value="${user.number}"></c:out></td>
<td><c:out value="${user.email}"></c:out></td>
<td><c:out value="${user.password}"></c:out></td>





<td><a href="ValidationController?uname=${user.username}"><button >Activate</button></a></td>
<td><a href="ValidationController2?uname=${user.username }"><button >Deactivate</button></a></td>

<td><a href="DeleteUserController?deleteuname=${user.username}">Delete</a></td>

</tr>

</c:forEach>

</table><br><br>


</tr>

</tbody>
</table>

</body>
</html>