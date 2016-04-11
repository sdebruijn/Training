<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="nl.sijmen.demo.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MVC Demo</title>
</head>
<body>

<h1>MVC Demo</h1>

<h2>Poging 1</h2>
<p>Kunnen we een object bekijken?</p>
<h3>Persoontje</h3>
<table>
<tr><td>Naam</td><td>${person.name}</td></tr>
<tr><td>Leeftijd</td><td>${person.age}</td></tr>
<tr><td>Man</td><td>${person.male}</td></tr>
</table>

${person.name = "Kyra"}
${person.male = false}



<c:if test="${person.male}"> He! een man!</c:if>
<c:if test="${!person.male}"> He! een vrouw!</c:if>
"${person.male ? "Weer een man": "vrouw"}"


</body>
</html>