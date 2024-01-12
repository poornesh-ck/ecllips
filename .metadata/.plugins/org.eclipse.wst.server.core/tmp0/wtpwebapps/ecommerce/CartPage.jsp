<%@page import="java.util.ArrayList"%>
<%@page import="java.util.*"%>
<%@page import="ecommerce.model.*"%>
<%@page import="ecommerce.service.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% 
ArrayList<Cart> cart_list= (ArrayList<Cart>)  session.getAttribute("cart-list");
List<Cart> cartProduct=null;
if(cart_list != null){
	ProductService ps= new ProductService();
	cartProduct= ps.getCartProducts(cart_list);
	request.setAttribute("cart_list", cart_list);
}



%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>
<tbody>
<% if(cart_list != null){
	for(Cart c:cartProduct){%>
		<tr>
		<td><%= c.getpName() %></td>
		<td><%= c.getpDesc() %></td>
		<td><%= c.getpPrice() %></td>
		
		
		</tr>
	<% }
}

%>
</tbody>
</table>
</body>
</html>