<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Mastermind</title>
		<link rel="stylesheet" type="text/css" href="<c:url value="/style.css"/>">
	</head>
	<body>
	
		<p>
			Tries: ${gamestate.tries}
		</p>
	
		<c:if test="${!empty error}">
			<p class="error">Error: ${error}</p>
		</c:if>
	
		<p id="code">
		Code:			
			<c:forEach items="${gamestate.code}" var="ii">
				${ii}
			</c:forEach>
		</p>
		
		<h3>History</h3>
		<ul>
			<c:forEach items="${gamestate.history}" var="item">
				<li>
					<c:forEach items="${item.guess}" var="number">
						${number}
					</c:forEach>
					 | hint: 
					<c:forEach items="${item.hint}" var="number">
						${number}
					</c:forEach>
				</li>
			</c:forEach>
		</ul>
	
		<form method="post">
			<label for="guess">Guess: </label><input type="text" name="guess" autofocus>
			<input type="submit">
		</form>
	
	</body>
</html>