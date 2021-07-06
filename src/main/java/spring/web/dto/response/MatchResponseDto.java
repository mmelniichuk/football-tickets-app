package spring.web.dto.response;

import lombok.Data;

@Data
public class MatchResponseDto {
    private Long id;
    private Long gameId;
    private Long stadiumId;
    private String dateTime;
}
