<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Spices R Us</title>
    <link rel="stylesheet" href="css/index.css">
</head>
<body>
    <!--Wrapper class encapsulates entire webpage-->
    <div class="wrapper">
        <!--Top header-->
        <header>
            <!--Navbar 1 (with search bar)-->
            <nav>                  
                <ul>
                    <li><a href="/login">LOGIN</a></li>
                    <li><a href="/cart">CART</a></li>
                </ul>
            </nav>
        </header>
        <!--Main navbar-->
        <nav>
            <ul>
                <li><a href="/"><img src="icons/home.svg" alt=""></a></li>
                <li><a href="/about">ABOUT</a></li>
                <li><a href="/shop">SHOP</a></li>
                <li><a href="/recipe">RECIPES</a></li>
            </ul>
        </nav>
    </div> 
</body>
</html>