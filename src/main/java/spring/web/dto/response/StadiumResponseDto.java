package spring.web.dto.response;

import lombok.Data;

@Data
public class StadiumResponseDto {
    private Long id;
    private int capacity;
    private String description;
}
