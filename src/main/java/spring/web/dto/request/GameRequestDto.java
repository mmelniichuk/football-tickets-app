package spring.web.dto.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
public class GameRequestDto {
    @NotBlank
    private String title;
    @Size(max = 200)
    private String description;
}
