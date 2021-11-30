<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html>
<html>

<head>

<meta charset="ISO-8859-1">
<title>Insert title here</title>

</head>

<body>

	<b>Please Enter Student Info:</b>

	<form:form action="processStudent" modelAttribute="student"
		method="post">

		<form:hidden path="id" />

		<table>

			<tr>
				<td>First Name</td>
				<td><form:input path="firstName" /></td>
			</tr>

			<tr>
				<td>Last Name</td>
				<td><form:input path="lastName" /></td>
			</tr>

			<tr>
				<td>Email</td>
				<td><form:input path="email" /></td>
			</tr>

			<tr>
				<td></td>
				<td><input type="submit" value="Add Student" /></td>
			</tr>


		</table>
		<a href="${pageContext.request.contextPath}/student/list">Back To
			Student List </a>
	</form:form>

</body>

</html>