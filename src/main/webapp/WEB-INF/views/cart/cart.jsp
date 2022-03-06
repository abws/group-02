<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Caveat+Brush&family=Londrina+Solid&display=swap" rel="stylesheet">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <jsp:include page="base.jsp" />
    <title>Cart</title>

</head>
<body>

    <c:forEach items="${cart.items}" var="item">

            <h1> ${item.name} </h1>
            <p> ${item.name} </p>
            <p> ${item.weight} </p>
            <p> ${item.price} </p>
    </c:forEach>

</body>
</html>