<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Detail</title>
<jsp:include page="base.jsp" />
<style>
.center {
  position: absolute;
  margin: auto;
  width: 30%;
  border: 2px solid #73AD21;
  padding: 10px;
  top: 20%;
  left: 35%;
}

.title{
	text-align:center;
}
</style>

</head>
<body>

	

<head>
<title>User Detail</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
* {
  box-sizing: border-box;
}

body {
  margin: 0;
  font-family: Arial, Helvetica, sans-serif;
}

/* Style the side navigation */
.sidenav {
  height: 100%;
  width: 200px;
  position: fixed;
  z-index: 1;
  top: 52px;
  left: 0;
  background-color: #FB9350;
  overflow-x: hidden;
}


/* Side navigation links */
.sidenav a {
  color: white;
  padding: 16px;
  text-decoration: none;
  display: block;
}

/* Change color on hover */
.sidenav a:hover {
  background-color: #F28123;
  color: white;
}

/* Style the content */
.content {
  margin-left: 200px;
  padding-left: 20px;

}
</style>
</head>
<body>

<div class="sidenav">
  <a href="#">My Details</a>
  <a href="#">My Address</a>
  <a href="#">My Preference</a>
</div>

<div class="content">
  <h2>>User Profile Detail</h2>
  
		<label>Username:</label><label> ${user.username}</label>
	
	    <br> <br/>
		<label>Email:</label>

	    <input type="text" value= ${user.email} name="email">
	    	
	    <br> <br/>
	    <label>First Name:</label>
	    
	    

	    <input type="text" value= ${user.firstName} name="fname">
	    
	     <br> <br/>
	    <label>Last Name:</label>

	  <input type="text" name="lastname" value=${user.lastName}>
	    <br> <br/>
	    <label class="labels">Change Password:</label>
 		<input type="text" id="password" name="password"> <br><br>  
 		
 	
 		<input type="submit" value="Save" style="text-align:center"> 

  
</div>









</body>
</html>

	

</body>
</html>