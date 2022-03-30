<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <jsp:include page="../base.jsp"/>
</head>


<script>
    function toggle() {
        element = document.getElementById("password");
        button = document.getElementById("passwordButton")
        x = element.getAttribute("type") === "password";
        if (x) {
            element.type = "text";
            button.innerHTML = "<i class='fa-solid fa-eye-slash'></i>";
        } else {
            element.type = "password";
            button.innerHTML = "<i class='fa-solid fa-eye'></i>";
        }
    }
</script>

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
        text-align: center;
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
        width: 20%;

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
        width: 80%;

    }

    .label1 {
        border-bottom: 1px solid #333;
        display: block;
        font-size: 1.25em;
        margin-bottom: 0.5em;
        -webkit-transition: all 0.25s;
        transition: all 0.25s;
        display: flex;

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

<body>
<div class="container1">

    <h1 style="text-align:center;margin-bottom: 0px;">Confirm Registration </h1>

    <div class="d-flex justify-content-center">
        <div class="error" role="alert">
            Please check your registration details are correct before clicking Complete Registration.
        </div>
    </div>

    <div class="d-flex justify-content-center">
        <br>
        <form:form modelAttribute="user" action="/confirmRegistration" method="post">
            <div class="label1">
                <p class="input1">Username:</p>
                <form:input cssClass="input2" path="username"></form:input>
                <form:errors cssClass="error" path="username"/><br>
            </div>
            <div class="label1">
                <p class="input1">Email:</p>
                <form:input cssClass="input2" path="email"></form:input>
                <form:errors cssClass="error" path="email"/><br>
            </div>
            <div class="label1">
                <p class="input1">Password:</p>
                <form:password cssClass="input3" id="password" path="confirmedPassword"
                               value="${details.password}" readonly="true"></form:password>
                <form:errors cssClass="error" path="password"/>
                <button class="button" type="button" id="passwordButton" onclick="toggle()"><i
                        class="fa-solid fa-eye"></i></button>
            </div>
            <form:hidden cssClass="input2" path="password"></form:hidden>
            <div class="label1">
                <p class="input1">First Name:</p>
                <form:input cssClass="input2" path="firstName"></form:input>
                <form:errors cssClass="error" path="firstName"/> <br>
            </div>
            <div class="label1">
                <p class="input1">Last Name:</p>
                <form:input cssClass="input2" path="lastName"></form:input>
                <form:errors cssClass="error" path="lastName"/><br>
            </div>

            <div class="submit">
                <input class="buttonsubimit" type="submit" value="Complete Registration">

            </div>

        </form:form>
    </div>
</div>

</body>
</html>