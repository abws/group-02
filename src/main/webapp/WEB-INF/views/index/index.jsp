<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Spices R Us</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Caveat+Brush&family=Londrina+Solid&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="<c:url value='css/index/index.css'/>">
</head>
<body>
    <!--Wrapper class encapsulates entire webpage-->
    <div class="wrapper">
        <!--Top header-->
        <header>
            <!--Search bar-->
            <div class="input-wrapper">
                <input type="text" placeholder="Search spices...">
                <!--Preprocess input on server-side, href to /shop for simplicity-->
                <div class="search-bar-button"><a href="/shop"><img src="icons/search-bar.svg" alt=""></a></div>
            </div>
            <div class="logo">
                <h1 class="logo-text">Spices R Us</h1>
            </div>
            <!--Navbar 1 (with search bar)-->
            <nav>                  
                <ul>
                    <div class="user" >
                        <a href="/login">
                            <li><img class="user-image" src="icons/user.svg" alt=""></li>
                            <li>LOGIN</li>
                        </a>
                    </div>
                    <li><a class="cart" href="#">CART</a></li>
                </ul>
            </nav>
        </header>

        <!--Main navbar-->
        <div class="main-nav">
            <nav>
                <ul>
                    <div class=left>
                        <li><a href="/"><img class="home"src="icons/home.svg" alt=""></a></li>
                        <li><a href="#">ABOUT</a></li>
                    </div>
                    <div class=logo>

                    </div>
                    <div class=right>
                        <li><a href="/spices">SHOP</a></li>
                        <li><a href="#">RECIPES</a></li>
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
                <svg class="underline" width="172" height="62" viewBox="0 0 172 62" fill="none" xmlns="http://www.w3.org/2000/svg">
                    <path d="M5 57C25.3668 37.7069 86.2803 0.390674 167 5.47037" stroke="#FAE3CC" stroke-width="9" stroke-linecap="round"/>
                </svg>
            </div>
                

        </section>
    </div> 
</body>
</html>