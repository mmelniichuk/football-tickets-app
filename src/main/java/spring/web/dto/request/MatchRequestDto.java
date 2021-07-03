package spring.web.dto.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import lombok.Data;

@Data
public class MatchRequestDto {
    @Positive
    private Long gameId;
    @Positive
    private Long stadiumId;
    @NotNull
    private String dateTime;
}
