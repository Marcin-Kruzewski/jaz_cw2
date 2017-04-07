package web;

import model.User;
import repositories.UserRepository;
import repositories.UserRepositoryDummyImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {

    /**
     * Method finds user data in session attributes. Then, it send it to the request.
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        if (user != null) {
            request.setAttribute("user", user);
            request.getRequestDispatcher("profile.jsp").include(request, response);
        }
    }
}
