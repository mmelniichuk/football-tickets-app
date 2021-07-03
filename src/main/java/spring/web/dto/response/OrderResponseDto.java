package spring.web.dto.response;

import java.util.List;
import lombok.Data;

@Data
public class OrderResponseDto {
    private Long id;
    private List<Long> ticketIds;
    private String orderTime;
    private Long userId;
}
