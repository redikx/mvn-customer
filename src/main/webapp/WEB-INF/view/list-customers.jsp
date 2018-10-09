<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List Of Customers</title>
 <link type="text/css" href="<c:url value='/resources/css/style.css' />" rel="stylesheet" />
</head>
<body>
<div id = "wrapper">
<div id = "header">
<h2 align="center">Customers</h2>
</div>
</div>


<div id = "container">
	<div id = "content">

<input type="button" value="Add Customer" onclick="window.location.href='showFormForAdd'; return false;" class="add-button">

<form:form action="search" method="POST" >
Search Customer: <input type="text" name="theSearchName" />
<input type="submit" value="Search" class="add-button" />
</form:form> 

<table>
	<tr>
		<th> First Name </th>
		<th> Last Name </th>
		<th> Email </th>
		<th> Action </th>
	</tr>

		<c:forEach var="tempCustomer" items="${listCustomers}">
		
			<c:url value="showFormForUpdate" var="updateLink">
				<c:param name="customerId" value="${tempCustomer.id}"></c:param>
			</c:url>

			<c:url value="delete" var="deleteLink">
				<c:param name="customerId" value="${tempCustomer.id}"></c:param>
			</c:url>

			
			<tr>
		<td> ${tempCustomer.firstName}</td>
		<td> ${tempCustomer.lastName}</td>
		<td> ${tempCustomer.email}</td>
		<td> <a href="${updateLink}">Update</a>
		| <a href="${deleteLink}" onclick="if (!(confirm('Are you sure you want to delete this user?'))) return false">Delete</a>
 			</tr>
 		</c:forEach>
 	
 </table>
 <br>
 <form:form action="${pageContext.request.contextPath}/logout" method="POST">
 <input type="submit" value="Logout" class="add-button"/>
 </form:form>
 </div>
 </div>
</body>
</html>