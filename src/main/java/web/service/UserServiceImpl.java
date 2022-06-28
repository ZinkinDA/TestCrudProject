package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.UserDao;
import web.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> getUserAll() {
        return userDao.getUserAll();
    }

    @Override
    public User getUserIndex(int index) {
        return userDao.getUserIndex(index);
    }

    @Override
    public void saveUser(User user){
        userDao.saveUser(user);
    }

    @Override
    public void updateUser(int id,User user){
        userDao.updateUser(id,user);
    }

    @Override
    public void deleteUser(int id) {
        userDao.deleteUser(id);
    }
}
