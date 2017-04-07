package web;

import model.User;
import repositories.UserRepository;
import repositories.UserRepositoryDummyImpl;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {

    private UserRepository repository;

    public void init(ServletConfig config) throws ServletException {
        repository = new UserRepositoryDummyImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("/register.jsp").include(request, response);
    }

    /**
     * Method adds new user to the repository.
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = retrieveUserDataFromRequest(request);
        repository.addUser(user);
        response.sendRedirect("success.jsp");
    }

    private User retrieveUserDataFromRequest(HttpServletRequest request) {
        User user = new User();
        user.setEmail(request.getParameter("email"));
        user.setUsername(request.getParameter("username"));
        user.setPassword(request.getParameter("password"));
        return user;
    }


}
