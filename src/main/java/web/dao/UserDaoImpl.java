package web.dao;


import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Component
@Transactional
public class UserDaoImpl implements UserDao{

    private static int USER_ID = 0;

    private EntityManager entityManager;

    @Override
    public List<User> getUserAll() {
        String query = "SELECT users FROM User users";
        List<User> userList = entityManager.createQuery(query,User.class).getResultList();
        return userList;
    }

    @Override
    public User getUserIndex(int index) {
        return entityManager.find(User.class,index);
    }

    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void updateUser(int index , User user){
        entityManager.merge(user);
    }

    @Override
    public void deleteUser(int id) {
        entityManager.remove(getUserIndex(id));
    }
}
