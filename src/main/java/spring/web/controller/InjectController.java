package spring.web.controller;

import java.util.Set;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.web.model.Role;
import spring.web.model.RoleName;
import spring.web.model.User;
import spring.web.security.AuthenticationService;
import spring.web.service.UserService;
import spring.web.service.impl.RoleServiceImpl;

@Log
@RestController
@RequestMapping("/inject")
public class InjectController {
    private RoleServiceImpl roleService;
    private UserService userService;
    private AuthenticationService authenticationService;

    public InjectController(RoleServiceImpl roleService,
                            UserService userService,
                            AuthenticationService authenticationService) {
        this.roleService = roleService;
        this.userService = userService;
        this.authenticationService = authenticationService;
    }

    @GetMapping
    public String injectData() {
        Role adminRole = new Role();
        adminRole.setRoleName(RoleName.ADMIN);
        roleService.add(adminRole);

        Role userRole = new Role();
        userRole.setRoleName(RoleName.USER);
        roleService.add(userRole);

        authenticationService.register("mariia@gmail.com", "12345678");

        User user = new User();
        user.setEmail("anna_admin@i.ua");
        user.setPassword("admin123");
        user.setRoles(Set.of(roleService.getRoleByName(RoleName.ADMIN)));
        userService.add(user);
        log.info("Data was successfully inject!");
        return "Data was successfully inject!";
    }
}
