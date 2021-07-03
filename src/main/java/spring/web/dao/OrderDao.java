package spring.web.dao;

import java.util.List;
import spring.web.model.Order;
import spring.web.model.User;

public interface OrderDao {
    Order add(Order order);

    List<Order> getOrdersHistory(User user);
}
