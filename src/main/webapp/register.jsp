<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<title>Register 🍔</title>
<style>
body { font-family: Arial; background:#fff3e0; }
.box {
    width:350px; margin:100px auto; padding:20px;
    box-shadow:0 0 10px #ccc; border-radius:10px;
}
input,button {
    width:100%; padding:10px; margin:10px 0;
}
button {
    background:#fc8019; color:white; border:none;
}
</style>
</head>
<body>

<div class="box">
<h2>Sign Up 🍕</h2>
<form action="register" method="post">
<input name="name" placeholder="Name" required>
<input name="email" placeholder="Email" required>
<input name="password" type="password" placeholder="Password" required>
<button>Create Account</button>
</form>
<p>Already have account? <a href="login.jsp">Login</a></p>
</div>

</body>
</html>
