package spring.web.dto.response;

import lombok.Data;

@Data
public class GameResponseDto {
    private Long id;
    private String title;
    private String description;
}
