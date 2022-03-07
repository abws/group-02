<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Caveat+Brush&family=Londrina+Solid&display=swap"
          rel="stylesheet">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <jsp:include page="base.jsp"/>
    <title>Recipes</title>

</head>
<body>
<h1 class="text-center" style="margin-top: 5%;">Membership Plans</h1>

<div class="container" style="height: 75%">

    <div class="row">
        <div class="card-deck">
            <div class="card text-center">
                <img class="card-img-top"
                     src="https://www.clipartmax.com/png/middle/238-2388790_food-and-drinks-level-1-png.png"
                     width="500px"
                     height="300px">
                <div class="card-body justify-content-center">
                    <h4 class="card-title">Basic Membership</h4>
                    <p class="card-text">Basic members get features ....</p>
                    <form action="/membership/basic" method="post">
                        <button class="btn btn-primary card-button mx-auto">Select Plan</button>
                    </form>
                </div>
            </div>
            <div class="card text-center">
                <img class="card-img-top"
                     src="https://www.clipartmax.com/png/middle/238-2388790_food-and-drinks-level-1-png.png"
                     width="500px"
                     height="300px">
                <div class="card-body justify-content-center">
                    <h4 class="card-title">Novice Membership</h4>
                    <p class="card-text">Novice members get features .....</p>
                    <form action="/membership/novice" method="post">
                        <button class="btn btn-primary card-button mx-auto">Select Plan</button>
                    </form>
                </div>
            </div>
            <div class="card text-center">
                <img class="card-img-top"
                     src="https://www.clipartmax.com/png/middle/238-2388790_food-and-drinks-level-1-png.png"
                     width="500px"
                     height="300px">
                <div class="card-body">
                    <h4 class="card-title">Expert Membership</h4>
                    <p class="card-text">Expert members get features .......</p>
                    <form action="/membership/expert" method="post">
                        <button class="btn btn-primary card-button mx-auto">Select Plan</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>


<%--<div class="row">--%>
<%--    <div class="card">--%>
<%--        <img src="https://www.clipartmax.com/png/middle/238-2388790_food-and-drinks-level-1-png.png" alt="Basic" width="500" height="300" style="width:100%">--%>
<%--        <h3>Basic Membership</h3>--%>
<%--        <p>Price: £0/mo</p>--%>
<%--        <p>--%>
<%--            <button>Select Tier</button>--%>
<%--        </p>--%>
<%--    </div>--%>
<%--    <div class="card">--%>
<%--        <img src="https://www.clipartmax.com/png/middle/238-2388790_food-and-drinks-level-1-png.png" alt="Basic" width="500" height="300" style="width:100%">--%>
<%--        <h3>Novice Membership</h3>--%>
<%--        <p>Price: £5/mo</p>--%>
<%--        <p>--%>
<%--            <button>Select Tier</button>--%>
<%--        </p>--%>
<%--    </div>--%>
<%--    <div class="card">--%>
<%--        <img src="https://www.clipartmax.com/png/middle/238-2388790_food-and-drinks-level-1-png.png" alt="Basic" width="500" height="300" style="width:100%">--%>
<%--        <h3>Expert Membership</h3>--%>
<%--        <p>Price: £10/mo</p>--%>
<%--        <p>--%>
<%--            <button>Select Tier</button>--%>
<%--        </p>--%>
<%--    </div>--%>
<%--</div>--%>

</body>
</html>