<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="../base.jsp"/>
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
body{
	
	color: #333;
	
	font-family:"Monserrat", sans-serif;
}

.msg{

text-align:center;


 position: absolute;
    top: 55%;
    left: 50%;
    transform: translate(-50%, -50%);


}

</style>

<body>


<div class="msg">

<img src="../../images/success.webp" width="600" height="400">

<h1>Registration Success</h1>

<p>You have successfully registered on the website! You can now access a price discount.</p>

</div>

</body>
</html>