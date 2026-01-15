<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String username = (String) session.getAttribute("username");
%>

<style>
    .navbar {
        display: flex;
        justify-content: space-between;
        align-items: center;
        padding: 14px 30px;
        background-color: #e4572e;
        color: white;
    }

    .nav-left {
        font-size: 22px;
        font-weight: bold;
    }

    .nav-right a {
        color: white;
        margin-left: 20px;
        text-decoration: none;
        font-weight: 500;
    }

    .nav-right a:hover {
        text-decoration: underline;
    }
</style>

<div class="navbar">
    <div class="nav-left">
        🍔 Food App
    </div>

    <div class="nav-right">

        <a href="<%= request.getContextPath() %>/home">Home</a>

        <% if (username == null) { %>
            <!-- NOT LOGGED IN -->
            <a href="<%= request.getContextPath() %>/login.jsp">Login</a>
            <a href="<%= request.getContextPath() %>/register.jsp">Register</a>
        <% } else { %>
            <!-- LOGGED IN -->
            <a href="orders">Orders</a>
            
            <a href="<%= request.getContextPath() %>/orders">Orders</a>



            <a href="<%= request.getContextPath() %>/cart">Cart</a>
            <a href="<%= request.getContextPath() %>/logout">Logout</a>
        <% } %>

    </div>
</div>
