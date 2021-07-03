package spring.web.service;

import spring.web.model.Match;
import spring.web.model.ShoppingCart;
import spring.web.model.User;

public interface ShoppingCartService {
    void addMatch(Match match, User user);

    ShoppingCart getByUser(User user);

    void registerNewShoppingCart(User user);

    void clear(ShoppingCart shoppingCart);
}
