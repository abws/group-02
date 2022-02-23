<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="../base.jsp" />
</head>
<body>


<div class="login-box">

    <h1 class="text-center">Reset Password</h1>
    <p class="text-center">A reset code has been sent to the email you provided.</p>

    <div class="d-flex justify-content-center">
        <br>
        <form:form action="/reset-password" modelAttribute="dto" method="POST">
            <div class="input-group mb-3">
                <span class="input-group-text">Reset Code:</span>
                <form:input class="form-control" type="text" name="token" id="token" path="providedToken"/>
            </div>
        <div class="input-group mb-3">
            <span class="input-group-text">Password:</span>
            <form:input class="form-control" type="password" name="password" id="password" path="password"/>
        </div>
        <div class="input-group mb-3">
            <span class="input-group-text">Confirmed Password:</span>
            <form:input class="form-control" type="password" name="confirmedPassword" id="confirmedPassword" path="confirmedPassword"/>
        </div>

        <div class="input-group mb-3 justify-content-center">
                <button class="btn btn-success" type="submit">Submit Password Reset</button>
            </div>
        </form:form>
    </div>
</div>

</body>
</html>