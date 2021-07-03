package spring.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import spring.web.dto.response.UserResponseDto;
import spring.web.model.User;
import spring.web.service.UserService;
import spring.web.service.mapper.UserResponseMapper;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserResponseMapper userMapper;
    private final UserService userService;

    public UserController(UserService userService, UserResponseMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping("/by-email")
    public UserResponseDto getByEmail(@RequestParam String email) {
        User user = userService.findByEmail(email).get();
        return userMapper.mapToDto(user);
    }
}
