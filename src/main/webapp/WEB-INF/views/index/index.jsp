<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Spices R Us</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Caveat+Brush&family=Londrina+Solid&display=swap"
          rel="stylesheet">
    <link rel="stylesheet" href="<c:url value='css/index/index.css'/>">
    <style>
        #udetail {
            visibility: hidden;
        }
    </style>
</head>
<body>
<!--Wrapper class encapsulates entire webpage-->
<div class="wrapper">
    <!--Top header-->
    <header>
        <!--Search bar-->
        <div class="input-wrapper">
            <form action="/spicesearch" method="GET">
                <input name="spice" type="text" placeholder="Search spices...">
            </form>

            <!--Preprocess input on server-side, href to /shop for simplicity-->
            <div class="search-bar-button"><a href="/shop"><img src="icons/search-bar.svg" alt=""></a></div>

        </div>
        <div class="logo">
            <h1 class="logo-text">Spices R Us</h1>
        </div>
        <!--Navbar 1 (with search bar)-->
        <nav>
            <ul>
                <div class="user">
                    <c:choose>
                        <c:when test="${username == null}">
                            <a href="/login">
                                <li>LOGIN</li>
                            </a>
                        </c:when>
                        <c:otherwise>
                            <a href="/user?username=${username}">
                                <li>
                                    <img class="user-image" src="icons/user.svg" alt=""></li>
                                <li>${username}</li>
                            </a>
                        </c:otherwise>
                    </c:choose>
                </div>
                <div class="register">
                    <c:choose>
                        <c:when test="${username == null}">
                            <a href="/register">
                                <li>REGISTER</li>
                            </a>
                        </c:when>
                        <c:otherwise>
                            <a href="/logout">
                                <li>LOGOUT</li>
                            </a>
                        </c:otherwise>
                    </c:choose>
                </div>

                <li><a class="cart" href="/cart">CART</a></li>
            </ul>
        </nav>
    </header>

    <!--Main navbar-->
    <div class="main-nav">
        <nav>
            <ul>
                <div class=left>
                    <li><a href="/"><img class="home" src="icons/home.svg" alt=""></a></li>
                    <li><a href="/membership">MEMBERSHIP</a></li>
                </div>
                <div class=logo>

                </div>
                <div class=right>
                    <li><a href="/spices">SHOP</a></li>
                    <li><a href="/recipes">RECIPES</a></li>
                </div>
            </ul>
        </nav>
    </div>
    <!--First Body Block-->
    <section class="hero">
        <div class="hero-text">
            <p>FRESH.</p>
            <p>FRAGRANT.</p>
            <p>FAMILY OWNED</p>
            <svg class="underline" width="172" height="62" viewBox="0 0 172 62" fill="none"
                 xmlns="http://www.w3.org/2000/svg">
                <path d="M5 57C25.3668 37.7069 86.2803 0.390674 167 5.47037" stroke="#FAE3CC" stroke-width="9"
                      stroke-linecap="round"/>
            </svg>
        </div>
    </section>
    <section style="position: absolute; top: 80vh;">
        <p>
        <div class="lower-section">
            Spices have a long and old history, they are used across the world, where they are a part of life and
            culture. In each home and in each region the nation over, various spices and mixes are used to make unique
            and unmistakable preferences for dishes. Before the modern age, housewives used to prepare their spices
            physically at home and make their own mixes for use in their cooking. Spices R Us aims to make this process
            easier for you to get quality products for the best price. Our founder aimed to source and provide
            quantities suitable for cooking and we hope that everyone can experience the joy of good food.
        </div>
        </p>
    </section>
</div>
</body>
</html>