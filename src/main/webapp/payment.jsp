<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Payment</title>

    <!-- Payment CSS -->
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/payment.css">
</head>

<body>

    <div class="payment-box">
        <h2>💳 Payment Method</h2>

        <form action="orderSuccess.jsp">
            <label>
                <input type="radio" name="payment" checked>
                Cash on Delivery
            </label><br>

            <label>
                <input type="radio" name="payment">
                UPI
            </label><br>

            <label>
                <input type="radio" name="payment">
                Card
            </label><br><br>

            <button class="place-btn">Place Order ✔</button>
        </form>
    </div>

</body>
</html>
