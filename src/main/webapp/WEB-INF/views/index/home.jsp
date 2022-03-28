<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spices R Us</title>

<script src="https://kit.fontawesome.com/2f306254e3.js" crossorigin="anonymous"></script>

<link href="/css/index/home.css" rel="stylesheet" type="text/css">
	


</head>

<script>
    function openSearch() {
      document.getElementById("myOverlay").style.display = "block";
    }
    
    function closeSearch() {
      document.getElementById("myOverlay").style.display = "none";
    }
    </script>

<body>


   

<section class="hero">
    <div class="hero-nav">


        <div class ="navigation">

            <div id="myOverlay" class="h_overlay">
                <span class="closebtn" onclick="closeSearch()" title="Close Overlay">×</span>
                <div class="h_overlay-content">
                 
      
		            <form action="/spicesearch" class="searchform" method="GET">
				    	<input name="spice" type="text" class="searchTerm" placeholder="What are you looking for?">
		      			<button type="submit" class="searchButton">
							<i class="fa-solid fa-magnifying-glass"></i>
		     			</button>
					</form>
				

		
                </div>
              </div>
              
       
            <ul>
           
                <li style="font-family:Bradley Hand; font-size: 28px;border-right:none; font: weight 900px;;text-decoration: none;" > <a href="/home">Spices R Us</a> </li>
                <li><a href="/home"><i class="fa fa-home"></i>Home</a></li>
               
                <li><a href="/spices"><i class="fa-solid fa-store"></i>Shop</a></li>
                <li><a href="/recipes"><i class="fa-solid fa-receipt"></i>Recipe</a></li>
                <li> <button class="openBtn" onclick="openSearch()"><i class="fa-solid fa-magnifying-glass"></i>Search</button></li>
   
                
                <li style="float:right"><a href="cart"><i class="fa-solid fa-cart-shopping"></i>Cart(${cartSize})</a></li>
				<div class="user">
                    <c:choose>
                        <c:when test="${username == null}">
                            <li style="float:right; border-right:1px solid #bbb;"><a href="/login"><i class="fa-solid fa-user"></i>Login</a></li>
                        </c:when>
                        <c:otherwise>
                            <li style="float:right; border-right:1px solid #bbb; "><a href="/user?username=${username}"><i class="fa-solid fa-user"></i>${username}</a></li>
                        </c:otherwise>
                    </c:choose>
                </div>
				<div class="register">
                    <c:choose>
                        <c:when test="${username == null}">
                            <li style="float:right; border-right:1px solid #bbb;"><a href="/register"><i class="fa-solid fa-user"></i>Register</a></li>
                        </c:when>
                        <c:otherwise>
                            <li style="float:right; border-right:1px solid #bbb;"><a href="/logout"><i class="fa fa-sign-out"></i>Log Out</a></li>
                        </c:otherwise>
                    </c:choose>
                </div>

            </ul>
				
           

        </div>

    
    </div>
    
    <div class="hero-content">
        
       <h1 class="hero-title">
            Discover the  Nature
       </h1>
         
       <h2 class="hero-subtitle">
            We offer the best and organic spices.
       </h2>

    
        
       <button type="button" class="hero-button" onclick="location.href='/spices'">
            View our spices <i class="fa-solid fa-angles-right"></i>
       </button>

      
    
  
    </div>

</section>

<div class="feature_box">

    <div class="title">
        <h1>
            About Us
        </h1>
    </div>

    <div class="feature">

        <div class="f_right">
            <p>
                Spices have a long and old history, they are used across the world, where they are a part of life and
                culture.
            <br><br> 
                In each home and in each region the nation over, various spices and mixes are used to make unique
                and unmistakable preferences for dishes. 
            <br><br> 
                Before the modern age, housewives used to prepare their spices
                physically at home and make their own mixes for use in their cooking. 

        

                <br><br> 
                Spices R Us aims to make this process
                easier for you to get quality products for the best price. 
            <br>  <br> 
                Our founder aimed to source and provide
                quantities suitable for cooking and we hope that everyone can experience the joy of good food.
            </p> 
          
        </div>

        <div class= "f_left">
            <div class = "f_img">
                <img src= "../../images/recipe.webp" >
            </div>

        </div>


    </div>

</div>



<div class="spices_container">   
    <div class="s_text">
     
        <h1 > Pure Organic Spices</h1>
        <p>Our natural and organic range includes peppers, salts, and blends spices.</p>
        <div class="s_text">
            <button class= "s_button" onclick="location.href='/spices'" > Explore Our Spices <i class="fa-solid fa-angles-right"></i></button>
      
        </div> 
    </div> 
   
         
</div>



