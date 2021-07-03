package spring.web.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import spring.web.dao.GameDao;
import spring.web.lib.exception.DataProcessingException;
import spring.web.model.Game;
import spring.web.service.GameService;

@Service
public class GameServiceImpl implements GameService {
    private final GameDao gameDao;

    public GameServiceImpl(GameDao gameDao) {
        this.gameDao = gameDao;
    }

    @Override
    public Game add(Game game) {
        return gameDao.add(game);
    }

    @Override
    public Game get(Long id) {
        return gameDao.get(id).orElseThrow(
                () -> new DataProcessingException("Can't get game by id: " + id));
    }

    @Override
    public List<Game> getAll() {
        return gameDao.getAll();
    }
}
