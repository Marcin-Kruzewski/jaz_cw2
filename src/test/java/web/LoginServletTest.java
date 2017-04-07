package web;

import model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import repositories.UserRepository;
import repositories.UserRepositoryDummyImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@RunWith(MockitoJUnitRunner.class)
public class LoginServletTest extends Mockito {
    @Spy
    UserRepository repository = mock(UserRepositoryDummyImpl.class);

    @InjectMocks
    LoginServlet servlet;

    @Test
    public void servlet_should_add_user_to_session() throws IOException, ServletException {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        HttpSession session = mock(HttpSession.class);
        when(request.getSession()).thenReturn(session);
        when(repository.getUserByEmailAndPassword(null, null)).thenReturn(new User());

        servlet.doPost(request, response);

        verify(session).setAttribute(eq("user"), Mockito.any(User.class));
    }

    @Test
    public void servlet_should_properly_redirect_user() throws IOException, ServletException {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        HttpSession session = mock(HttpSession.class);
        when(request.getSession()).thenReturn(session);
        when(repository.getUserByEmailAndPassword(null, null)).thenReturn(new User());

        servlet.doPost(request, response);

        verify(response).sendRedirect("profile");
    }
}
