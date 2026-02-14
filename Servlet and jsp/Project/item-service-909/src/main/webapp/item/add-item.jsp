<%@ page contentType="text/html;charset=UTF-8" %>

<%
    // استخدام الـ implicit session object مباشرة
    if (session.getAttribute("user") == null) {
        response.sendRedirect(request.getContextPath() + "/login.jsp?message=Please login first");
        return;
    }
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Item</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/item/css/add-item.css">
</head>
<body>

<div class="layer">
    <h1>Add Item</h1>

    <form action="<%= request.getContextPath() %>/ItemController" method="post">

        <input type="hidden" name="action" value="add-item">

        <input type="text"
               name="name"
               placeholder="Enter name"
               required>

        <input type="number"
               name="price"
               placeholder="Enter price"
               required>

        <input type="number"
               name="totalNumber"
               placeholder="Enter total number"
               required>

        <button type="submit">Add</button>
    </form>

</div>

</body>
</html>