package repositories;

import model.User;

import java.util.List;

public interface UserRepository {

    User getUserByEmailAndPassword(String email, String password);

    void addUser(User user);

    List<User> getAllUsers();

    void changeUsersPremiumPermission(String email, boolean premium);
}
