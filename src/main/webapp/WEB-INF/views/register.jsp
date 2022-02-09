<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <jsp:include page="base.jsp" />
</head>

<body>

<div class="login-box">

    <h1 class="text-center">Create an account</h1>

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
                <form:password cssClass="form-control" path="password"/>
                <form:errors cssClass="helpBlock" path="password"/><br>
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text">Confirm Password:</span>
                <form:password cssClass="form-control" path="confirmedPassword"/>
                <form:errors cssClass="helpBlock" path="confirmedPassword"/><br>
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