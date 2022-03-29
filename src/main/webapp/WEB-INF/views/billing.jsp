<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="base.jsp" />
</head>

<style>

.hero-nav {
   		 background-color: rgb(255, 136, 0);
   		 
   		}
      
      .navigation ul {
	    list-style-type: none;
	    margin: 0;
	    padding: 0;
	    overflow: hidden;
	    font-size: 18px;
	    font-family:"Monserrat", sans-serif;
	    font-weight: 900;
	    background-color: rgb(255, 136, 0);
	    
	  }
body{
	
	color: #333;
	
	font-family:"Monserrat", sans-serif;
}


.container1{    
    display: flex;
    width:1600px;
    padding:20px;
    border-radius:10px;
    margin: 0;
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
  
   
}

.left{
    width: 50%;
    border-radius: 10px;
    background-size: cover;
    height: 500px;
 
  
}

.right{
    margin-top: 8%;
    width: 50%;
    background: #ffffffe8;
    padding: 20px;
    border-radius: 10px;
 
}






input[type=text] {
  width: 100%;
  margin-bottom: 20px;
  padding: 12px;
  border: 1px solid #ccc;
  border-radius: 3px;
}



.btn {
  background-color: rgb(255 136 0);
  color: white;
  padding: 12px;
  margin: 10px 0;
  border: none;
  width: 60%;
  border-radius: 5px;
  cursor: pointer;
  font-size: 17px;
}

.btn:hover {
   background:black;
    border:black;
	color:white;
	cursor:pointer;}


.container1:after{

display: table;
  clear: both;
}

.left {
  float: left;
  width: 50%;
  padding: 10px;
}

</style>

<body>



<div class="container1">

<img src="../../images/checkout.webp" style="margin-top: 10%;" width="600" height="400">
<form:form align="center" class="right" modelAttribute="billing" action="/billing" method="post">

<div class="left">

           <h3>Billing Form</h3>
           
            
            <form:label for="firstName" path="firstName">First Name:</form:label>
    		<form:input id="fname" path="firstName"/>
    		 <form:errors path="firstName"/>
    		
    
			    <form:label for="surname" path="surname">Last Name:</form:label>
			    <form:input id="lname" path="surname"/>
			    <form:errors path="surname"/>
			   
            
             <form:label for="customerEmail" path="customerEmail">Email:</form:label>
   			 <form:input path="customerEmail" id="email" placeholder="john@example.com"/>
   			     <form:errors path="customerEmail"/>
 
   			 
            
            <form:label for="customerAddress" path="customerAddress"> Address:</form:label>
    		<form:input id="adr" path="customerAddress"/>
    		<form:errors path="customerAddress"/>
            
            <form:label for="customerPostcode" path="customerPostcode">Postcode:</form:label>
   			 <form:input id="city" path="customerAddress"/>
              <form:errors path="customerAddress"/>
</div>             

    
 <div class="left">    
       
            <h3>Payment Details</h3>
           
            
             <form:label for="cardholderName " path="cardholderName"> Card holder name:</form:label>
   			 <form:input id="cname" path ="cardholderName"/>
            <form:errors path ="cardholderName"/>
            
            <form:label for="cardNumber" path="cardNumber"> Card Number:</form:label>
		    <form:input id="ccnum" placeholder="1111-2222-3333-4444" path ="cardNumber"/>
		    <form:errors path ="cardNumber"/>
            
                <form:label  for="expiryDate" path="expiryDate"> Expiry Date:</form:label>
   				 <form:input placeholder="mm/yy" path = "expiryDate"/>
    			<form:errors path = "expiryDate"/>
    			
   
              <div class="col-50">
              
                 <form:label for="cvvNumber" path="cvvNumber"> CVV Number:</form:label>
                <form:input id="cvv"  placeholder="352" path = "cvvNumber"/>
                <form:errors path = "cvvNumber"/>
                
              </div>
                      <input type="submit" value="Order" class="btn">
              
        
 </div>        
         
       
       
        
    	
    	</form:form>
 </div>



</body>
</html>






