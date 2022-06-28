package web.dao;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;
import web.model.User;
import web.util.Util;

import javax.persistence.criteria.CriteriaQuery;
import java.util.ArrayList;
import java.util.List;


@Component
public class UserDaoImpl implements UserDao{

    private final SessionFactory sessionFactory = Util.getSessionFactory();
    private static int USER_ID = 0;

    @Override
    public List<User> getUserAll() {
        Session session = sessionFactory.openSession();
        CriteriaQuery<User> criteriaQuery = session.getCriteriaBuilder().createQuery(User.class);
        criteriaQuery.from(User.class);
        Transaction transaction = session.beginTransaction();
        List<User> list = session.createQuery(criteriaQuery).getResultList();

        try {
            transaction.commit();
            return list;
        } catch (HibernateException e){
            e.printStackTrace();
            transaction.rollback();
        } finally {
            session.close();
        }
        return list;
    }

    @Override
    public User getUserIndex(int index) {
        User user;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            user = session.get(User.class, index);
            transaction.commit();
            return user;
        } catch (HibernateException e){
            e.printStackTrace();
            if(transaction.isActive()) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return new User();
    }

    @Override
    public void saveUser(User user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            session.save(new User(++USER_ID, user.getName(), user.getSurName()));
            transaction.commit();
            System.out.println("User upload to database : " + user.getName());
        } catch (HibernateException e) {
            e.printStackTrace();
            if (transaction.isActive()) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
    }

    @Override
    public void updateUser(int id,User user){
        User updatedUser = getUserIndex(id);
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        updatedUser.setName(user.getName());
        updatedUser.setSurName(user.getSurName());
        try {
            session.delete(session.get(User.class,id));
            session.save(new User(id,user.getName(),user.getSurName()));
            transaction.commit();
        } catch (HibernateException e){
            e.printStackTrace();
            if(transaction.isActive()){
                transaction.rollback();
            }
        } finally {
            session.close();
        }
    }

    @Override
    public void deleteUser(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(session.get(User.class, id));
            transaction.commit();
            System.out.println("User deleted!");
        } catch (HibernateException e) {
            e.printStackTrace();
            if(transaction.isActive()){
                transaction.rollback();
            }
        } finally {
            session.close();
        }
    }



}
