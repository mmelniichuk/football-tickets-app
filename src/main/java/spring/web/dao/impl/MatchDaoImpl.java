package spring.web.dao.impl;

import java.time.LocalDate;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import spring.web.dao.AbstractDao;
import spring.web.dao.MatchDao;
import spring.web.lib.exception.DataProcessingException;
import spring.web.model.Match;

@Repository
public class MatchDaoImpl extends AbstractDao<Match> implements MatchDao {
    public MatchDaoImpl(SessionFactory factory) {
        super(factory, Match.class);
    }

    @Override
    public List<Match> findAvailableMatches(Long gameId, LocalDate date) {
        try (Session session = factory.openSession()) {
            return session.createQuery("FROM Match WHERE id = :id "
                    + "AND DATE_FORMAT(dateTime, '%Y-%m-%d') = :date", Match.class)
                    .setParameter("id", gameId)
                    .setParameter("date", date.toString())
                    .getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Match for game with id: "
                    + gameId + " and date " + date + " not found", e);
        }
    }
}
