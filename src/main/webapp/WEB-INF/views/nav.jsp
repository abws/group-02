<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <link href="/css/index/home.css" rel="stylesheet" type="text/css">
    <script src="https://kit.fontawesome.com/2f306254e3.js" crossorigin="anonymous"></script>

</head>
<body>

<div class="hero-nav">


    <div class="navigation">

        <ul>

            <li style="font-family:Bradley Hand; font-size: 28px;border-right:none; font: weight 900px;;text-decoration: none;">
                <a href="/home">Spices R Us</a></li>
            <li><a href="/home"><i class="fa fa-home"></i>Home</a></li>

            <li><a href="/spices"><i class="fa-solid fa-store"></i>Shop</a></li>
            <li><a href="/recipes"><i class="fa-solid fa-receipt"></i>Recipe</a></li>
            <li style="border-right:none;"><a href="/membership"><i class="fa-solid fa-bookmark"></i>Membership</a></li>


            <li style="float:right; border-right:none;"><a href="/cart"><i
                    class="fa-solid fa-cart-shopping"></i>Cart(${cartSize})</a></li>
            <div class="user">
                <c:choose>
                    <c:when test="${username == null}">
                        <li style="float:right; border-right:1px solid #bbb;"><a href="/login"><i
                                class="fa-solid fa-user"></i>Login</a></li>
                    </c:when>
                    <c:otherwise>
                        <li style="float:right; border-right:1px solid #bbb; "><a href="/user?username=${username}"><i
                                class="fa-solid fa-user"></i>${username}</a></li>
                    </c:otherwise>
                </c:choose>
            </div>
            <div class="register">
                <c:choose>
                    <c:when test="${username == null}">
                        <li style="float:right; border-right:1px solid #bbb;"><a href="/register"><i
                                class="fa-solid fa-pen-to-square"></i>Register</a></li>
                    </c:when>
                    <c:otherwise>
                        <li style="float:right; border-right:1px solid #bbb;"><a href="/logout"><i
                                class="fa fa-sign-out"></i>Log Out</a></li>
                    </c:otherwise>
                </c:choose>
            </div>

        </ul>


    </div>


</div>


</body>
</html>