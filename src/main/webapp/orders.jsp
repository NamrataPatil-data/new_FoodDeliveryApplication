<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.app.model.Order" %>

<!DOCTYPE html>
<html>
<head>
    <title>Your Orders</title>

    <!-- CSS link (IMPORTANT) -->
    <link rel="stylesheet" href="css/orders.css">
</head>
<body>

<h1 class="orders-title">Your Orders 📦</h1>

<div class="orders-container">

<%
    List<Order> orders = (List<Order>) request.getAttribute("orders");

    if (orders == null || orders.isEmpty()) {
%>

    <div class="no-orders">
        <h3>No orders yet</h3>
        <p>Looks like you haven’t placed any orders.</p>
    </div>

<%
    } else {
        for (Order order : orders) {
%>

    <div class="order-card">

        <div class="order-header">
            <div class="order-id">
                Order #<%= order.getOrderId() %>
            </div>
            <div class="order-date">
                <%= order.getOrderDate() %>
            </div>
        </div>

        <div class="order-details">
            <div class="order-detail">
                Total Amount: <span>₹ <%= order.getTotalAmount() %></span>
            </div>

            <div class="order-detail">
                Payment: <span><%= order.getPaymentMode() %></span>
            </div>

            <div class="order-detail">
                <span class="order-status"><%= order.getStatus() %></span>
            </div>
        </div>

    </div>

<%
        }
    }
%>

</div>

</body>
</html>
