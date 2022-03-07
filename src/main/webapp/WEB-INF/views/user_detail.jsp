<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>User Detail</title>
    <jsp:include page="base.jsp"/>


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


    <style>
        * {
            box-sizing: border-box;
        }

        body {
            margin: 0;
            font-family: Arial, Helvetica, sans-serif;
        }

        /* Style the side navigation */
        .sidenav {
            height: 100%;
            width: 200px;
            position: fixed;
            z-index: 1;

            left: 0;
            background-color: #FB9350;
            overflow-x: hidden;
        }


        /* Side navigation links */
        .sidenav a {
            color: white;
            padding: 16px;
            text-decoration: none;
            display: block;
        }

        /* Change color on hover */
        .sidenav a:hover {
            background-color: #F28123;
            color: white;
        }

        /* Style the content */
        .content {
            margin-left: 200px;
            padding-left: 20px;
            margin-top: 5vh;
        }
    </style>
</head>
<body>
<div class="sidenav">
    <a href="#">My Details</a>
    <a href="#">My Address</a>
    <a href="#">My Orders</a>
    <a href="#">My Preference</a>
</div>

<div class="content">
    <h2 class="text-center">User Profile Details</h2>

    <div class="d-flex justify-content-center">
        <br>
        <sec:authorize access="isAuthenticated()">


            <form:form modelAttribute="user" action="/user" method="post">

                <div class="input-group mb-3">
                    <span class="input-group-text">Username:</span>
                    <form:input cssClass="form-control" readonly="true" path="username"/>
                        <%--                <form:errors cssClass="helpBlock" path="username"/><br>--%>
                </div>
                <div class="input-group mb-3">
                    <span class="input-group-text">Email:</span>
                    <form:input cssClass="form-control" path="email"/>
                    <form:errors cssClass="helpBlock" path="email"/><br>
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

                <div class="input-group mb-3">
                    <span class="input-group-text">Password:</span>
                    <form:password cssClass="form-control" id="password1" path="password" placeholder="****"/>
                    <form:errors cssClass="helpBlock" path="password"/><br>
                    <button class="btn btn-primary input-group-append" type="button" id="password1button"
                            onclick="toggle()">View
                    </button>
                </div>
                <div class="input-group mb-3">
                    <span class="input-group-text">Confirm Password:</span>
                    <form:password cssClass="form-control" id="password2" path="confirmedPassword" placeholder="****"/>
                    <form:errors cssClass="helpBlock" path="confirmedPassword"/><br>
                    <button class="btn btn-primary input-group-append" type="button" id="password2button"
                            onclick="toggle()">View
                    </button>
                </div>
                <div class="input-group mb-3">
                    <span class="input-group-text">User Roles:</span>
                    <input readonly value="<sec:authentication property="principal.authorities"/>">
                </div>

                <input type="submit" value="Change Details">
            </form:form>
        </sec:authorize>

    </div>
</body>

</html>
