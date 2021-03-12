<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>


<head>

<meta charset="ISO-8859-1">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<title>Edit Idea</title>


</head>


<body>
<h3>Edit </h3>


<div>
<form class="form-group" method="POST" action="/new/{id)/edit" modelAttribute="content">
<p>
    <label for="content">Content</label>
    <input type="text" id="content name="content" />
</p>
     <input class="btn btn-warning" type="submit" value="Update" />
</form>

<input class="btn btn-danger" type="submit" value="Delete" />
</div>
</body>
</html>