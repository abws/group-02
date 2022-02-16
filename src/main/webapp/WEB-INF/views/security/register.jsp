<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <jsp:include page="../base.jsp" />
</head>

<script>
    function toggle() {
        x = document.getElementById("password1").type === "password";
        if (x) {
            document.getElementById("password1").type = "text";
            document.getElementById("password2").type = "text";
            document.getElementById("password1button").textContent = "Hide";
            document.getElementById("password2button").textContent = "Hide";
        } else {
            document.getElementById("password1").type = "password";
            document.getElementById("password2").type = "password";
            document.getElementById("password1button").textContent = "Show";
            document.getElementById("password2button").textContent = "Show";
        }
    }
</script>

<body>


<div class="login-box">

    <h1 class="text-center">Create an account</h1>

    <div class="d-flex justify-content-center">
        <c:if test="${param.error != null}">
            <div class="alert alert-danger flex-wrap" role="alert">
                Please check your registration details are correct before clicking Complete Registration
            </div>
        </c:if>
    </div>

    <div class="d-flex justify-content-center">
        <br>
        <form:form modelAttribute="user" action="/register" method="post">
            <div class="input-group mb-3">
                <span class="input-group-text">Username:</span>
                <form:input cssClass="form-control" path="username"/>
                <form:errors cssClass="helpBlock" path="username"/><br>
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text">Email:</span>
                <form:input cssClass="form-control" path="email"/>
                <form:errors cssClass="helpBlock" path="email"/><br>
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text">Password:</span>
                <form:password cssClass="form-control" id="password1" path="password"/>
                <form:errors cssClass="helpBlock" path="password"/><br>
                <button class="btn btn-primary input-group-append" type="button" id="password1button" onclick="toggle()">View</button>
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text">Confirm Password:</span>
                <form:password cssClass="form-control" id="password2" path="confirmedPassword"/>
                <form:errors cssClass="helpBlock" path="confirmedPassword"/><br>
                <button class="btn btn-primary input-group-append" type="button" id="password2button" onclick="toggle()">View</button>
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text">First Name:</span>
                <form:input cssClass="form-control" path="firstName"/>
                <form:errors cssClass="helpBlock" path="firstName"/> <br>
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text">Last Name:</span>
                <form:input cssClass="form-control" path="lastName"/>
                <form:errors cssClass="helpBlock" path="lastName"/><br>
            </div>
            <input type="submit" value="Register">
        </form:form>
    </div>
</div>

</body>
</html>