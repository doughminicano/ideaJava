<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>

<meta charset="ISO-8859-1">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<link rel="stylesheet" type="text/css" href="../css/style.css">

<title>Great Ideas</title>


</head>

<body>
        <div id="container">
            <h1 id="head">Please Register or Login</h1>
            <div class="row">
                <div class="col">
                    <h2>Register</h2>
                    <p>
                        <form:errors class="text-danger" path="user.*" />
                    </p>

                    <form:form class="form-group" method="POST" action="/registration" modelAttribute="user">
                        <p>
                            <form:label path="firstName">First Name:</form:label>
                            <form:input type="text" path="firstName" />
                        </p>
                        <p>
                            <form:label path="lastName">Last Name:</form:label>
                            <form:input type="text" path="lastName" />
                        </p>
                        <p>
                            <form:label path="email">Email:</form:label>
                            <form:input type="email" path="email" />
                        </p>
                        <p>
                            <form:label path="password">Password:</form:label>
                            <form:password path="password" />
                        </p>
                        <p>
                            <form:label path="passwordConfirmation">Password Confirmation:</form:label>
                            <form:password path="passwordConfirmation" />
                        </p>
                        <input class="btn btn-warning" type="submit" value="Register!" />
                    </form:form>
                </div>
                <div class="col">
                    <h2>Login</h2>
                    <p>
                        <c:out value="${error}" />
                    </p>
                    <form class="form-group" method="POST" action="/login">
                        <p>
                            <label for="email">Email</label>
                            <input type="text" id="email" name="email" />
                        </p>
                        <p>
                            <label for="password">Password</label>
                            <input type="password" id="password" name="password" />
                        </p>
                        <input class="btn btn-warning" type="submit" value="Login!" />
                    </form>
                </div>
            </div>
        </div>
</body>
</html>