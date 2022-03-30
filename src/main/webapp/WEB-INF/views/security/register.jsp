<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <jsp:include page="../base.jsp"/>
    <link href="/css/index/home.css" rel="stylesheet" type="text/css">
    <script src="https://kit.fontawesome.com/2f306254e3.js" crossorigin="anonymous"></script>


</head>

<style>

    body {
        background: url("../../images/back.jpg") no-repeat;
        background-size: cover;
        color: #333;
        font-size: 18px;
        font-family: "Monserrat", sans-serif;
    }


    .container1 {
        width: 35%;

        background: #ffffffe8;
        padding: 20px;
        border-radius: 10px;
        margin: 0;
        position: absolute;
        top: 55%;
        left: 50%;
        transform: translate(-50%, -50%);


    }

    .error {

        font-size: 16px;
        color: red;
    }

    .registerform {

        height: auto;

    }


    .input1 {
        display: block;
        font-size: 0.5em;
        font-weight: 600;
        padding-left: 0.5em;
        text-transform: uppercase;
        -webkit-transition: all 0.25s;
        transition: all 0.25s;

    }

    input:focus {
        outline: none;
    }

    .input2 {
        background: none;
        border: none;
        line-height: 1em;
        font-weight: 300;
        padding: 0.125em 0.25em;
        width: 100%;

    }

    .label1 {
        border-bottom: 1px solid #333;
        display: block;
        font-size: 1.25em;
        margin-bottom: 0.5em;
        -webkit-transition: all 0.25s;
        transition: all 0.25s;
    }

    .input3 {
        background: none;
        border: none;
        line-height: 1em;
        font-weight: 300;
        padding: 0.125em 0.25em;
        width: 80%;

    }

    .buttonsubimit {

        border: 1px solid #333;
        line-height: 1em;
        padding: 0.5em 0.5em;
        -webkit-transition: all 0.25s;
        transition: all 0.25s;
        margin-top: 10px;
        font-size: 20px;
        border-radius: 5px;
    }

    .buttonsubimit:hover {

        background: black;
        color: white;
        cursor: pointer;
    }

    .button {


        border: none;
        font-size: 16px;
        float: right;

    }

    .button:hover {
        cursor: pointer;
    }


    .submit {
        width: 100%;
        text-align: center;
    }
</style>
<script>
    function toggle() {
        x = document.getElementById("password1").type === "password";
        if (x) {
            document.getElementById("password1").type = "text";
            document.getElementById("password2").type = "text";
            document.getElementById("password1button").innerHTML = "<i class='fa-solid fa-eye-slash'></i>";
            document.getElementById("password2button").innerHTML = "<i class='fa-solid fa-eye-slash'></i>";


        } else {
            document.getElementById("password1").type = "password";
            document.getElementById("password2").type = "password";
            document.getElementById("password1button").innerHTML = "<i class='fa-solid fa-eye'></i>";
            document.getElementById("password2button").innerHTML = "<i class='fa-solid fa-eye'></i>";
        }
    }
</script>

<body>


<div class="container1">

    <h1 style="text-align:center;margin-bottom: 0px;">Create an account</h1>


    <div class="">
        <c:if test="${param.error != null}">
            <div class="alert alert-danger flex-wrap" role="alert">
                Please check your registration details are correct before clicking Complete Registration
            </div>
        </c:if>
    </div>

    <div class="registerform">
        <br>
        <form:form modelAttribute="user" action="/register" method="post">

            <div class="label1">
                <form:errors cssClass="error" path="username"/>
                <span class="input1">Username:</span>
                <form:input cssClass="input2" path="username"/>

            </div>
            <div class="label1">
                <form:errors cssClass="error" path="email"/>
                <span class="input1">Email:</span>
                <form:input cssClass="input2" path="email"/>

            </div>
            <div class="label1">
                <form:errors cssClass="error" path="password"/>
                <span class="input1">Password: </span>
                <form:password cssClass="input3" id="password1" path="password"/>
                <button class="button" type="button" id="password1button" onclick="toggle()"><i
                        class="fa-solid fa-eye"></i></button>
            </div>
            <div class="label1">
                <form:errors cssClass="error" path="confirmedPassword"/>
                <span class="input1">Confirm Password:</span>
                <form:password cssClass="input3" id="password2" path="confirmedPassword"/>
                <button class="button" type="button" id="password2button" onclick="toggle()"><i
                        class="fa-solid fa-eye"></i></button>
            </div>
            <div class="label1">
                <form:errors cssClass="error" path="firstName"/>
                <span class="input1">First Name:</span>
                <form:input cssClass="input2" path="firstName"/>

            </div>
            <div class="label1">
                <form:errors cssClass="error" path="lastName"/>
                <span class="input1">Last Name:</span>
                <form:input cssClass="input2" path="lastName"/>

            </div>
            <div class="submit">
                <input style="text-align:center;" class="buttonsubimit" type="submit" value="Register">
            </div>
        </form:form>
    </div>
</div>

</body>
</html>