package spring.web.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import spring.web.dao.AbstractDao;
import spring.web.dao.StadiumDao;
import spring.web.model.Stadium;

@Repository
public class StadiumDaoImpl extends AbstractDao<Stadium> implements StadiumDao {
    public StadiumDaoImpl(SessionFactory factory) {
        super(factory, Stadium.class);
    }
}
