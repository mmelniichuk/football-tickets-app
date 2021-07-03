package spring.web.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import spring.web.model.Match;

public interface MatchDao {
    Match add(Match match);

    Optional<Match> get(Long id);

    List<Match> findAvailableMatches(Long gameId, LocalDate date);

    Match update(Match match);

    void delete(Long id);
}
