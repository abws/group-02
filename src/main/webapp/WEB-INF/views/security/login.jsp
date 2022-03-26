<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="../base.jsp" />
</head>
<body>


<div class="login-box">

    <h1 class="text-center">Login</h1>

    <div class="d-flex justify-content-center">
        <c:if test="${param.error != null}">
            <div class="alert alert-danger flex-wrap" role="alert">
                Your login credentials were incorrect.
            </div>
        </c:if>
    </div>
    <div class="d-flex justify-content-center">
        <br>
        <form action="/login" method="POST">
            <div class="input-group mb-3">
                <span class="input-group-text">Username:</span>
                <input class="form-control" type="text" id="username" name="username"/>
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text">Password:</span>
                <input class="form-control" type="password" name="password" id="password"/>
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text">Remember Me:</span>
                <input class="form-control" type="checkbox" name="remember-me" id="remember-me"/>
            </div>

            <div class="input-group mb-3 justify-content-center">
                <button class="btn btn-success" type="submit">Login</button>
            </div>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <p>Dont have an account? <a href="/register">Click here to register!</a></p>
            <p>Forgotten your password? <a href="/lost-password">Reset it here</a></p>
        </form>
    </div>
</div>

</body>
</html>