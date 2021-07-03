package spring.web.dto.request;

import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
public class StadiumRequestDto {
    @Positive
    private int capacity;
    @Size(max = 200)
    private String description;
}
