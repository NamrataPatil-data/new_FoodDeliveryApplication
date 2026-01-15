<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/address.css">

<title>Delivery Address</title>
<style>
.address-box {
    width: 450px;
    margin: 100px auto;
    padding: 30px;
    background: white;
    border-radius: 14px;
    box-shadow: 0 25px 70px rgba(0,0,0,0.2);
    animation: slideUp 0.8s ease;
}

@keyframes slideUp {
    from { transform: translateY(40px); opacity: 0; }
    to { transform: translateY(0); opacity: 1; }
}

.address-box input,
.address-box textarea {
    width: 100%;
    padding: 10px;
    margin-top: 10px;
    border-radius: 8px;
    border: 1px solid #ccc;
}

.address-box button {
    width: 100%;
    background: #ff6f00;
    color: white;
    padding: 14px;
    margin-top: 20px;
    border: none;
    border-radius: 10px;
    cursor: pointer;
}

.address-box button:hover {
    transform: scale(1.05);
}
</style>

</head>
<body>

<div class="address-page">
    <div class="address-box">

        <h2>📍 Delivery Address</h2>

        <form action="payment.jsp" method="post">
            <!-- KEEP ALL YOUR INPUTS AS IT IS -->

<input type="text" placeholder="Full Name" required>
<input type="text" placeholder="Mobile Number" required>
<textarea placeholder="Address" required></textarea>

<button class="btn">Proceed to Payment 💰</button>
</form>
</div>
</div>
</body>
</html>
