<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="normalize.css">
<link rel="stylesheet" href="sqlproject.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update</title>
</head>
<body>
<header>
<div class="logo">
		<a href="index.html">MyDatabase</a>
	</div>
	<ul>	
		<li><a href="update.jsp">Edit</a></li>
		<li><a href="search.jsp">Search</a></li>
	</ul>
</header>
	<form class="search" action="update.do" method="GET">
		 <input type="text" placeholder="Enter to Insert, Update or Delete" name="newInfo"> 
		 <button type="submit" value="submit" name="submit">Update</button>
	</form>
</body>
</html>