<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="normalize.css">
<link rel="stylesheet" href="sqlproject.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Query</title>
</head>
<body>
<header>
<div class="logo">
	<a href="index.html">Database</a>
</div>
<ul>
	<li><a href="search.jsp">Search</a></li>
	<li><a href="update.jsp">Edit</a></li>
</ul>
</header>
	<form class="search" action="select.do" method="GET">
		<input type="text" placeholder="Enter Query" name="sqlText">
		<button type="submit" value="submit" name="submit">Search</button>
	</form>
</body>
</html>