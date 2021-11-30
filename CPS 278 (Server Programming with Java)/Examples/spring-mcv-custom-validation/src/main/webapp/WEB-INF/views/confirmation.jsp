<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Confirmation Page</title>
</head>
<body>
	Customer Name: ${customer.name}
	<br> Customer Age: ${customer.age}
	<br> Customer Zip Code: ${customer.zipcode}
	<br> Favorite Course: ${customer.favoriteCourse}
	<br>

</body>
</html>