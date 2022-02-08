<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
</head>
<body>

<h1>Order Complete</h1>

<p>You have successfully completed your order.</p>
<p> Order detail: </p>
<p>Order number: "${BillingDetails.ordernum}"</p>
<p>First Name : "${BillingDetails.firstName}"</p>
<p>Last Name : "${BillingDetails.surname}"</p>
<p>Address : "${BillingDetails.CustomerAddress}"</p>
<p>Email : "${BillingDetails.CustomerEmail}"</p>
<p>Spice : "${Orders.spiceId}"</p>
<p>Total : "${Orders.orderTotal}"</p>
</form>
</body>
</html>