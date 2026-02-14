<%@ page import="java.util.List" %>
<%@ page import="item.model.Item" %>
<%@ page import="item.model.User" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<%
    User loggedUser = (User) session.getAttribute("user");
    if (loggedUser == null) {
        response.sendRedirect(request.getContextPath() + "/item/login.jsp");
        return;
    }

    String message = request.getParameter("message");
    if (message == null) {
        message = (String) request.getAttribute("message");
    }

    List<Item> items = (List<Item>) request.getAttribute("allItems");
    String ctx = request.getContextPath();
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Show Items</title>
    <link rel="stylesheet" href="<%= ctx %>/item/css/show-items.css">
</head>
<body>

<div class="layer">

    <!-- Header -->
    <div class="header">
        <h2>Welcome, <%= loggedUser.getName() %></h2>
        <a class="logout-btn"
           href="<%= ctx %>/UserController?action=logout">
            Logout
        </a>
    </div>

    <h1>Items</h1>

    <% if (message != null && !message.trim().isEmpty()) { 
        String cssClass = message.toLowerCase().contains("success") ? "success" : "error";
    %>
        <div class="message <%= cssClass %>">
            <%= message.replace("+", " ") %>
        </div>
    <% } %>

    <table>
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Price</th>
            <th>Total</th>
            <th>Actions</th>
        </tr>
        </thead>

        <tbody>
        <% if (items != null && !items.isEmpty()) {
            for (Item item : items) {
                String desc = item.getDesc();
                boolean hasDetails = desc != null && !desc.trim().isEmpty();
        %>
        <tr>
            <td><%= item.getId() %></td>
            <td><%= item.getName() %></td>
            <td><%= item.getPrice() %></td>
            <td><%= item.getTotalNumber() %></td>
<td class="actions">

    <div class="main-actions">
        <a class="update"
           href="<%= ctx %>/ItemController?action=show-item&id=<%= item.getId() %>">
            Update
        </a>

        <a class="delete"
           href="<%= ctx %>/ItemController?action=delete-item&id=<%= item.getId() %>"
           onclick="return confirm('Delete item?')">
            Delete
        </a>
    </div>

    <div class="details-actions">
        <% if (!hasDetails) { %>
            <a class="details-add"
               href="<%= ctx %>/ItemController?action=show-add-details&id=<%= item.getId() %>">
                Add Details
            </a>
        <% } else { %>
            <a class="details-update"
               href="<%= ctx %>/ItemController?action=show-update-details&id=<%= item.getId() %>">
                Update Details
            </a>

            <a class="details-delete"
               href="<%= ctx %>/ItemController?action=delete-item-details&id=<%= item.getId() %>"
               onclick="return confirm('Delete item details?')">
                Delete Details
            </a>
        <% } %>
    </div>

</td>


        </tr>
        <%  }
           } else { %>
        <tr>
            <td colspan="5" style="text-align:center;">No Items Found</td>
        </tr>
        <% } %>
        </tbody>
    </table>

    <div style="text-align:center;">
        <a class="add-btn"
           href="<%= ctx %>/item/add-item.jsp">
            Add Item
        </a>
    </div>

</div>

</body>
</html>