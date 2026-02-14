<%@ page import="item.model.Item" %>

<%
    Item item = (Item) request.getAttribute("item"); // تأكد الكنترول بعت الـ item هنا
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Item</title>

    <!-- CSS -->
    <link rel="stylesheet" href="<%= request.getContextPath() %>/item/css/update-item.css">

    <script>
        // Show popup message بعد تحديث العنصر
        function showMessage() {
            const params = new URLSearchParams(window.location.search);
            const msg = params.get("msg");
            if (msg === "updated") {
                alert("Item updated successfully");
            }
        }

        window.onload = showMessage;
    </script>
</head>
<body>
    <h2>Update Item</h2>

    <%
        if (item != null) {
    %>
    <form action="<%= request.getContextPath() %>/ItemController" method="post">
        <input type="hidden" name="id" value="<%= item.getId() %>">

        <label>Name:</label>
        <input type="text" name="name" value="<%= item.getName() %>" required><br><br>

        <label>Price:</label>
        <input type="number" step="0.01" name="price" value="<%= item.getPrice() %>" required><br><br>

        <label>Total Number:</label>
        <input type="number" name="totalNumber" value="<%= item.getTotalNumber() %>" required><br><br>

        <input type="hidden" name="action" value="update-item">
        <button type="submit">Update</button>
    </form>
    <%
        } else {
    %>
    <p>Item not found!</p>
    <%
        }
    %>

    <br>
    <a href="<%= request.getContextPath() %>/ItemController?action=list">Back to Items</a>

</body>
</html>