<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Food Order</title>

<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f6f8;
    }

    .container {
        width: 400px;
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

    input[type="text"] {
        width: 100%;
        padding: 10px;
        margin-bottom: 15px;
        border: 1px solid #ccc;
        border-radius: 5px;
        font-size: 15px;
    }

    input[type="submit"] {
        width: 100%;
        padding: 10px;
        background-color: #4CAF50;
        color: white;
        border: none;
        border-radius: 5px;
        font-size: 16px;
        cursor: pointer;
    }

    input[type="submit"]:hover {
        background-color: #43a047;
    }

    a {
        display: inline-block;
        margin-top: 15px;
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

    <h2>Order Food</h2>

    <form action="order.jsp" method="post">
        <input type="text" name="food" placeholder="Enter food name" required>
        <input type="submit" value="Add Order">
    </form>

    <%
        String food = request.getParameter("food");

        if (food != null) {

            java.util.ArrayList<String> orders =
                (java.util.ArrayList<String>) session.getAttribute("orders");

            if (orders == null) {
                orders = new java.util.ArrayList<String>();
            }

            orders.add(food);
            session.setAttribute("orders", orders);
        }
    %>

    <a href="allorders.jsp">View All Orders</a>

</div>

</body>
</html>
