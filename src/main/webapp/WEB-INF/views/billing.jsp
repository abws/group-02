<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="base.jsp" />
</head>
<body>

<p></p>
<form:form align="center" modelAttribute="billing" action="/billing" method="post">
    <h1>Billing Form</h1>
    <form:label for="firstName" path="firstName">First Name:</form:label>
    <form:input path="firstName"/>
    <form:errors path="firstName"/>
    <br>
    <form:label for="surname" path="surname">Last Name:</form:label>
    <form:input path="surname"/>
    <form:errors path="surname"/>
    <br>
    <form:label for="customerAddress" path="customerAddress">Address:</form:label>
    <form:input path="customerAddress"/>
    <form:errors path="customerAddress"/>
    <br>
    <form:label for="customerEmail" path="customerEmail">Email:</form:label>
    <form:input path="customerEmail"/>
    <form:errors path="customerEmail"/>
    <br>

<p></p>

<h2>Payment Details</h2>
    <form:label for="cardholderName " path="cardholderName"> Card holder name:</form:label>
    <form:input path ="cardholderName"/>
    <form:errors path ="cardholderName"/>
    <br>
    <form:label for="cardNumber" path="cardNumber"> Card Number:</form:label>
    <form:input path ="cardNumber"/>
    <form:errors path ="cardNumber"/>
    <br>
    <form:label for="expiryDate" path="expiryDate"> Expiry Date(mm/yy):</form:label>
    <form:input path = "expiryDate"/>
    <form:errors path = "expiryDate"/>
    <br>
    <form:label for="cvvNumber" path="cvvNumber"> CVV Number:</form:label>
    <form:password path = "cvvNumber"/>
    <form:errors path = "cvvNumber"/>
    <br>

    <input type="submit" value="Order">
</form:form>

</body>
</html>