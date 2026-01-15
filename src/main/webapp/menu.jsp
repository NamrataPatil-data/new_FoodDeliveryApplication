<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.app.model.Menu" %>

<%@ include file="header.jsp" %>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/menu.css">


<style>
.menu-container {
 display:grid;
 grid-template-columns:repeat(2,1fr);
 gap:20px;
 padding:30px;
}
.menu-card {
 background:#f5f0e6;
 border-radius:10px;
 padding:15px;
 display:flex;
 gap:15px;
}
.menu-card img {
 width:150px;
 border-radius:8px;
}
.add-btn {
 background:#fc8019;
 color: #f5f0e6;
 padding:8px 12px;
 border:none;
 border-radius:5px;
}
</style>

<h2 style="text-align:center; color:#8B4513;">Welcome to our Restaurant 🍴</h2>

<div class="menu-container">
<%
List<Menu> menuList = (List<Menu>) request.getAttribute("menuList");
for(Menu m : menuList){
%>
<div class="menu-card">
  <img src="<%= m.getImagePath() %>">
  <div>
    <h4><%= m.getItemName() %></h4>
    <p><%= m.getDescription() %></p>
    <p>₹ <%= m.getPrice() %></p>
    <a href="cart?action=add&menuId=<%= m.getMenuId() %>" class="add-btn">Add to Cart ➕</a>
  </div>
</div>
<% } %>

</div>
