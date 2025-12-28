<%@ page language="java" contentType="text/html; charset=UTF-8" %>

<%
    String fullName = request.getParameter("FullName");
    String password = request.getParameter("Password");
    String age = request.getParameter("Age");
    String addressRadio = request.getParameter("addressRadio");
    String addressSelect = request.getParameter("addressSelect");
%>

<html>
<head>
    <title>Result Page</title>
</head>
<body>

<h2>Received Data</h2>

<p>Full Name: <%= fullName %></p>
<p>Password: <%= password %></p>
<p>Age: <%= age %></p>
<p>Address (Radio): <%= addressRadio %></p>
<p>Address (Select): <%= addressSelect %></p>

</body>
</html>
