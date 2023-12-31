<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>SpicesRUS - ADMIN</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <script src="https://kit.fontawesome.com/2f306254e3.js" crossorigin="anonymous"></script>

    <style>
        body {
            background-color: #ced5ce
        }

    </style>
</head>


<body>

<nav class="navbar navbar-light" style="background-color: rgba(120,198,255,0.45)">
    <ul class="nav nav-pills">
        <a class="nav-link nav-link" href="/admin">Dashboard</a>
        <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" data-toggle="dropdown" aria-haspopup="tree"
               aria-expanded="false">Manage</a>
            <div class="dropdown-menu">
                <a class="dropdown-item" href="/admin/manage/users">Manage Users</a>
                <a class="dropdown-item" href="#">Manage Spices</a>
                <a class="dropdown-item" href="/admin/manage/recipes">Manage Recipes</a>
            </div>
        </li>
    </ul>
    <ul class="nav nav-pills navbar-right">
        <a class="btn btn=danger nav-link" href="/">Exit Admin Panel</a>
    </ul>
</nav>
<div class="container-fluid">
    <div class="card bg-dark text-white">
        <img class="card-img" src="../../images/spice_hero.png" alt="Card image" height="105" width="360">
        <div class="card-img-overlay text-white d-flex flex-column justify-content-center">
            <form class="mx-auto" method="get">
                <input class="mx-auto" type="text" id="query" name="query" placeholder="Search spices...">
                <button class="btn btn-primary">Search</button>
            </form>
        </div>
    </div>
</div>

<c:choose>
    <c:when test="${searched}">
        <h2 class="text-center">Spice - ${spiceDTO.getName()}</h2>
        <div class="content col-sm-4 mx-auto">
            <form:form class="text-center" modelAttribute="spiceDTO" action="spices/edit" method="post">

                <div class="form-group row">
                    <label class="col-sm-3" for="name">Name:</label>
                    <div class="col-sm-9">
                        <form:input class="form-control col-sm-9" type="text" id="name" path="name"/>
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-3" for="category">Category:</label>
                    <div class="col-sm-9">
                        <form:input class="form-control col-sm-9" type="text" id="category" path="category"/>
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-3" for="description">Description:</label>
                    <div class="col-sm-9">
                        <form:input class="form-control col-sm-9" type="text" id="description" path="description"/>
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-3" for="price">Price:</label>
                    <div class="col-sm-9">
                        <form:input class="form-control col-sm-9" type="text" id="price" path="price"/>
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-3" for="picture">Picture:</label>
                    <div class="col-sm-9">
                        <form:input class="form-control col-sm-9" type="text" id="picture" path="picture"/>
                    </div>
                </div>

                <div class="form-group row">
                    <label class="col-sm-3" for="spiceRoles">Complimentary Spices:</label>
                    <div class="col-sm-9">
                        <form:select class="form-control col-sm-9" path="complimentarySpices" items="${allSpices}"
                                     multiple="true" id="spiceRoles">
                            <c:forEach var="spice" items="compSpice">
                                <form:option value="${spice}" selected="true"></form:option>
                            </c:forEach>
                        </form:select>
                    </div>
                </div>


                <button class="btn btn-primary">Edit Spice</button>

            </form:form>
        </div>
    </c:when>
    <c:when test="${not searched}">
        <h2 class="text-center">Spices - New Spice</h2>
        <div class="content col-sm-4 mx-auto">
            <form:form class="text-center" modelAttribute="spiceDTO" action="spices/create" method="post">

                <div class="form-group row">
                    <label class="col-sm-3" for="name">Name:</label>
                    <div class="col-sm-9">
                        <form:input class="form-control col-sm-9" type="text" id="name" path="name"/>
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-3" for="category">Category:</label>
                    <div class="col-sm-9">
                        <form:input class="form-control col-sm-9" type="text" id="category" path="category"/>
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-3" for="description">Description:</label>
                    <div class="col-sm-9">
                        <form:input class="form-control col-sm-9" type="text" id="description" path="description"/>
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-3" for="price">Price:</label>
                    <div class="col-sm-9">
                        <form:input class="form-control col-sm-9" type="text" id="price" path="price"/>
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-3" for="picture">Picture:</label>
                    <div class="col-sm-9">
                        <form:input class="form-control col-sm-9" type="text" id="picture" path="picture"/>
                    </div>
                </div>

                <div class="form-group row">
                    <label class="col-sm-3" for="spiceRoles">Complimentary Spices:</label>
                    <div class="col-sm-9">
                        <form:select class="form-control col-sm-9" path="complimentarySpices" items="${allSpices}"
                                     multiple="true" id="spiceRoles">
                        </form:select>
                    </div>
                </div>

                <button class="btn btn-primary">Create Spice</button>

            </form:form>
        </div>
    </c:when>
</c:choose>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
</body>
</html>
</title>
</head>
<body>

</body>
</html>