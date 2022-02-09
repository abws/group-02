<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="<c:url value='css/base.css'/>">
</head>
<body>

<h1>Billing Form</h1>

<form:form modelAttribute="billing" action="/billing" method="post">
    <form:label for="firstName" path="firstName">First Name:</form:label>
    <form:input path="firstName"/>
    <form:errors path="firstName"/>
    <br>
    <form:label for="surname" path="surname">Last Name:</form:label>
    <form:input path="surname"/>
    <form:errors path="surname"/>
    <br>
    <form:label for="customerAddress" path="customerAddress">Address:</form:label>
    <form:password path="customerAddress"/>
    <form:errors path="customerAddress"/>
    <br>
    <form:label for="customerEmail" path="customerEmail">Email:</form:label>
    <form:input path="customerEmail"/>
    <form:errors path="customerEmail"/>
    <br>

    <input type="submit" value="Order">
</form:form>
</body>
</html>