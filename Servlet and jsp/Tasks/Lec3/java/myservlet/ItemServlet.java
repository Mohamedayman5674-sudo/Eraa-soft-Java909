package myservlet;

import service.ItemUtilService;
import model.Item;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/items")
public class ItemServlet extends HttpServlet {

    private ItemUtilService service;

    @Override
    public void init() throws ServletException {
        service = new ItemUtilService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // بيانات تجريبية
        List<Item> items = new ArrayList<>();
        items.add(new Item(1, "Phone", 30));
        items.add(new Item(2, "Laptop", 100));
        items.add(new Item(3, "Mouse", 25));
        items.add(new Item(4, "iPad", 40));

        // حفظ البيانات
        service.saveItems(items);

        response.setContentType("text/html");
        response.getWriter().println("<h2>Items Task</h2>");

        // 1️⃣ ID in (1,2)
        response.getWriter().println("<h3>ID in (1,2)</h3>");
        for (Item item : service.getItemsByIds(items)) {
            printItem(response, item);
        }

        // 2️⃣ Name contains 'i'
        response.getWriter().println("<h3>Name contains 'i'</h3>");
        for (Item item : service.getItemsNameContainI(items)) {
            printItem(response, item);
        }

        // 3️⃣ Price between 20 and 50
        response.getWriter().println("<h3>Price between 20 and 50</h3>");
        for (Item item : service.getItemsByPriceRange(items)) {
            printItem(response, item);
        }
    }

    private void printItem(HttpServletResponse response, Item item) throws IOException {
        response.getWriter().println(
                item.getId() + " - " + item.getName() + " - " + item.getPrice() + "<br>"
        );
    }
    }