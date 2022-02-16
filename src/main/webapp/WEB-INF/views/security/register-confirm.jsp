<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <jsp:include page="../base.jsp"/>
</head>
<body>

<script>
    function toggle() {
        element = document.getElementById("password");
        button = document.getElementById("passwordButton")
        x = element.getAttribute("type") === "password";
        if (x) {
            element.type = "text";
            button.textContent = "Hide";
        } else {
            element.type = "password";
            button.textContent = "Show";
        }
    }
</script>

<div class="login-box">

    <h1 class="text-center">Create an account</h1>

    <div class="d-flex justify-content-center">
        <div class="alert alert-danger flex-wrap" role="alert">
            Please check your registration details are correct before clicking Complete Registration
        </div>
    </div>

    <div class="d-flex justify-content-center">
        <br>
        <form:form modelAttribute="user" action="/confirmRegistration" method="post">
            <div class="input-group mb-3">
                <span class="input-group-text">Username:</span>
                <form:input cssClass="form-control" path="username"></form:input>
                <form:errors cssClass="helpBlock" path="username"/><br>
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text">Email:</span>
                <form:input cssClass="form-control" path="email"></form:input>
                <form:errors cssClass="helpBlock" path="email"/><br>
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text">Password:</span>
                <form:password cssClass="form-control" id="password" path="confirmedPassword"
                               value="${details.password}" readonly="true"></form:password>
                <form:errors cssClass="helpBlock" path="password"/><br>
                <button class="btn btn-primary input-group-append" type="button" id="passwordButton" onclick="toggle()">View</button>
            </div>
            <form:hidden cssClass="form-control" path="password"></form:hidden>
            <div class="input-group mb-3">
                <span class="input-group-text">First Name:</span>
                <form:input cssClass="form-control" path="firstName"></form:input>
                <form:errors cssClass="helpBlock" path="firstName"/> <br>
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text">Last Name:</span>
                <form:input cssClass="form-control" path="lastName"></form:input>
                <form:errors cssClass="helpBlock" path="lastName"/><br>
            </div>

            <input type="submit" value="Complete Registration">

        </form:form>
    </div>
</div>

</body>
</html>