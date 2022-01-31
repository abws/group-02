<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
</head>
<body>

<h1>User Login</h1>

<form action="/login" method="POST">
    <label for="username">Username:</label>
    <input type="text" id="username" name="username"/>
    <label for="password">Password:</label>
    <input type="password" name="password" id="password"/>
    <input type="submit" value="Login">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <p>Dont have an account.<a href="/login/register">Click here to register!</a></p>
</form>
</body>
</html>