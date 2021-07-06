package spring.web.service;

import java.util.List;
import spring.web.model.Order;
import spring.web.model.ShoppingCart;
import spring.web.model.User;

public interface OrderService {
    Order completeOrder(ShoppingCart shoppingCart);

    List<Order> getOrdersHistory(User user);
}
