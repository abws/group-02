<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                <a class="dropdown-item" href="#">Manage Users</a>
                <a class="dropdown-item" href="/admin/manage/spices">Manage Spices</a>
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
                <input class="mx-auto" type="text" id="query" name="query" placeholder="Search user...">
                <button class="btn btn-primary">Search</button>
            </form>
        </div>
    </div>
</div>

<c:choose>
    <c:when test="${searched}">
        <h2 class="text-center">Users - ${userDTO.getUsername()}</h2>
        <div class="content col-sm-4 mx-auto">
            <form:form class="text-center" modelAttribute="userDTO" action="edit" method="post">

                <div class="form-group row">
                    <label class="col-sm-3" for="username">Username:</label>
                    <div class="col-sm-9">
                        <form:input class="form-control col-sm-9" type="text" id="username" path="username"/>
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-3" for="email">Email:</label>
                    <div class="col-sm-9">
                        <form:input class="form-control col-sm-9" type="text" id="email" path="email"/>
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-3" for="password">Password:</label>
                    <div class="col-sm-9">
                        <form:input class="form-control col-sm-9" type="text" id="password" path="password"/>
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-3" for="firstName">First Name:</label>
                    <div class="col-sm-9">
                        <form:input class="form-control col-sm-9" type="text" id="firstName" path="firstName"/>
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-3" for="lastName">Last Name:</label>
                    <div class="col-sm-9">
                        <form:input class="form-control col-sm-9" type="text" id="lastName" path="lastName"/>
                    </div>
                </div>

                <div class="form-group row">
                    <label class="col-sm-3" for="spiceRoles">Role:</label>
                    <div class="col-sm-9">
                        <form:select class="form-control col-sm-9" path="authorities" items="${roles}" multiple="false"
                                     id="spiceRoles">
                            <c:if test="${searched}">
                                <form:option value="${userRole}">${userRole}</form:option>
                            </c:if>
                        </form:select>
                    </div>
                </div>


                <button class="btn btn-primary">Edit User</button>

            </form:form>
        </div>
    </c:when>
    <c:when test="${not searched}">
        <h2 class="text-center">Users - New User</h2>
        <div class="content col-sm-4 mx-auto">
            <form:form class="text-center" modelAttribute="userDTO" action="users/create" method="post">

                <div class="form-group row">
                    <label class="col-sm-3" for="username">Username:</label>
                    <div class="col-sm-9">
                        <form:input class="form-control col-sm-9" type="text" id="username" path="username"/>
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-3" for="email">Email:</label>
                    <div class="col-sm-9">
                        <form:input class="form-control col-sm-9" type="text" id="email" path="email"/>
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-3" for="password">Password:</label>
                    <div class="col-sm-9">
                        <form:input class="form-control col-sm-9" type="text" id="password" path="password"/>
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-3" for="firstName">First Name:</label>
                    <div class="col-sm-9">
                        <form:input class="form-control col-sm-9" type="text" id="firstName" path="firstName"/>
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-3" for="lastName">Last Name:</label>
                    <div class="col-sm-9">
                        <form:input class="form-control col-sm-9" type="text" id="lastName" path="lastName"/>
                    </div>
                </div>

                <div class="form-group row">
                    <label class="col-sm-3" for="spiceRoles">Role:</label>
                    <div class="col-sm-9">
                        <form:select class="form-control col-sm-9" path="authorities" items="${roles}" multiple="false"
                                     id="spiceRoles">
                            <c:if test="${searched}">
                                <form:option value="${userRole}">${userRole}</form:option>
                            </c:if>
                        </form:select>
                    </div>
                </div>


                <button class="btn btn-primary">Create User</button>

            </form:form>
        </div>
    </c:when>
</c:choose>


<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
        crossorigin="anonymous"></script>
</body>
</html>