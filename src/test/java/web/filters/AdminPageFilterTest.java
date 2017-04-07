package web.filters;

import model.RoleEnum;
import model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import web.LoginServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AdminPageFilterTest {

    @InjectMocks
    AdminPageFilter filter;

    @Test
    public void should_redirect_premium_user_to_access_denied_page() throws IOException, ServletException {

        User user = new User();
        user.setRole(RoleEnum.PREMIUM);

        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        HttpSession session = mock(HttpSession.class);
        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("user")).thenReturn(user);

        filter.doFilter(request, response, null);

        verify(response).sendRedirect("accessDenied.jsp");
    }
}

