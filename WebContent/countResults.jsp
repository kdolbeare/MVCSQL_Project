<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="normalize.css">
<link rel="stylesheet" href="sqlproject.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- <style>
th, td {
	border: solid 1px
}
</style> -->
<title>Catalog</title>
</head>
<body>
	<header>
	<div class="logo">
		<a href="index.html">Ask the Database</a>
	</div>
	<ul>
		<li><a href="search.jsp">Search</a></li>
		<li><a href="update.jsp">Edit</a></li>
	</ul>

	</header>

	<h3>Update</h3>
	<c:choose>
		<c:when test="${! empty count}">
			<p>${count}row(s)updated.</p>
		</c:when>
		<c:otherwise>
			<p>Not found</p>
		</c:otherwise>
	</c:choose>
</body>
</html>