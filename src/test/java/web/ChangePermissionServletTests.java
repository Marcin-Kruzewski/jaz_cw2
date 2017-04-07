package web;

import model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import repositories.UserRepository;
import repositories.UserRepositoryDummyImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RunWith(MockitoJUnitRunner.class)
public class ChangePermissionServletTests extends Mockito {
    @Spy
    UserRepository repository = mock(UserRepositoryDummyImpl.class);

    @InjectMocks
    ChangePermissionServlet servlet;

    @Test
    public void servlet_should_change_users_permission() throws IOException, ServletException {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        servlet.doPost(request, response);
        verify(repository).changeUsersPremiumPermission(null, false);
    }
}
