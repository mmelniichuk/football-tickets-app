package spring.web.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import spring.web.dao.AbstractDao;
import spring.web.dao.GameDao;
import spring.web.model.Game;

@Repository
public class GameDaoImpl extends AbstractDao<Game> implements GameDao {
    public GameDaoImpl(SessionFactory factory) {
        super(factory, Game.class);
    }
}
