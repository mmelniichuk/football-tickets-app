package spring.web.service.mapper;

import org.springframework.stereotype.Component;
import spring.web.dto.request.GameRequestDto;
import spring.web.dto.response.GameResponseDto;
import spring.web.model.Game;

@Component
public class GameMapper implements RequestDtoMapper<GameRequestDto, Game>,
        ResponseDtoMapper<GameResponseDto, Game> {
    @Override
    public Game mapToModel(GameRequestDto requestDto) {
        Game game = new Game();
        game.setTitle(requestDto.getTitle());
        game.setDescription(requestDto.getDescription());
        return game;
    }

    @Override
    public GameResponseDto mapToDto(Game game) {
        GameResponseDto responseDto = new GameResponseDto();
        responseDto.setId(game.getId());
        responseDto.setTitle(game.getTitle());
        responseDto.setDescription(game.getDescription());
        return responseDto;
    }
}
