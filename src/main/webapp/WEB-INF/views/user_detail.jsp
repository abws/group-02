<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>User Detail</title>
    <jsp:include page="base.jsp"/>


  
<script>
    function toggle() {
        x = document.getElementById("password1").type === "password";
        if (x) {
            document.getElementById("password1").type = "text";
            document.getElementById("password2").type = "text";
            document.getElementById("password1button").innerHTML = "<i class='fa-solid fa-eye-slash'></i>";
            document.getElementById("password2button").innerHTML = "<i class='fa-solid fa-eye-slash'></i>";
            
       
        } else {
            document.getElementById("password1").type = "password";
            document.getElementById("password2").type = "password";
            document.getElementById("password1button").innerHTML = "<i class='fa-solid fa-eye'></i>";
            document.getElementById("password2button").innerHTML = "<i class='fa-solid fa-eye'></i>";
        }
    }
</script>



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
        * {
            box-sizing: border-box;
        }

        html, body {
        height: 100%;
        width: 100%;
        margin: 0;
        font-family: "Monserrat", sans-serif;
      }

  
        
    .container1{
 	width: 80%;
   
    border-radius: 10px;
    margin-top: 5%;
    position: absolute;
    top: 55%;
    left: 50%;
    transform: translate(-50%, -50%);
    display: flex;
    
}

.left{
    width: 60%;
    background: url("../../images/userdetails2.webp") no-repeat;
    padding: 20px;
    border-radius: 10px;
    background-size: cover;
    height: 500px;

 
  
}

.right{

    width: 40%;
    background: #ffffffe8;
    padding: 20px;
    border-radius: 10px;

  
}

.error{

	font-size: 16px;
    color: red;
}

.registerform{

	height:auto;

}


.input1{
     display: block;
    font-size: 0.5em;
    font-weight: 600;
    padding-left: 0.5em;
    text-transform: uppercase;
    -webkit-transition: all 0.25s;
    transition: all 0.25s;
    width:50%;
    
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
    display:flex;
    
}

.input3{
    background: none;
    border: none;
    line-height: 1em;
    font-weight: 300;
    padding: 0.125em 0.25em;
    width: 80%;

}

.buttonsubimit{
    
    border: 1px solid #333;
    line-height: 1em;
    padding: 0.5em 0.5em;
    -webkit-transition: all 0.25s;
    transition: all 0.25s;
    margin-top:10px;
    font-size: 20px;
    border-radius: 5px;
}

.buttonsubimit:hover{

    background: black;
    color:white;
    cursor:pointer;
}

.button{


    border: none;
    font-size: 16px;
    float: right;
    background: transparent;
  
}

.button:hover{
	cursor:pointer;
}


.submit{
	width:100%;
	text-align: center;
}


.sidebar {
margin-top: 6%;
    overflow: hidden;
    background-color: white;
    text-align: center;
    margin-left: 18%;
}



.sidebar a {
  float: left;
  color: black;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  font-size: 17px;
  border-bottom:1px solid black;

}

.sidebar a:hover {
  color: white;
  background:black;
  cursor:pointer;
}

    </style>
</head>
<body>

   
<div class="container1">



<div class="left">



</div>

<div class="right">

    <h1 style="text-align:center;margin-bottom: 0px;">User Profile Details</h1>

    <div class="d-flex justify-content-center">
        <br>
        <sec:authorize access="isAuthenticated()">


            <form:form modelAttribute="user" action="/user" method="post">

                <div class="label1">
                    <p class="input1">Username:</p>
                    <form:input cssClass="input2" readonly="true" path="username"/>
                        <%-- <form:errors cssClass="error" path="username"/><br>--%>
                </div>
                <div class="label1">
                     <form:errors cssClass="error" path="email"/>
                    <p class="input1">Email:</p>
                    <form:input cssClass="input2" path="email"/>
               
                </div>
                <div class="label1">
                 <form:errors cssClass="error" path="firstName"/>
                    <p class="input1">First Name:</p>
                    <form:input cssClass="input2" path="firstName"/>
                   
                </div>
                <div class="label1">
                  <form:errors cssClass="error" path="lastName"/>
                    <p class="input1">Last Name:</p>
                    <form:input cssClass="input2" path="lastName"/>
                  
                </div>

                <div class="label1">
                    <form:errors cssClass="error" path="password"/>
                    <p class="input1">Password:</p>
                    <form:password cssClass="input3" id="password1" path="password" placeholder="****"/>
                   
                    <button class="button" type="button" id="password1button"
                            onclick="toggle()"><i class="fa-solid fa-eye"></i>
                    </button>
                </div>
                <div class="label1">
                 <form:errors cssClass="error" path="confirmedPassword"/>
                    <p class="input1">Confirm Password:</p>
                    <form:password cssClass="input3" id="password2" path="confirmedPassword" placeholder="****"/>
                   
                    <button class="button" type="button" id="password2button"
                            onclick="toggle()"><i class="fa-solid fa-eye"></i>
                    </button>
                </div>
                <div class="label1">
                    <p class="input1">User Roles:</p>
                    <input class="input2" readonly value="${membership}">
                </div>

  				<div class="submit">
                <input style="text-align:center;"class="buttonsubimit" type="submit" value="Change Details">
            </div>
                
            </form:form>
        </sec:authorize>

    </div>
    </div>
  </div>
</body>

</html>
