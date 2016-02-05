<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- <link rel="stylesheet" href="normalize.css">
<link rel="stylesheet" href="book.css"> -->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
th, td {
	border: solid 1px
}
</style>
<title>Catalog</title>
</head>
<body>
	<header>
	<div class="logo">
		<a href="index.html">Ask the Database</a>
	</div>
	<ul>
		<li><a href="select.do">Search</a></li>
	</ul>

	</header>
	<h3>Results</h3>

	<c:choose>
		<c:when test="${! empty results}">
		<table>
			<tr>
				<c:forEach var="head" items="${results[0]}">
					<th>${head}</th>
				</c:forEach>
			</tr>
			
				<c:forEach var="result" begin="1" items="${results}">
					<tr>
						<c:forEach var="cell" items="${result}">
							<td>${cell}</td>
						</c:forEach>
					</tr>
				</c:forEach>
			</table>
		</c:when>
		<c:otherwise>
			<p>Not found</p>
		</c:otherwise>
	</c:choose>

</body>
</html>