package spring.web.dao;

import java.util.List;
import java.util.Optional;
import spring.web.model.Game;

public interface GameDao {
    Game add(Game game);

    Optional<Game> get(Long id);

    List<Game> getAll();
}
