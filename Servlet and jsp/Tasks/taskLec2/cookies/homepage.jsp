<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%
    String favPlace = request.getParameter("favPlace");

    if (favPlace != null) {
        Cookie cookie = new Cookie("favPlace", favPlace);
        cookie.setMaxAge(60 * 60 * 24 * 30);
        response.addCookie(cookie);
    }

    String savedPlace = null;
    Cookie[] cookies = request.getCookies();

    if (cookies != null) {
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("favPlace")) {
                savedPlace = cookie.getValue();
                break;
            }
        }
    }
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Homepage</title>

<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f6f8;
    }

    .container {
        width: 420px;
        margin: 100px auto;
        padding: 25px;
        background-color: #ffffff;
        border-radius: 10px;
        box-shadow: 0 0 12px rgba(0,0,0,0.1);
        text-align: center;
    }

    h2 {
        color: #333;
        margin-bottom: 15px;
    }

    p {
        font-size: 16px;
        color: #555;
    }

    b {
        color: #4CAF50;
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

    <h2>Homepage</h2>

    <%
        if (savedPlace != null) {
    %>
        <p>Your favorite place is: <b><%= savedPlace %></b></p>
    <%
        } else {
    %>
        <p>No favorite place saved.</p>
    <%
        }
    %>

    <a href="start.html">Go Back</a>

</div>

</body>
</html>

