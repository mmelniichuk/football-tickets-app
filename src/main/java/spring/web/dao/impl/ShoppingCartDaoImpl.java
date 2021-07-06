package spring.web.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import spring.web.dao.AbstractDao;
import spring.web.dao.ShoppingCartDao;
import spring.web.lib.exception.DataProcessingException;
import spring.web.model.ShoppingCart;
import spring.web.model.User;

@Repository
public class ShoppingCartDaoImpl extends AbstractDao<ShoppingCart> implements ShoppingCartDao {
    public ShoppingCartDaoImpl(SessionFactory factory) {
        super(factory, ShoppingCart.class);
    }

    @Override
    public ShoppingCart getByUser(User user) {
        try (Session session = factory.openSession()) {
            return session.createQuery("FROM ShoppingCart WHERE user = :user", ShoppingCart.class)
                    // "FROM Order o LEFT JOIN FETCH o.tickets "
                    // + "LEFT JOIN FETCH o.user WHERE o.user = :user",
                    .setParameter("user", user)
                    .uniqueResult();
        } catch (Exception e) {
            throw new DataProcessingException("Can't find shopping cart by user: " + user, e);
        }
    }
}
