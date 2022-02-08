<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <!-- bootstrap -->
<style type="text/css">
.nav ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
    overflow: hidden;
    background-color: rgb(207, 112, 24);
  }

  .nav li {
    float: left;
    border-right:1px solid #bbb;
  }

  .nav li:last-child {
    border-right: none;
  }

  .nav li a {
    display: block;
    color: white;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
  }

  .nav li a:hover:not(.active) {
    background-color: rgb(151, 94, 41);
  }

  .nav .active {
    background-color: #aa551d;
  }


</style>

</head>
<body>
	<div class ="nav">
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