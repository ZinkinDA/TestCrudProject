package web;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import web.config.AppHibernateConfig;
import web.dao.UserDao;
import web.model.User;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppHibernateConfig.class);
        UserDao hibernateDAO = context.getBean(UserDao.class);
        hibernateDAO.saveUser(new User("Ruslan","email12"));
        context.close();
    }
}
