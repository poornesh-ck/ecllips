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

<form action="ProductChoice">

<h4>Add product details</h4>

<table>

<tr><td>Product id :</td><td><input type="text" name="pid"></td></tr>

<tr><td>Product Name :</td><td><input type="text" name="pname"></td></tr>

<tr><td>Product Description :</td><td><input type="text" name="pdesc"></td></tr>

<tr><td>Product Quantity :</td><td><input type="text" name="pqty"></td></tr>

<tr><td>Product Price :</td><td><input type="text" name="price"></td></tr>

 

</table>

<input type="submit" name="Add Product" ><input type="reset">

</form>

</center>

</body>
</html>