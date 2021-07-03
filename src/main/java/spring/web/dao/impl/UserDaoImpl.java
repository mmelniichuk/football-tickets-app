package spring.web.dao.impl;

import java.util.Optional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import spring.web.dao.AbstractDao;
import spring.web.dao.UserDao;
import spring.web.lib.exception.DataProcessingException;
import spring.web.model.User;

@Repository
public class UserDaoImpl extends AbstractDao<User> implements UserDao {
    public UserDaoImpl(SessionFactory factory) {
        super(factory, User.class);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        try (Session session = factory.openSession()) {
            return session.createQuery(
                    "FROM User u INNER JOIN FETCH u.roles WHERE u.email = :email", User.class)
                    .setParameter("email", email)
                    .uniqueResultOptional();
        } catch (Exception e) {
            throw new DataProcessingException("User with email: " + email + " not found", e);
        }
    }
}
