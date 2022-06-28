package web.dao;

import web.model.User;
import java.util.List;

public interface UserDao {
    List<User> getUserAll();
    User getUserIndex(int index);

    void saveUser(User user);

    void updateUser(int id,User user);

    void deleteUser(int id);

}
