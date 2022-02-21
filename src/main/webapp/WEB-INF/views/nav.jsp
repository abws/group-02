<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <!-- bootstrap -->
<style type="text/css">
.navigation ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
    overflow: hidden;
    background-color: #fe7b00;
  }

  .navigation li {
    float: left;
    border-right:1px solid #bbb;
  }

  .navigation li:last-child {
    border-right: none;
  }

  .navigation li a {
    display: block;
    color: white;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
  }

  .navigation li a:hover{
    background-color: #dc6a00;
  }

  .navigation .active {
    background-color: #ed7200;
  }


</style>
</head>
<body>
	<div class ="navigation">
		<ul>
		  <li><a href="/">Home</a></li>
		  <li><a href="#news">News</a></li>
		  <li><a href="/spices">Shop</a></li>
		  <li><a href="/login">Contact</a></li>

		  <li style="float:right"><a class="active" href="#basket">Basket</a></li>
		  <li style="float:right"><a class="active" href="/login">Login</a></li>
		</ul>
	</div>
</body>
</html>