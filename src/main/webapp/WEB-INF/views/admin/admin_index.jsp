<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>SpicesRUS - ADMIN</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
</head>

<style>
    body {
        background-color: #ced5ce
    }

</style>
<body>

<nav class="navbar navbar-light" style="background-color: rgba(120,198,255,0.45)">
    <ul class="nav nav-pills">
            <a class="nav-link nav-link-active">Dashboard</a>
        <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" data-toggle="dropdown" aria-haspopup="tree" aria-expanded="false">Manage</a>
            <div class="dropdown-menu">
                <a class="dropdown-item" href="/admin/manage/users">Manage Users</a>
                <a class="dropdown-item" href="/admin/manage/spices">Manage Spices</a>
                <a class="dropdown-item" href="/admin/manage/recipes">Manage Recipes</a>
            </div>
        </li>
    </ul>
    <ul class="nav nav-pills navbar-right">
        <a class="btn btn=danger nav-link" href="/">Exit Admin Panel</a>
    </ul>
</nav>

<h2 class="text-center">Admin - Dashboard</h2>

<div class="card-group">
    <div class="container-fluid ">
        <div class="row">
            <div class="col-4">
                <div class="card h-100">
                    <h5 class="card-header text-center">Spices</h5>
                    <div class="card-body">
                        <h5>Site Information:</h5>
                        <p>Total Spices: ${total_spices}</p>
                    </div>
                    <a href="/admin/manage/spices" class="btn btn-primary text-center">Manage Spices</a>
                </div>
            </div>
            <div class="col-4">
                <div class="card h-100">
                    <h5 class="card-header text-center">Users</h5>
                    <div class="card-body">
                        <h5>Site Information:</h5>
                        <p>Registered Users: ${registered}</p>
                        <p>Novice Users: ${novice_users}</p>
                        <p>Expert Users: ${expert_users}</p>
                    </div>
                    <a href="/admin/manage/users" class="btn btn-primary text-center">Manage Users</a>
                </div>
            </div>
            <div class="col-4">
                <div class="card h-100">
                    <h5 class="card-header text-center">Recipes</h5>
                    <div class="card-body">
                        <h5>Site Information:</h5>
                        <p>Total Recipes: ${total_recipes}</p>
                        <p>Total Restricted: ${total_restricted_recipes}</p>
                    </div>
                    <a href="/admin/manage/recipes" class="btn btn-primary text-center">Manage Recipes</a>
                </div>
            </div>
        </div>
    </div>
</div>
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