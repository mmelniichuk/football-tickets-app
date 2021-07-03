package spring.web.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import spring.web.dao.AbstractDao;
import spring.web.dao.TicketDao;
import spring.web.model.Ticket;

@Repository
public class TicketDaoImpl extends AbstractDao<Ticket> implements TicketDao {
    public TicketDaoImpl(SessionFactory factory) {
        super(factory, Ticket.class);
    }
}
