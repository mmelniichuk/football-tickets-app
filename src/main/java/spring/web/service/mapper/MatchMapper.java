package spring.web.service.mapper;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.stereotype.Component;
import spring.web.dto.request.MatchRequestDto;
import spring.web.dto.response.MatchResponseDto;
import spring.web.model.Match;
import spring.web.service.GameService;
import spring.web.service.StadiumService;
import spring.web.util.DateTimePatternUtil;

@Component
public class MatchMapper implements RequestDtoMapper<MatchRequestDto, Match>,
        ResponseDtoMapper<MatchResponseDto, Match> {
    private final DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern(DateTimePatternUtil.DATE_TIME_PATTERN);
    private final StadiumService stadiumService;
    private final GameService gameService;

    public MatchMapper(StadiumService stadiumService, GameService gameService) {
        this.stadiumService = stadiumService;
        this.gameService = gameService;
    }

    @Override
    public Match mapToModel(MatchRequestDto requestDto) {
        Match match = new Match();
        match.setGame(gameService.get(requestDto.getGameId()));
        match.setDateTime(LocalDateTime.parse(requestDto.getDateTime(), formatter));
        match.setStadium(stadiumService.get(requestDto.getStadiumId()));
        return match;
    }

    @Override
    public MatchResponseDto mapToDto(Match match) {
        MatchResponseDto responseDto = new MatchResponseDto();
        responseDto.setId(match.getId());
        responseDto.setGameId(match.getGame().getId());
        responseDto.setDateTime(match.getDateTime().format(formatter));
        responseDto.setStadiumId(match.getStadium().getId());
        return responseDto;
    }
}
