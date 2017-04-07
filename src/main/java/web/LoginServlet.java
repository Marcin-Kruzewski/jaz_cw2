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
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private UserRepository repository;

    public void init(ServletConfig config) throws ServletException {
        repository = new UserRepositoryDummyImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("/login.jsp").include(request, response);
    }

    /**
     * Method finds user data by request params. When user exists his data are saved as the session attribute.
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = findUserByRequestParams(request);
        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            response.sendRedirect("profile");
        } else {
            response.sendRedirect("error.jsp");
        }
    }

    private User findUserByRequestParams(HttpServletRequest request) {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        return repository.getUserByEmailAndPassword(email, password);
    }
}
