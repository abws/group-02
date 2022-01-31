<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
</head>
<body>

<h1>User Registration</h1>

<form:form modelAttribute="user" action="/login/register" method="post">
    <form:label for="username" path="username">Username:</form:label>
    <form:input path="username"></form:input>
    <br>
    <form:label for="password" path="password">Password:</form:label>
    <form:password path="password"></form:password>
    <br>
    <br>
    <form:label for="email" path="email">Email:</form:label>
    <form:input path="email"></form:input>
    <br>
    <form:label for="confirmPassword" path="confirmedPassword">Confirm Password:</form:label>
    <form:password path="confirmedPassword"></form:password>
    <br>
    <form:label for="firstName" path="firstName">First Name:</form:label>
    <form:input path="firstName"></form:input>
    <br>
    <form:label for="lastName" path="lastName">Last Name:</form:label>
    <form:input path="lastName"></form:input>
    <br>
    <input type="submit" value="Register">
</form:form>
</body>
</html>