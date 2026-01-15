<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Checkout</title>
    <link rel="stylesheet" href="css/checkout.css">
</head>
<body>

<div class="checkout-wrapper">

    <form action="placeOrder" method="post" class="checkout-card">

        <h2 class="checkout-title">Checkout</h2>

        <!-- TWO BOX CONTAINER -->
        <div class="checkout-grid">

            <!-- LEFT: DELIVERY ADDRESS -->
            <div class="box">
                <h3>📍 Delivery Address</h3>

                <label>Full Name</label>
                <input type="text" name="fullname" required>

                <label>Mobile Number</label>
                <input type="text" name="mobile" required>

                <label>Alternate Mobile Number</label>
                <input type="text" name="altMobile">

                <label>Delivery Address</label>
                <textarea name="address" required></textarea>

                <label>Pincode</label>
                <input type="text" name="pincode" required>
            </div>

            <!-- RIGHT: PAYMENT METHOD -->
            <div class="box">
    <h3>💳 Payment Method</h3>

    <!-- UPI -->
    <div class="payment-row">
        <input type="radio" name="paymentMode" value="UPI" id="upi">
        <label for="upi">UPI</label>

        <select name="upiType">
            <option value="">Select App</option>
            <option value="Google Pay">Google Pay</option>
            <option value="PhonePe">PhonePe</option>
            <option value="Paytm">Paytm</option>
        </select>
    </div>

    <!-- CARD -->
    <div class="payment-row">
        <input type="radio" name="paymentMode" value="CARD" id="card">
        <label for="card">Card</label>

        <select name="cardType">
            <option value="">Select Card</option>
            <option value="Credit Card">Credit Card</option>
            <option value="Debit Card">Debit Card</option>
        </select>
    </div>

    <!-- COD -->
    <div class="payment-row">
    <input type="radio" name="paymentMode" value="COD" id="cod" checked>
    <label for="cod">Cash on Delivery</label>

    <!-- empty placeholder to align -->
    <div class="empty-space"></div>
</div>

</div>


        <!-- BUTTON -->
        <button type="submit" class="place-order-btn">Place Order</button>

    </form>

</div>

</body>
</html>
