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
    <link href="https://fonts.googleapis.com/css2?family=Londrina+Solid&display=swap" rel="stylesheet">
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
                <div class="search-bar-button"><img src="icons/search-bar.svg" alt=""></div>
            </div>
            <!--Navbar 1 (with search bar)-->
            <nav>                  
                <ul>
                    <li><a href="/login">LOGIN</a></li>
                    <li><a href="/cart">CART</a></li>
                </ul>
            </nav>
        </header>
        <div class="clearfix"></div>

        <!--Main navbar-->
        <div class="main-nav">
            <nav>
                <ul>
                    <li><a href="/"><img src="icons/home.svg" alt=""></a></li>
                    <li><a href="/about">ABOUT</a></li>
                    <li><a href="/shop">SHOP</a></li>
                    <li><a href="/recipe">RECIPES</a></li>
                </ul>
            </nav>
        </div>
    </div> 
</body>
</html>