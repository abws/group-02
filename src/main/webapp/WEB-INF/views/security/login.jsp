<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="../base.jsp" />
</head>


<style>

body{
	background: url("../../images/back.jpg") no-repeat;
	background-size: cover;
	color: #333;
	font-size: 18px;
	font-family:"Monserrat", sans-serif;
}

.container1{
    width:35%;
  
    background: #ffffffe8;
    padding:20px;
    border-radius:10px;
    margin: 0;
    position: absolute;
    top: 55%;
    left: 50%;
    transform: translate(-50%, -50%);
  
    
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
    width: 30%;
    margin:20px;
    border-radius: 5px;
}

.buttonsubimit:hover{

    background: black;
color:white;
cursor:pointer;
}

.submit{
	width:100%;
	text-align: center;

}

.label2{
	float:right;
}

.error{

	font-size: 16px;
    color: red;
    text-align:center;
}
</style>

<body>

<div class="container1">

    <h1 style="text-align:center;margin-bottom: 0px;">Login</h1>

    <div class="d-flex justify-content-center">
        <c:if test="${param.error != null}">
            <div class="error">
                Your login credentials were incorrect!
            </div>
        </c:if>
    </div>
    <div class="d-flex justify-content-center">
        <br>
        <form action="/login" method="POST">
            <div class="label1">
                <span class="input1">Username:</span>
                <input class="input2" type="text" id="username" name="username"/>
            </div>
            <div class="label1">
                <span class="input1">Password:</span>
                <input class="input2" type="password" name="password" id="password"/>
            </div>
            <div class="label2">
               
                <input class="" type="checkbox" name="remember-me" id="remember-me"/>
                 <span class="">Remember Me</span>
            </div>
            
            <br>

            <div class="submit">
                <button style="text-align:center;"class="buttonsubimit" type="submit">Login</button>
            </div>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            
            
            <p style="font-size:12px;">Dont have an account? <a href="/register">Click here to register!</a></p>
            <p style="font-size:12px;">Forgotten your password? <a href="/lost-password">Reset it here</a></p>
        </form>
    </div>
</div>

</body>
</html>