package spring.web.controller;

import javax.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import spring.web.dto.request.UserRequestDto;
import spring.web.dto.response.UserResponseDto;
import spring.web.model.User;
import spring.web.security.AuthenticationService;
import spring.web.service.mapper.UserResponseMapper;

@RestController
public class AuthenticationController {
    private final AuthenticationService authService;
    private final UserResponseMapper userMapper;

    public AuthenticationController(AuthenticationService authService,
                                    UserResponseMapper userMapper) {
        this.authService = authService;
        this.userMapper = userMapper;
    }

    @PostMapping("/register")
    public UserResponseDto register(@RequestBody @Valid UserRequestDto requestDto) {
        User user = authService.register(requestDto.getEmail(), requestDto.getPassword());
        return userMapper.mapToDto(user);
    }
}
