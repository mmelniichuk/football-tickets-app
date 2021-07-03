package spring.web.service.mapper;

import java.util.stream.Collectors;
import org.springframework.stereotype.Component;
import spring.web.dto.response.ShoppingCartResponseDto;
import spring.web.model.ShoppingCart;
import spring.web.model.Ticket;

@Component
public class ShoppingCartResponseMapper implements
        ResponseDtoMapper<ShoppingCartResponseDto, ShoppingCart> {

    @Override
    public ShoppingCartResponseDto mapToDto(ShoppingCart shoppingCart) {
        ShoppingCartResponseDto responseDto = new ShoppingCartResponseDto();
        responseDto.setUserId(shoppingCart.getUser().getId());
        responseDto.setTicketIds(shoppingCart.getTickets()
                .stream()
                .map(Ticket::getId)
                .collect(Collectors.toList()));
        return responseDto;
    }
}
