<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Caveat+Brush&family=Londrina+Solid&display=swap"
          rel="stylesheet">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <jsp:include page="base.jsp"/>
    <title>Membership</title>

</head>

<style>

  .hero-nav {
   		 background-color: rgb(255, 136, 0);
   		 
   		}
      
      .navigation ul {
	    list-style-type: none;
	    margin: 0;
	    padding: 0;
	    overflow: hidden;
	    font-size: 18px;
	    font-family:"Monserrat", sans-serif;
	    font-weight: 900;
	    background-color: rgb(255, 136, 0);
	    
	  }
    html, body {
        height: 100%;
        width: 100%;
        margin: 0;
        font-family: "Monserrat", sans-serif;
      }
    
    .container {
         
  align-items: center;
  justify-content: center;
            margin:3%;
            padding: 15px;
    
        }
    
    .columns {
		  float: left;
		  width: 33.3%;
		  padding: 8px;
		  
}

* {
  box-sizing: border-box;
}

.price {
  list-style-type: none;
  border: 1px solid #eee;
  margin: 0;
  padding: 0;
  -webkit-transition: 0.3s;
  transition: 0.3s;
   border-radius:15px;
   text-align: center;
}

.price .header {
  background-color: #111;
  color: white;
  font-size: 25px;
}

.price:hover {
  box-shadow: 0 8px 12px 0 rgba(0,0,0,0.2)
}



.price .header {
    background-color: #ffffff;
    color: black;
    font-size: 25px;
    text-align: center;
    border-bottom: 2px solid rgb(255 136 0);
}

.price li {
  border-bottom: 1px solid #eee;
  padding: 20px;
  text-align: center;
 
}

ul {
  list-style: none;
}

.columns ul li:before {
  content: '\2713\0020';
}

.button {
  background-color: rgb(255 136 0);
  border: none;
  color: white;
  padding: 10px 25px;
  text-align: center;
  text-decoration: none;
  font-size: 18px;
  border-radius:10px;
}


.button:active {
  background-color: black;

}

.selectedbutton{
  background-color: black;
   border: none;
  color: white;
  padding: 10px 25px;
  text-align: center;
  text-decoration: none;
  font-size: 18px;
  border-radius:10px;
}

.button:hover {

cursor:pointer;

}

.btn{

text-align:center;
margin:20px;

}


</style>




<body>



<div class="container">

<h1 style="text-align:center;">Membership Plans</h1>



    <div class="columns">

                
                <div class="price">
                <img src="../images/shopping2.webp" width="300px" height="200px">
                	
                
                    <h2 class="header">Basic Membership</h2>
                    <ul>
                        <li>Access to free recipes</li>
                        <li>Access to discussion board</li>
                        <li>Easy to checkout</li>
                    </ul>
                    
                    <div class="btn">
                    <c:choose>
                        <c:when test="${membership eq 'BASIC'}">
                            <button class="selectedbutton">SELECTED</button>
                        </c:when>
                        <c:when test="${membership eq 'NONE'}">
                            <a class="button" href="/login">LOGIN</a>
                        </c:when>
                        <c:when test="${membership ne 'BASIC'}">
                            <form action="/membership/basic" method="post">
                                <button class="button" >Select Plan</button>
                            </form>
                        </c:when>
                    </c:choose>
                       </div>
                </div>
            </div>
            
            <div class="columns">
               
                <div class="price">
                <img src="../images/cooking.webp" width="300px" height="200px">
                    <h2 class="header">Novice Membership</h2>
                    <ul>
                        <li>20% price discount across the store</li>
                        <li>Access to restricted recipes</li>
                        <li>Prioritized support</li>
                    </ul>
                    
                    <div class="btn">
                    <c:choose>
                        <c:when test="${membership eq 'NOVICE'}">
                            <button class="selectedbutton" >SELECTED</button>
                        </c:when>
                        <c:when test="${membership eq 'NONE'}">
                            <a class="button" href="/login">LOGIN</a>
                        </c:when>
                        <c:when test="${membership ne 'NOVICE'}">
                            <form action="/membership/novice" method="post">
                                <button class="button" >Select Plan</button>
                            </form>
                        </c:when>
                    </c:choose>
                    </div>
                </div>
            </div>
            
            <div class="columns">
               
                <div class="price">
                <img src="../images/cooking2.webp" width="300px" height="200px">
                    <h2 class="header">Expert Membership</h2>
                    <ul>
                        <li>Novice Membership Features</li>
                        <li>Access to bulk-quantities</li>
                        <li>Prioritized support</li>
                    </ul>
                    
                    <div class="btn">
                    <c:choose>
                        <c:when test="${membership eq 'EXPERT'}">
                            <button class="selectedbutton" >SELECTED</button>
                        </c:when>
                        <c:when test="${membership eq 'NONE'}">
                            <a class="button" href="/login">LOGIN</a>
                        </c:when>
                        <c:when test="${membership ne 'EXPERT'}">
                            <form action="/membership/expert" method="post">
                                <button class="button" >Select Plan</button>
                            </form>
                        </c:when>
                    </c:choose>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>