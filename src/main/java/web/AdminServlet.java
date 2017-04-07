package web;

import model.User;
import repositories.UserRepository;
import repositories.UserRepositoryDummyImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/admin")
public class AdminServlet extends HttpServlet {

    /**
     * Method sends data of all users to the request.
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserRepository repository = new UserRepositoryDummyImpl();
        List<User> users = repository.getAllUsers();

        request.setAttribute("users", users);
        request.getRequestDispatcher("admin.jsp").include(request, response);
    }
}
