<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="../base.jsp" />
</head>
<body>


<div class="login-box">

    <h1 class="text-center">Forgotten your Password</h1>
    <p class="text-center">Please enter your details below to send a reset code to your email.</p>

    <div class="d-flex justify-content-center">
        <br>

        <form:form action="/lost-password" modelAttribute="dto" method="POST">
            <div class="input-group mb-3">
                <span class="input-group-text">Username:</span>
                <form:input class="form-control" type="text" id="username" path="username" name="username"/>
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text">Email:</span>
                <form:input class="form-control" type="text" name="email" path="email" id="email"/>
            </div>

            <div class="input-group mb-3 justify-content-center">
                <button class="btn btn-success" type="submit">Send Reset Code</button>
            </div>
        </form:form>
    </div>
</div>

</body>
</html>