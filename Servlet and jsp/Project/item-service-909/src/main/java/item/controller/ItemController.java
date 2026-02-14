package item.controller;

import item.model.Item;
import item.model.ItemDetails;
import item.service.ItemService;
import item.service.ItemDetailsService;
import item.service.impl.ItemServiceImpl;
import item.service.impl.ItemDetailsServiceImpl;

import javax.annotation.Resource;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;

@WebServlet("/ItemController")
public class ItemController extends HttpServlet {

    @Resource(name = "jdbc/connection")
    private DataSource dataSource;

    private ItemService getItemService() {
        return new ItemServiceImpl(dataSource);
    }

    private ItemDetailsService getItemDetailsService() {
        return new ItemDetailsServiceImpl(dataSource);
    }

    // ======================= GET =======================
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        if (action == null) action = "show-items";

        switch (action) {
            case "show-items": showItems(request, response); break;
            case "show-item": showItem(request, response); break;
            case "delete-item": deleteItem(request, response); break;
            case "show-add-details": showAddDetailsForm(request, response); break;
            case "show-update-details": showUpdateDetailsForm(request, response); break;
            case "delete-item-details": deleteItemDetails(request, response); break;
            default: showItems(request, response); break;
        }
    }

    // ======================= POST =======================
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        switch (action) {
            case "add-item": addItem(request, response); break;
            case "update-item": updateItem(request, response); break;
            case "add-item-details": addItemDetails(request, response); break;
            case "update-item-details": updateItemDetails(request, response); break;
        }
    }

    // ================= SHOW ITEMS =================
    private void showItems(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Item> items = getItemService().getAllItems();
        request.setAttribute("allItems", items);
        request.getRequestDispatcher("/item/show-items.jsp").forward(request, response);
    }

    private void showItem(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Long id = Long.parseLong(request.getParameter("id"));
        Item item = getItemService().getItemById(id);
        request.setAttribute("item", item);
        request.getRequestDispatcher("/item/show-item.jsp").forward(request, response);
    }

    // ================= ADD / UPDATE / DELETE ITEM =================
    private void addItem(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ItemService service = getItemService();
        String name = request.getParameter("name");

        if (service.getItemByName(name) != null) {
            redirectWithMessage(response, "Item name already exists");
            return;
        }

        Item item = new Item();
        item.setName(name);
        item.setPrice(Double.parseDouble(request.getParameter("price")));
        item.setTotalNumber(Integer.parseInt(request.getParameter("totalNumber")));

        service.addItem(item);
        redirectWithMessage(response, "Item added successfully");
    }

    private void updateItem(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ItemService service = getItemService();
        Long id = Long.parseLong(request.getParameter("id"));
        String name = request.getParameter("name");

        Item existing = service.getItemByName(name);
        if (existing != null && !existing.getId().equals(id)) {
            redirectWithMessage(response, "Item name already exists");
            return;
        }

        Item item = new Item();
        item.setId(id);
        item.setName(name);
        item.setPrice(Double.parseDouble(request.getParameter("price")));
        item.setTotalNumber(Integer.parseInt(request.getParameter("totalNumber")));

        service.updateItem(item);
        redirectWithMessage(response, "Item updated successfully");
    }

    private void deleteItem(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        getItemService().removeItem(id);
        redirectWithMessage(response, "Item deleted successfully");
    }

    // ================= ADD / UPDATE / DELETE ITEM DETAILS =================
    private void showAddDetailsForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        request.setAttribute("itemId", id);
        request.getRequestDispatcher("/item/add-item-details.jsp").forward(request, response);
    }

    private void showUpdateDetailsForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        ItemDetails details = getItemDetailsService().getByItemId(id);
        if (details == null) {
            redirectWithMessage(response, "Item details not found");
            return;
        }
        request.setAttribute("itemDetails", details);
        request.getRequestDispatcher("/item/update-item-details.jsp").forward(request, response);
    }

    private void addItemDetails(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ItemDetails details = buildItemDetailsFromRequest(request);
        getItemDetailsService().addDetails(details);
        redirectWithMessage(response, "Item details added successfully");
    }

    private void updateItemDetails(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ItemDetails details = buildItemDetailsFromRequest(request);
        getItemDetailsService().updateDetails(details);
        redirectWithMessage(response, "Item details updated successfully");
    }

    private void deleteItemDetails(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        getItemDetailsService().deleteDetails(id);
        redirectWithMessage(response, "Item details deleted successfully");
    }

    // ================= HELPER =================
    private void redirectWithMessage(HttpServletResponse response, String message) throws IOException {
        // هنا نضيف الـ context path عشان ما يحصلش 404
        response.sendRedirect(getServletContext().getContextPath() + "/item/message.jsp?message=" + message.replace(" ", "+"));
    }

    private ItemDetails buildItemDetailsFromRequest(HttpServletRequest request) {
        Long id = Long.parseLong(request.getParameter("id"));
        String desc = request.getParameter("desc");
        java.util.Date issueDate = java.sql.Date.valueOf(request.getParameter("issueDate"));
        java.util.Date expiryDate = java.sql.Date.valueOf(request.getParameter("expiryDate"));

        ItemDetails details = new ItemDetails();
        details.setId(id);
        details.setDesc(desc);
        details.setIssueDate(issueDate);
        details.setExpiryDate(expiryDate);
        return details;
    }

}