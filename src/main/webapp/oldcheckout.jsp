<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.app.model.User" %>
<%
if (session.getAttribute("loggedUser") == null) {
    session.setAttribute("redirectAfterLogin", "checkout.jsp");
    response.sendRedirect("login.jsp");
    return;   // 🔥 WITHOUT THIS NOTHING WORKS
}
%>


<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/checkout.css">

<title>Checkout</title>
<style>
.checkout-box {
    width: 420px;
    margin: 100px auto;
    padding: 30px;
    background: white;
    border-radius: 14px;
    box-shadow: 0 20px 60px rgba(0,0,0,0.15);
    animation: zoomIn 0.8s ease;
}

@keyframes zoomIn {
    from { transform: scale(0.8); opacity: 0; }
    to { transform: scale(1); opacity: 1; }
}

.checkout-btn {
    width: 100%;
    background: linear-gradient(45deg, #ff8f00, #ff6f00);
    padding: 14px;
    border: none;
    border-radius: 10px;
    color: white;
    font-size: 16px;
    cursor: pointer;
}

.checkout-btn:hover {
    transform: scale(1.05);
}
</style>

</head>
<body>
<div class="checkout-page">

<div class="container">
<h2>🛒 Checkout</h2>
<p class="subtitle">Almost there! Complete your order 🍽️</p>


<form action="address.jsp" method="get">
    <button class="btn">Continue to Address ➜ 📍 </button>
</form>
</div>
</div>

</body>

</html>
