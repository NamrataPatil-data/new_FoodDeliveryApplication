<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.app.model.Cart" %>
<%@ page import="com.app.model.CartItem" %>
<%@ include file="header.jsp" %>

<%
Cart cart = (Cart) session.getAttribute("cart");
if(cart == null){
    out.println("<h2 style='text-align:center'>Your cart is empty 🛒</h2>");
    return;
}
%>



<style>
body {
    margin: 0;
    padding: 0;
    min-height: 100vh;
    font-family: Arial, sans-serif;

    background: url("../images/cart-bg.jpg") no-repeat center center fixed;
    background-size: cover;
}


.cart-box {
    width: 420px;
    margin: 100px auto;
    padding: 30px;

    background: #f5efe6; /* beige */
    border-radius: 16px;

    box-shadow: 0 25px 60px rgba(0, 0, 0, 0.25);
    animation: floatCard 3s ease-in-out infinite;
}


@keyframes floatCard {
    0% { transform: translateY(0); }
    50% { transform: translateY(-10px); }
    100% { transform: translateY(0); }
}

.cart-box h2 {
    text-align: center;
    margin-bottom: 20px;
}

.qty a {
    padding: 6px 12px;
    background: #ff6f00;
    color: white;
    border-radius: 6px;
    text-decoration: none;
    font-weight: bold;
    transition: transform 0.2s;
}

.qty a:hover {
    transform: scale(1.2);
}

.checkout {
    margin-top: 20px;
    width: 100%;
    background: linear-gradient(45deg, #2e7d32, #66bb6a);
    color: white;
    padding: 14px;
    border-radius: 10px;
    border: none;
    font-size: 16px;
    cursor: pointer;
    animation: pulse 1.5s infinite;
}

@keyframes pulse {
    0% { box-shadow: 0 0 0 0 rgba(102,187,106,0.6); }
    70% { box-shadow: 0 0 0 15px rgba(102,187,106,0); }
    100% { box-shadow: 0 0 0 0 rgba(102,187,106,0); }
}
</style>


<div class="cart-box">
<h2>Your Cart 🛒</h2>

<%
for(CartItem item : cart.getItems()){
%>
<p>
<b><%= item.getMenu().getItemName() %></b> – ₹ <%= item.getMenu().getPrice() %>
</p>

<div class="qty">
<a href="cart?action=minus&menuId=<%= item.getMenu().getMenuId() %>">−</a>
<b><%= item.getQuantity() %></b>
<a href="cart?action=plus&menuId=<%= item.getMenu().getMenuId() %>">+</a>
</div>
<hr>
<% } %>

<h3>Total: ₹ <%= cart.getTotalPrice() %></h3>

<form action="checkout" method="get">
<button class="checkout-btn">Proceed to Checkout 🚀</button>
</form>
</div>
