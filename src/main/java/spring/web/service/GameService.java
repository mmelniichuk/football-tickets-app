package spring.web.service;

import java.util.List;
import spring.web.model.Game;

public interface GameService {
    Game add(Game game);

    Game get(Long id);

    List<Game> getAll();
}
