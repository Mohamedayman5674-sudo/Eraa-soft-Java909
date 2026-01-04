<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Orders</title>

<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f6f8;
    }

    .container {
        width: 450px;
        margin: 80px auto;
        padding: 25px;
        background-color: #ffffff;
        border-radius: 10px;
        box-shadow: 0 0 12px rgba(0,0,0,0.1);
        text-align: center;
    }

    h2 {
        color: #333;
        margin-bottom: 20px;
    }

    ul {
        list-style-type: none;
        padding: 0;
    }

    li {
        background-color: #f1f1f1;
        margin: 8px 0;
        padding: 10px;
        border-radius: 5px;
        font-size: 16px;
    }

    p {
        color: #777;
        font-size: 16px;
    }

    a {
        display: inline-block;
        margin-top: 20px;
        text-decoration: none;
        color: #2196F3;
        font-weight: bold;
    }

    a:hover {
        text-decoration: underline;
    }
</style>

</head>
<body>

<div class="container">

<h2>All Orders</h2>

<%
    java.util.ArrayList<String> orders =
        (java.util.ArrayList<String>) session.getAttribute("orders");

    if (orders == null || orders.isEmpty()) {
%>
        <p>No orders yet.</p>
<%
    } else {
%>
        <ul>
        <%
            for (String order : orders) {
        %>
            <li><%= order %></li>
        <%
            }
        %>
        </ul>
<%
    }
%>

<a href="order.jsp">Add New Order</a>

</div>

</body>
</html>

