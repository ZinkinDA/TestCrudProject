package web.util;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
import web.model.User;

public class Util {
    private static final String dbUser = "root";
    private static final String dbPass = "assasin!23S!";
    private static String connectString = "jdbc:mysql://localhost:3306/crud_project?useSSL=false&allowMultiQueries=true&serverTimezone=UTC";

    private static SessionFactory sessionFactory ;

    public static SessionFactory getSessionFactory(){

        try {
            Configuration configuration = new Configuration()
                    .setProperty("hibernate.connection.url", connectString)
                    .setProperty("hibernate.connection.username", dbUser)
                    .setProperty("hibernate.connection.password", dbPass )
                    .setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect")
                    .addAnnotatedClass(User.class)
                    .setProperty("hibernate.c3p0.min_size","5")
                    .setProperty("hibernate.c3p0.max_size","200")
                    .setProperty("hibernate.c3p0.max_statements","200");
            ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties())
                    .build();
            sessionFactory = configuration.buildSessionFactory(registry);
        } catch (HibernateException e){
            e.printStackTrace();
        }
        return sessionFactory;
    }
}
