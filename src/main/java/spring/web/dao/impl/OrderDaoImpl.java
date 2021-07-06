package spring.web.dao.impl;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import spring.web.dao.AbstractDao;
import spring.web.dao.OrderDao;
import spring.web.lib.exception.DataProcessingException;
import spring.web.model.Order;
import spring.web.model.User;

@Repository
public class OrderDaoImpl extends AbstractDao<Order> implements OrderDao {
    public OrderDaoImpl(SessionFactory factory) {
        super(factory, Order.class);
    }

    @Override
    public List<Order> getOrdersHistory(User user) {
        try (Session session = factory.openSession()) {
            return session.createQuery("FROM Order o LEFT JOIN FETCH o.tickets "
                    + "LEFT JOIN FETCH o.user WHERE o.user = :user", Order.class)
                    .setParameter("user", user)
                    .getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Can't find orders by user: " + "user", e);
        }
    }
}
