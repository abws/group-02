<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="base.jsp" />
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

button{
	color: white;
    background: #fe8700;
    border: none;
    width: 30%;
    padding: 15px;
    border-radius: 10px;
    font-size: 18px;
    font-weight: 500;

}

button:hover {
  color: white;
  background:black;
  cursor:pointer;
}

</style>
<body>
<div class="msg">
<img src="../../images/denied.gif" width="600" height="400">


<h1>Please Login/Register to access this recipe.</h1>
<button onclick="location.href='/login'">Click to Login</button>


</div>
</body>
</html>