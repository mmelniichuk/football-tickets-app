package spring.web.service;

import java.time.LocalDate;
import java.util.List;
import spring.web.model.Match;

public interface MatchService {
    List<Match> findAvailableMatches(Long gameId, LocalDate date);

    Match add(Match match);

    Match get(Long id);

    Match update(Match match);

    void delete(Long id);
}
