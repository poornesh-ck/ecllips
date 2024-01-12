<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<h1>Login</h1>
<table>
<form action="LoginCheckController" method="post">
<tr><td><label>Email-id</label> <input type="email" name="email" placeholder="enter email-id" ></td></tr>
<tr><td><label>Password</label><input type="password" name="pass" placeholder="enter password" ></td></tr>
<tr><td><input type="submit" name="submit"></td></tr>
</table>
</center>
</form>

</body>
</html>