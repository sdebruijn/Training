<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Mastermind - Win</title>
	</head>
	<body>
		<h1>Congratulations</h1>
		<p>
			You found the secret code 
			<strong><c:forEach items="${gamestate.code}" var="number">${number}</c:forEach></strong> 
			in ${gamestate.tries} steps.
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
	
		<p>	Do you like to play a <a href="<c:url value="/game" />">new game</a>?</p>
	</body>
</html>