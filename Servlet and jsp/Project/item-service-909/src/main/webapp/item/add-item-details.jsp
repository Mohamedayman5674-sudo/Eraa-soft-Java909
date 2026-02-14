<%@ page import="item.model.ItemDetails" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<%
    Long itemId = (Long) request.getAttribute("itemId");
    if (itemId == null) {
        response.sendRedirect(request.getContextPath() + "/ItemController?action=show-items");
        return;
    }
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Item Details</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f4f6f9;
        }

        .layer {
            width: 400px;
            margin: 50px auto;
            background: white;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 0 10px #ccc;
        }

        h1 {
            text-align: center;
            margin-bottom: 20px;
            color: #333;
        }

        input[type="text"], input[type="date"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            border-radius: 6px;
            border: 1px solid #ccc;
            box-sizing: border-box;
        }

        button {
            width: 100%;
            padding: 10px;
            background: #007bff;
            color: white;
            border: none;
            border-radius: 6px;
            font-weight: bold;
            cursor: pointer;
        }

        button:hover {
            background: #0069d9;
        }
    </style>
</head>
<body>

<div class="layer">
    <h1>Add Item Details</h1>

    <form action="<%= request.getContextPath() %>/ItemController" method="post">

        <input type="hidden" name="action" value="add-item-details">
        <input type="hidden" name="id" value="<%= itemId %>">

        <input type="text" name="desc" placeholder="Enter Description" required>
        <label>Issue Date:</label>
        <input type="date" name="issueDate" required>
        <label>Expiry Date:</label>
        <input type="date" name="expiryDate" required>

        <button type="submit">Add Details</button>
    </form>
</div>

</body>
</html>