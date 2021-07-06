package spring.web.service.mapper;

import org.springframework.stereotype.Component;
import spring.web.dto.response.UserResponseDto;
import spring.web.model.User;

@Component
public class UserResponseMapper implements ResponseDtoMapper<UserResponseDto, User> {
    @Override
    public UserResponseDto mapToDto(User user) {
        UserResponseDto responseDto = new UserResponseDto();
        responseDto.setId(user.getId());
        responseDto.setEmail(user.getEmail());
        return responseDto;
    }
}
