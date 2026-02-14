<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Message</title>
    <style>
        body {
            font-family: Arial;
            text-align: center;
            margin-top: 100px;
        }
        .box {
            border: 1px solid #ccc;
            padding: 30px;
            display: inline-block;
            background-color: #f5f5f5;
            border-radius: 10px;
        }
        a {
            display: block;
            margin-top: 20px;
            text-decoration: none;
            font-weight: bold;
        }
    </style>
</head>
<body>

<div class="box">
    <h2>${param.message}</h2>
    
    <!-- Fixed Link -->
    <a href="<%=request.getContextPath()%>/ItemController">
        Back to Items
    </a>
    
</div>

</body>
</html>