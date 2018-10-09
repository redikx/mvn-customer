<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<head>
<link type="text/css" href="<c:url value='/resources/css/add-customer-style.css' />" rel="stylesheet" />
<title> Add Client </title>
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

