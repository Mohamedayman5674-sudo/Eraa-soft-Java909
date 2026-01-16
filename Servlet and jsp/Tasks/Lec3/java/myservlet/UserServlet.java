package myservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String fullName = request.getParameter("fullName");
        String age = request.getParameter("age");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>User Details</title>");
        out.println("<style>");
        // Body styling
        out.println("body { font-family: Arial, sans-serif; background-color: #f2f2f2; display: flex; justify-content: center; align-items: center; height: 100vh; margin: 0; }");
        // Container styling
        out.println(".container { background-color: #fff; padding: 40px 50px; border-radius: 15px; box-shadow: 0 8px 20px rgba(0,0,0,0.2); width: 400px; text-align: center; }");
        // Heading styling
        out.println("h2 { color: #333; margin-bottom: 25px; }");
        // Paragraph styling
        out.println("p { font-size: 16px; color: #555; margin: 10px 0; }");
        // Button styling
        out.println(".back-btn { margin-top: 20px; padding: 10px 20px; background-color: #4CAF50; color: white; border: none; border-radius: 8px; cursor: pointer; text-decoration: none; transition: background-color 0.3s ease; }");
        out.println(".back-btn:hover { background-color: #45a049; }");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class='container'>");
        out.println("<h2>User Details</h2>");
        out.println("<p><strong>Full Name:</strong> " + fullName + "</p>");
        out.println("<p><strong>Age:</strong> " + age + "</p>");
        out.println("<a href='index.html' class='back-btn'>Go Back</a>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
    }
}

