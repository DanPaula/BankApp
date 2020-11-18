package repository.user;

import model.User;
import model.validation.Notification;

import java.util.List;


public interface UserRepository {

    List<User> findAll();

    Notification<User> findByUsernameAndPassword(String username, String password) throws AuthenticationException;

    boolean save(User user);

    boolean update(String oldUsername,String newUsername,String password);

    boolean delete(String username);

    void removeAll();

}

