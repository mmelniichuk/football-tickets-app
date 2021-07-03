package spring.web.service.impl;

import java.util.ArrayList;
import org.springframework.stereotype.Service;
import spring.web.dao.ShoppingCartDao;
import spring.web.dao.TicketDao;
import spring.web.model.Match;
import spring.web.model.ShoppingCart;
import spring.web.model.Ticket;
import spring.web.model.User;
import spring.web.service.ShoppingCartService;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    private final ShoppingCartDao shoppingCartDao;
    private final TicketDao ticketDao;

    public ShoppingCartServiceImpl(ShoppingCartDao shoppingCartDao, TicketDao ticketDao) {
        this.shoppingCartDao = shoppingCartDao;
        this.ticketDao = ticketDao;
    }

    @Override
    public void addMatch(Match match, User user) {
        Ticket ticket = new Ticket();
        ticket.setMatch(match);
        ticket.setUser(user);

        ShoppingCart shoppingCart = shoppingCartDao.getByUser(user);
        shoppingCart.getTickets().add(ticketDao.add(ticket));
        shoppingCartDao.update(shoppingCart);
    }

    @Override
    public ShoppingCart getByUser(User user) {
        return shoppingCartDao.getByUser(user);
    }

    @Override
    public void registerNewShoppingCart(User user) {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setUser(user);
        shoppingCartDao.add(shoppingCart);
    }

    @Override
    public void clear(ShoppingCart shoppingCart) {
        shoppingCart.setTickets(new ArrayList<>());
        shoppingCartDao.update(shoppingCart);
    }
}