<div class="container_category">

    <div class="title">
        <h1>
            Shop by Category
           
        </h1>

    </div>

    <div class="row">
        <div class="column">
            <div class="category">
                <a href="/spices">
                    <img  style="border-radius: 25px;"src="https://static.onecms.io/wp-content/uploads/sites/43/2020/01/GettyImages-500491224-2000.jpg" alt="Mountains" width="200px" height="200px">
                </a>
                <button style="text-align: center;" onclick="location.href='/spices'"> ALL CATEGORY</button>
                
            </div>
        </div>

        <div class="column">
            <div class="category">
                <a href="/spices?sort=salts">
                    <img style="border-radius: 25px;"src="https://www.thesprucecrafts.com/thmb/X76BKNZAdN5P2dF5yUXaO6wSxU8=/2576x2576/smart/filters:no_upscale()/salt-from-the-sea-149456195-58adf8b75f9b58a3c9f8d6bd.jpg" width="200px" height="200px">
                </a>
                <button style="text-align: center;" onclick="location.href='/spices?sort=salts'">SALTS</button>

               
            </div>
        </div>
    
        <div class="column">
            <div class="category">
                <a href="/spices?sort=spiceBlends">
                    <img style="border-radius: 25px;"src="https://cdn.apartmenttherapy.info/image/upload/f_jpg,q_auto:eco,c_fill,g_auto,w_1500,ar_1:1/k%2Farchive%2F82e15235d90e93b6ea79f08debb52cb5ffb2d8e7" alt="Mountains" width="200px" height="200px">
                </a>
                <Button style="text-align: center;" onclick="location.href='/spices?sort=spiceBlends'">SPICE BLENDS</button>
                
            </div>
        </div>
    
        
        <div class="column">
            <div class="category">
                <a href="/spices?sort=peppers">
                    <img style="border-radius: 25px;"src="https://assets.epicurious.com/photos/5806941b9bb3c66e1f64bc50/1:1/w_1332,h_1332,c_limit/black_peppercorns_wooden_spoon_19102016.jpg" alt="Mountains" width="200px" height="200px">
                </a>

                <button style="text-align: center;" onclick="location.href='/spices?sort=peppers'">PEPPERS</button>

                
            </div>
        </div>
    </div>
</div> 





<div class="dinner_container">   
    <div class="d_text">
     
        <h1 > What's For Dinner Tonight?</h1>
        <p>Discover our recipe collection with traditional recipes from different regions.</p>
        <div class="d_text">
            <button class= "d_button" onclick="location.href='/recipes'"> Explore Our Recipes <i class="fa-solid fa-angles-right"></i> </button>
      
        </div> 
    </div> 
   
         
</div>


<div class="container_recipe">
    <div class="row">
        <div class="column">
            <div class="recipe">
                <a href="">
                    <img src="https://www.acouplecooks.com/wp-content/uploads/2020/12/Honey-Garlic-Shrimp-026.jpg" alt="Mountains">
                </a>

                <div class="overlay">
                    <div class="text">
                        <p>Honey Garlic Shrimp</p>
                        <button class="recipe-button">Explore</button>
                    </div>
                </div>
            </div>
        </div>

        <div class="column">
            <div class="recipe">
                <a target="" href="">
                    <img src="https://www.acouplecooks.com/wp-content/uploads/2021/06/Vegan-Meatballs-018.jpg" alt="Mountains" >
                </a>

                <div class="overlay">
                    <div class="text">
                        <p>Easy Vegan Meatballs</p>
                        <button class="recipe-button">Explore</button>
                    </div>
                </div>
            </div>
        </div>
    
        <div class="column">
            <div class="recipe">
                <a target="_blank" href="">
                    <img src="https://www.acouplecooks.com/wp-content/uploads/2021/06/Arugula-Pizza-003.jpg" alt="Mountains">
                </a>

                <div class="overlay">
                    <div class="text">
                        <p>Sheet Pan Pizza</p>
                        <button class="recipe-button">Explore</button>
                    </div>
                </div>
            </div>
        </div>
        
        
      
        
        <div class="column">
            <div class="recipe">
                <a target="_blank" href="">
                    <img src="https://www.acouplecooks.com/wp-content/uploads/2020/01/Broiled-Salmon-011.jpg" alt="Mountains">
                </a>

                <div class="overlay">
                    <div class="text">
                        <p>Quick Broiled Salmon</p>
                        <button class="recipe-button">Explore</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div> 


  




         


<div class="subscribe_container">



    <form action="/action_page.php">
        <div class="subscribe">
        <h1>Newsletter</h1>
        <p>Sign up now and get 20% on your order!</p>
        </div>
    
        <div class="subscribe">
    
        <input type="text" placeholder="Enter your email address" name="mail" required>
    
        <input type="submit" value="Subscribe">
        </div>
    </form>

</div>

<footer>
    <p>&copy; 2022 Group 02, Software Engineering Project. All Rights Reserved</p>
</footer>

</body>

</html>