<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<style>
.header {
  background:#fc8019;
  padding:15px 30px;
  display:flex;
  align-items:center;
  justify-content:space-between;
}
.logo {
  font-size:24px;
  font-weight:bold;
  color:white;
}
.search-box input {
  padding:10px;
  width:300px;
  border-radius:5px;
  border:none;
}
.nav a {
  color:white;
  margin-left:20px;
  text-decoration:none;
  font-weight:bold;
}
</style>

<div class="header">
  <div class="logo">🍔 Foodsy</div>

  <form class="search-box" action="home" method="get">
    <input type="text" name="search" placeholder="Search restaurants 🍕🍜">
  </form>

  <div class="nav">
    <a href="HomeServlet">Home</a>
    <a href="cart">Cart</a>
    <a href="login.jsp">Login</a>
    <a href="orders.jsp">Orders</a>
  </div>
</div>
