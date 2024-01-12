<%@page import="org.apache.taglibs.standard.tag.el.sql.SetDataSourceTag"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"

    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>

<html>

<head>

<meta charset="ISO-8859-1">

<title>Insert title here</title>

</head>

<body>

<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

 

<center>

<form action="EditProductController" method="get">

<%

int pid=Integer.parseInt(request.getParameter("pid"));

session.setAttribute("pid",request.getParameter("pid"));%> 
<% out.println(pid); %>

<sql:setDataSource var="db"

            driver="com.mysql.cj.jdbc.Driver"

            url="jdbc:mysql://localhost:3306/prodapt"

            user="root"

            password="root"/>

<sql:query dataSource = "${db}" var = "rs">

        select * from product where pId=<%= pid %>

      </sql:query>

<label><b>EDIT PRODUCT DETAILS</b></label>

<table >

         <tr>

            <th>Product ID</th>

            <th>Product Name</th>

            <th>Product Description</th>

            <th>Product Price</th>

            <th>Product Quantity</th>

         </tr>

         <c:forEach var = "p" items = "${rs.rows}">

            <tr>

               <td> <c:out value = "${p.pId}"/></td>

               <td> <c:out value = "${p.pName}"/></td>

               <td> <c:out value = "${p.pDesc}"/></td>

               <td> <input type="text" name="editprice" value="${p.price}"></td>

               <td> <input type="text" name="editqty" value="${p.pqty }"></td>

            </tr>

         </c:forEach>

      </table>

      <input type="submit" value="EDIT">

      </form>

</center>

</body>

</html>