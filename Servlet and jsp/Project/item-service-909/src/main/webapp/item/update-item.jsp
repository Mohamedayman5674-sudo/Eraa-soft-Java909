<%@ page import="item.model.Item" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<%
    // ===== Session Check =====
    HttpSession session = request.getSession(false);
    if (session == null || session.getAttribute("user") == null) {
        response.sendRedirect(request.getContextPath() + "/login.jsp?message=Please login first");
        return;
    }

    // ===== Get Item =====
    Item item = (Item) request.getAttribute("item");
    if (item == null) {
        response.sendRedirect(request.getContextPath() + "/ItemController?action=show-items");
        return;
    }
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Item</title>

    <!-- ربط ملف CSS -->
    <link rel="stylesheet"
          href="<%= request.getContextPath() %>/item/css/update-item.css">
</head>
<body>

<div class="form-container">

    <h1>Update Item</h1>

    <form action="<%= request.getContextPath() %>/ItemController" method="post">

        <input type="hidden" name="action" value="update-item">
        <input type="hidden" name="id" value="<%= item.getId() %>">

        <div class="form-group">
            <label>Name</label>
            <input type="text"
                   name="name"
                   value="<%= item.getName() %>"
                   required>
        </div>

        <div class="form-group">
            <label>Price</label>
            <input type="number"
                   name="price"
                   value="<%= item.getPrice() %>"
                   required>
        </div>

        <div class="form-group">
            <label>Total Number</label>
            <input type="number"
                   name="totalNumber"
                   value="<%= item.getTotalNumber() %>"
                   required>
        </div>

        <button type="submit">Update</button>

    </form>

    <div class="back-link">
        <a href="<%= request.getContextPath() %>/ItemController?action=show-items">
            ← Back to Items
        </a>
    </div>

</div>

</body>
</html>
