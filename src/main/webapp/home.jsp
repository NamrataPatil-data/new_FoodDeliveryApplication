<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.app.model.Restaurant" %>
<%@ include file="header.jsp" %>

<style>
body {
    margin: 0;
    padding: 0;
    min-height: 100vh;
    font-family: "Segoe UI", sans-serif;

    background: url("images/home-bg6.jpg") no-repeat center center fixed;
    background-size: cover;
}


.container{
    display:grid;
    grid-template-columns: repeat(3, 1fr);
    gap:25px;
    padding:30px;
}

.card{
    background:#f5efe6;
    border-radius:12px;
    overflow:hidden;
    transition:0.3s;
    box-shadow: 0 10px 25px rgba(0,0,0,0.12);
    
}

.card:hover{
    transform: scale(1.05);
    box-shadow: 0 18px 40px rgba(0,0,0,0.18);

}

.card img{
    width:100%;
    height:200px;
    object-fit:cover;
}

.card-body{
    padding:15px;
}

.rating{
    color:green;
    font-weight:bold;
}

.btn{
    display:inline-block;
    margin-top:10px;
    padding:8px 15px;
    background:#fc8019;
    color:#f5f0e6;
    border-radius:5px;
    text-decoration:none;
}
/* MAIN TITLE */
.welcome-title {
    text-align: center;
    margin-top: 20px;
    font-size: 42px;
    font-weight: 800;
    color: white;
}

/* Highlight Foodsy */
.welcome-title span {
    color: #ff9800;
}

/* SUBTITLE */
.welcome-subtitle {
    text-align: center;
    margin-top: 8px;
    font-size: 18px;
    font-weight: 500;
    color: rgba(255, 255, 255, 0.9);
}

</style>

<h2 style="
    text-align:center;
    margin-top:30px;
    font-size:44px;
    font-weight:800;
    color:white;
    letter-spacing:1px;
    text-shadow: 0 4px 12px rgba(0,0,0,0.6);
">
    Welcome to 
    <span style="
        color:#ff9800;
        background: rgba(0,0,0,0.35);
        padding: 6px 14px;
        border-radius: 8px;
        box-shadow: 0 4px 10px rgba(0,0,0,0.4);
    ">
        Foodsy
    </span>
    😊
</h2>

<p style="
    text-align:center;
    margin-top:10px;
    font-size:18px;
    font-weight:600;
    color: rgba(255,255,255,0.9);
    letter-spacing:0.5px;
">
    Best food delivered to your home 🍕
</p>



<div class="container">
<%
List<Restaurant> list =
        (List<Restaurant>) request.getAttribute("restaurantList");

if(list != null){
for(Restaurant r : list){
%>

<div class="card">
    <img src="<%= r.getImagePath() %>">

    <div class="card-body">
        <h3><%= r.getName() %></h3>

        <!-- ✅ LOCATION -->
        <p><%= r.getLocation() %></p>

        <!-- ✅ RATING ONLY -->
        <p class="rating">⭐ <%= r.getRating() %> / 5</p>

        <a class="btn"
           href="menu?restaurantId=<%= r.getRestaurantId() %>">
            View Menu 🍴
        </a>
    </div>
</div>

<% } } %>
</div>
