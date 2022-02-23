<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Caveat+Brush&family=Londrina+Solid&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="<c:url value='css/index/index.css'/>">
    <style>
        .card {
            box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
            max-width: 360px;
            margin-top: 50px;
            margin-left: 70px;
            margin-right: 40px;
            margin-bottom: auto;
            text-align: center;
            font-family: arial;
            flex: 35%;
            padding: 20px;

        }

        .card button {
            border: none;
            outline: 0;
            padding: 12px;
            color: white;
            background-color: rgb(252, 168, 90);
            text-align: center;
            cursor: pointer;
            width: 100%;
            font-size: 18px;
        }

        .card button:hover {
            opacity: 9.0;
        }

        * {
            box-sizing: border-box;
        }

        .row {
            display: flex;
        }


    </style>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <jsp:include page="base.jsp" />
    <title>Recipes</title>

</head>
<body>
<h2>Categories</h2>

<div class="vertical-menu">
    <a href="/recipes" class="active">All</a>
    <a href="/recipes/Breakfast">Breakfast</a>
    <a href="/recipes/Lunch">Lunch</a>
    <a href="/recipes/Soups">Soups</a>
    <a href="/recipes/Salads">Salads</a>
    <a href="/recipes/Mains">Main Dishes</a>
    <a href="/recipes/Dinner">Dinner</a>
    <a href="/recipes/Dinner">Vegetarian</a>
    <a href="/recipes/Dinner">Vegan</a>
    <a href="/recipes/Dinner">Cakes and Pies</a>
    <a href="/recipes/Dinner">Pastries</a>
</div>


<div class="sort">
    <a href="/recipes/a-z" class="active">A-Z</a>
    <a href="/recipes/z-a">Z-A</a>
</div>

<label for="sorting">Sort By:</label>
<select name="sort" id="sort" onchange="location.reload()">
    <option value="a-z">A-Z</option>
    <option value="z-a">Z-A</option>
</select>


<div class="row">
    <c:forEach items="${recipes}" var="recipe">
        <div class="card">
            <img src="${recipe.getPicture()}" alt="${recipe.getName()}" width="500" height="300" style="width:100%">
            <h1> ${recipe.getName()}</h1>
            <p> Category: ${recipe.getCategory()}</p>
            <p>${recipe.description}</p>
            <p>
                <button>30-45mins</button>
            </p>
        </div>
    </c:forEach>
</div>

</body>
</html>