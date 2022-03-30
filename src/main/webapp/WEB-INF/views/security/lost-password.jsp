<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="../base.jsp" />
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

.container1{
    width: 80%;
    padding: 20px;
    border-radius: 10px;
    margin: 0;
    position: absolute;
    top: 55%;
    left: 50%;
    transform: translate(-50%, -50%);
    display: flex;
    
}

.left{
    width: 60%;
   
    background: url("../../images/password.webp") no-repeat;
    padding: 20px;
    border-radius: 10px;
    background-size: cover;
    height: 500px;
 
  
}

.right{
    margin-top: 8%;
    width: 40%;
    background: #ffffffe8;
    padding: 20px;
    border-radius: 10px;

  
}

.input1{
display: block;
    font-size: 0.5em;
font-weight: 600;
    padding-left: 0.5em;
    text-transform: uppercase;
    -webkit-transition: all 0.25s;
    transition: all 0.25s;
    
}

input:focus{
    outline: none;
}

.input2{
    background: none;
    border: none;
    line-height: 1em;
    font-weight: 300;
    padding: 0.125em 0.25em;
    width: 100%;

}

.label1{
    border-bottom: 1px solid #333;
    display: block;
    font-size: 1.25em;
    margin-bottom: 0.5em;
    -webkit-transition: all 0.25s;
    transition: all 0.25s;
}

.buttonsubimit{
    
    border: 1px solid #333;
    line-height: 1em;
    padding: 0.5em 0.5em;
    -webkit-transition: all 0.25s;
    transition: all 0.25s;
    margin-top:10px;
    font-size: 20px;
    width: 50%;
    margin:20px;
    background: black;
	color:white;
	border-radius: 5px;
    
}

.buttonsubimit:hover{

    background:#fe8700;
    border:#fe8700;
	color:white;
	cursor:pointer;
}

.submit{
	width:100%;
	text-align: center;

}

</style>

<body>

<div class="container1">

<div class="left">

</div>


<div class="right">

    <h1 class="text-center">Forgotten your Password</h1>
    <p class="text-center">Please enter your details below to send a reset code to your email.</p>

    <div class="d-flex justify-content-center">
        <br>

        <form:form action="/lost-password" modelAttribute="dto" method="POST">
            <div class="label1">
                <span class="input1">Username:</span>
                <form:input class="input2" type="text" id="username" path="username" name="username"/>
            </div>
            <div class=label1>
                <span class="input1">Email:</span>
                <form:input class="input2" type="text" name="email" path="email" id="email"/>
            </div>

            <div class="submit">
                <button class="buttonsubimit" type="submit">Send Reset Code</button>
            </div>
        </form:form>
    </div>
    
  </div>
</div>

</body>
</html>