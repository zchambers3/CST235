<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>THIS IS THE JSP FILE</title>
</head>
<body>

<h3> My name is <%= request.getParameter("info") %></h3>

</body>
</html>