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

	Pet Name: ${pet.name}
	<br> Species: ${pet.species}
	<br> Gender: ${pet.gender}
	<br> Sources Heard From:
	<c:forEach var="eachSource" items="${pet.sources}">

		<li>${eachSource}</li>

	</c:forEach>

</body>
</html>