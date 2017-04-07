package repositories;

import model.RoleEnum;
import model.User;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class UserRepositoryDummyImplTest {

    private static UserRepository repository;
    private static User user1, user2, user3;

    @BeforeClass
    public static void init() {
        repository = new UserRepositoryDummyImpl();

        user1 = new User();
        user1.setEmail("user1@a.pl");
        user1.setPassword("a");
        user1.setRole(RoleEnum.USER);

        user2 = new User();
        user2.setEmail("user2@a.pl");
        user2.setPassword("a");
        user2.setRole(RoleEnum.USER);

        user3 = new User();
        user3.setEmail("user3@a.pl");
        user3.setPassword("a");
        user3.setRole(RoleEnum.PREMIUM);

        repository.addUser(user1);
        repository.addUser(user2);
        repository.addUser(user3);
    }

    @Test
    public void should_find_user_by_email_and_password() {
        User user = repository.getUserByEmailAndPassword("user2@a.pl", "a");
        assertNotNull(user);
        assertEquals(user2, user);
    }

    @Test
    public void should_not_find_user_by_email_and_incorrect_password() {
        User user = repository.getUserByEmailAndPassword("user2@a.pl", "b");
        assertNull(user);
    }

    @Test
    public void should_return_all_users() {
        List<User> users = repository.getAllUsers();
        assertEquals(4, users.size()); //+admin
    }

    @Test
    public void should_change_users_permission() {
        repository.changeUsersPremiumPermission("user2@a.pl", true);
        assertEquals(RoleEnum.PREMIUM, user2.getRole());
    }
}
