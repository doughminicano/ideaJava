<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>


<head>

<meta charset="ISO-8859-1">

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %> 
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<title>Ideas Homepage</title>

</head>

<body>
	<h1>Welcome, <c:out value="${user.firstName}" /></h1>
	
		<a class=" btn btn-danger" href="/logout">Logout</a>
	
	<h1>Ideas</h1>
	
	<table class="table table-dark">
  <thead>
    <tr>
      <th scope="col">Ideas</th>
      <th scope="col">Created By:</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${allIdeas}" var="idea" />
    <tr>
      <th scope="row"></th>
      <td><c:out value="${idea.content}" /></td>
      <td><c:out value="${idea.user.firstName}" /></td>
    </tr>
  </tbody>
</table>

	<a class="btn btn-warning" href="/new/ideas">Create an Idea</a>

</body>

</html>