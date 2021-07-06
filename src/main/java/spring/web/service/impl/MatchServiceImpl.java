package spring.web.service.impl;

import java.time.LocalDate;
import java.util.List;
import org.springframework.stereotype.Service;
import spring.web.dao.MatchDao;
import spring.web.lib.exception.DataProcessingException;
import spring.web.model.Match;
import spring.web.service.MatchService;

@Service
public class MatchServiceImpl implements MatchService {
    private final MatchDao matchDao;

    public MatchServiceImpl(MatchDao matchDao) {
        this.matchDao = matchDao;
    }

    @Override
    public List<Match> findAvailableMatches(Long gameId, LocalDate date) {
        return matchDao.findAvailableMatches(gameId, date);
    }

    @Override
    public Match add(Match match) {
        return matchDao.add(match);
    }

    @Override
    public Match get(Long id) {
        return matchDao.get(id).orElseThrow(
                () -> new DataProcessingException("Match by id: " + id + " not found"));
    }

    @Override
    public Match update(Match match) {
        return matchDao.update(match);
    }

    @Override
    public void delete(Long id) {
        matchDao.delete(id);
    }
}
