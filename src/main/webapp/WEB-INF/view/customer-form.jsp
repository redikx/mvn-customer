<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Save Customer</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/src/main/webapp/resources/css/style.css"/>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/src/main/webapp/resources/css/add-customer-style.css"/>
</head>

<body>
<div id="wrapper">
	<div id = "header">
		<h2> Adding Customer</h2>
	</div>
	</div>
<div id = "container">
<f:form action="saveCustomer" modelAttribute="customer" method="POST"> 

<f:hidden path="id" />

<table>
<tbody>
	<tr>
		<td><label>First Name</label></td>
		<td><f:input path="firstName"/></td>
	</tr>
	<tr>
		<td><label>Last Name</label></td>
		<td><f:input path="lastName"/></td>
	</tr>
	<tr>
		<td><label>Email</label></td>	
		<td><f:input path="email"/></td>
	</tr>
		<tr>
		<td><label></label></td>	
		<td><input type="submit" value="Save" class="save"></td>
	</tr>


</tbody>
</table>
</f:form>

</div>

<div style="clear;both"></div>
<p>
	<a href="${pageContext.request.contextPath}/customer/list" > Back to the list</a>
	</p>

</body>
</html>

