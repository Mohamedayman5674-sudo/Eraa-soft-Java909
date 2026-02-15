package item.controller;

import item.model.User;
import item.service.UserService;
import item.service.impl.UserServiceImpl;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.sql.DataSource;
import java.io.IOException;

@WebServlet("/UserController")
public class UserController extends HttpServlet {

    @Resource(name = "jdbc/connection")
    private DataSource dataSource;

    private UserService getUserService() {
        return new UserServiceImpl(dataSource);
    }

    // ======================= GET =======================
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        if (action == null) action = "login";

        switch (action) {
            case "logout":
                logout(request, response);
                break;
            default:
                response.sendRedirect(request.getContextPath() + "/item/login.jsp");
                break;
        }
    }

    // ======================= POST =======================
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        switch (action) {
            case "signup":
                signup(request, response);
                break;
            case "login":
                login(request, response);
                break;
            default:
                response.sendRedirect(request.getContextPath() + "/item/login.jsp");
        }
    }

    // ======================= METHODS =======================
    private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
          
        HttpSession session = request.getSession(false);
        if (session != null) session.invalidate();

     
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                c.setMaxAge(0);
                c.setPath(request.getContextPath());
                response.addCookie(c);
            }
        }

        
        response.sendRedirect(request.getContextPath() + "/item/login.jsp?message=Logged+out+successfully");
    }

    private void signup(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);

        boolean success = getUserService().signup(user);

        if (success) {
            response.sendRedirect(request.getContextPath() + "/item/login.jsp?message=Signup+successful,+please+login");
        } else {
            response.sendRedirect(request.getContextPath() + "/item/signup.jsp?message=Email+already+exists");
        }
    }

    private void login(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        User user = getUserService().login(email, password);

        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);

            response.sendRedirect(request.getContextPath() + "/ItemController?action=show-items");
        } else {
            response.sendRedirect(request.getContextPath() + "/item/login.jsp?message=Invalid+username+or+password");
        }
    }

}
