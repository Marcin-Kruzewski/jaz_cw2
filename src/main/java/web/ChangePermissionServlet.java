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

@WebServlet("/changePermission")
public class ChangePermissionServlet extends HttpServlet {

    private UserRepository repository;

    public void init(ServletConfig config) throws ServletException {
        repository = new UserRepositoryDummyImpl();
    }

    /**
     * Method changes selected users permissions.
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("email");
        String permissionString = request.getParameter("permission");
        boolean permission = permissionString == null ? false : true;

        repository.changeUsersPremiumPermission(email, permission);

        response.sendRedirect("admin");
    }
}
