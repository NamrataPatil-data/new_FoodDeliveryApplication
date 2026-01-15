<%
    String orderId = "FD" + System.currentTimeMillis();
%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Order Success</title>

    <!-- Success Page CSS -->
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/orderSuccess.css">
    <script src="https://cdn.jsdelivr.net/npm/canvas-confetti@1.6.0/dist/confetti.browser.min.js"></script>
    
</head>

<body>

    <div class="success-box">
        <h1>🎉 Order Placed Successfully!</h1>
        <p><strong>Order ID:</strong> <%= orderId %></p>
        

        <p>Your food is on the way 🍽️<br>
           Sit back and relax!</p>
           <p id="deliveryTimer" style="font-weight: bold; margin-top: 10px;">
    ⏱️ Estimated delivery in 30:00
</p>
           

        <a href="HomeServlet" class="home-btn">Back to Home 🏠</a>
    </div>
    <script>
    window.onload = function () {
        confetti({
            particleCount: 160,
            spread: 90,
            origin: { y: 0.6 }
        });
    };
</script>
    

</body>
</html>
