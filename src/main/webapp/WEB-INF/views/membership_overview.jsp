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
            <div class="card text-center" style="width: 30rem">
                <img class="card-img-top"
                     src="https://i.pinimg.com/originals/2e/2d/ff/2e2dff03032ba2567b01443713cba402.jpg"
                     width="700px"
                     height="150px">
                <div class="card-body justify-content-center">
                    <h4 class="card-title">Basic Membership</h4>
                    <ul>
                        <li>Access to free recipes</li>
                        <li>Access to discussion board</li>
                        <li>Easy to checkout.</li>
                    </ul>
                    <c:choose>
                        <c:when test="${membership eq 'BASIC'}">
                            <button class="btn btn-primary card-button mx-auto">SELECTED</button>
                        </c:when>
                        <c:when test="${membership eq 'NONE'}">
                            <a class="btn btn-primary card-button mx-auto" href="/login">LOGIN</a>
                        </c:when>
                        <c:when test="${membership ne 'BASIC'}">
                            <form action="/membership/novice" method="post">
                                <button class="btn btn-primary card-button mx-auto">Select Plan</button>
                            </form>
                        </c:when>
                    </c:choose>
                </div>
            </div>
            <div class="card text-center" style="width: 30rem">
                <img class="card-img-top"
                     src="https://media.istockphoto.com/photos/silver-textured-background-picture-id1135421909?b=1&k=20&m=1135421909&s=170667a&w=0&h=uuY6fpQXKVYmrk9zefSe3-PfEvjlSweSQt1AJrV0hEA="
                     width="700px"
                     height="150px">
                <div class="card-body justify-content-center">
                    <h4 class="card-title">Novice Membership</h4>
                    <ul>
                        <li>20% price discount across the store</li>
                        <li>Access to restricted recipes</li>
                        <li>Prioritized support</li>
                    </ul>
                    <c:choose>
                        <c:when test="${membership eq 'NOVICE'}">
                            <button class="btn btn-primary card-button mx-auto">SELECTED</button>
                        </c:when>
                        <c:when test="${membership eq 'NONE'}">
                            <a class="btn btn-primary card-button mx-auto" href="/login">LOGIN</a>
                        </c:when>
                        <c:when test="${membership ne 'NOVICE'}">
                            <form action="/membership/novice" method="post">
                                <button class="btn btn-primary card-button mx-auto">Select Plan</button>
                            </form>
                        </c:when>
                    </c:choose>
                </div>
            </div>
            <div class="card text-center" style="width: 30rem">
                <img class="card-img-top"
                     src="https://media.istockphoto.com/photos/abstract-gold-background-picture-id524653165?b=1&k=20&m=524653165&s=170667a&w=0&h=rlXBabJz89vkGRzVE0HTOXMcdkPoOiNwoPPHXxNhVac="
                     width="700px"
                     height="150px">
                <div class="card-body">
                    <h4 class="card-title">Expert Membership</h4>
                    <ul>
                        <li>Novice Membership Features</li>
                        <li>Access to bulk-quantities</li>
                        <li>Prioritized support</li>
                    </ul>
                    <c:choose>
                        <c:when test="${membership eq 'EXPERT'}">
                            <button class="btn btn-primary card-button mx-auto">SELECTED</button>
                        </c:when>
                        <c:when test="${membership eq 'NONE'}">
                            <a class="btn btn-primary card-button mx-auto" href="/login">LOGIN</a>
                        </c:when>
                        <c:when test="${membership ne 'EXPERT'}">
                            <form action="/membership/expert" method="post">
                                <button class="btn btn-primary card-button mx-auto">Select Plan</button>
                            </form>
                        </c:when>
                    </c:choose>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>