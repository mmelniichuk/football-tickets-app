package spring.web.controller;

import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.web.dto.request.GameRequestDto;
import spring.web.dto.response.GameResponseDto;
import spring.web.model.Game;
import spring.web.service.GameService;
import spring.web.service.mapper.GameMapper;

@Log
@RestController
@RequestMapping("/games")
public class GameController {
    private final GameService gameService;
    private final GameMapper gameMapper;

    public GameController(GameService gameService, GameMapper gameMapper) {
        this.gameService = gameService;
        this.gameMapper = gameMapper;
    }

    @PostMapping
    public GameResponseDto add(@RequestBody @Valid GameRequestDto requestDto) {
        Game game = gameService.add(gameMapper.mapToModel(requestDto));
        log.info("new entity:game was added to db");
        return gameMapper.mapToDto(game);
    }

    @GetMapping
    public List<GameResponseDto> getAll() {
        log.info("all games was fetched from db");
        return gameService.getAll()
                .stream()
                .map(gameMapper::mapToDto)
                .collect(Collectors.toList());
    }
}
