<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<title>Login 🔐</title>
<style>
body {
    font-family: Arial;
    background:#fff3e0;
}
.box {
    width:350px;
    margin:120px auto;
    padding:20px;
    border-radius:10px;
    box-shadow:0 0 10px #ccc;
    background:white;
}
input, button {
    width:100%;
    padding:10px;
    margin:10px 0;
}
button {
    background:#fc8019;
    color:white;
    border:none;
    cursor:pointer;
}
</style>
</head>
<body>

<div class="box">
<h2>Login 🍔</h2>

<form action="login" method="post">   <!-- 🔥 MUST BE post -->
    <input type="email" name="email" placeholder="Email" required>
    <input type="password" name="password" placeholder="Password" required>
    <button type="submit">Login</button>
</form>

<p>New user? <a href="register.jsp">Sign Up</a></p>

<% if(request.getAttribute("error") != null){ %>
    <p style="color:red"><%= request.getAttribute("error") %></p>
<% } %>

</div>
</body>
</html>
