package spring.web.controller;

import javax.validation.constraints.Min;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import spring.web.dto.response.ShoppingCartResponseDto;
import spring.web.model.Match;
import spring.web.model.User;
import spring.web.service.MatchService;
import spring.web.service.ShoppingCartService;
import spring.web.service.UserService;
import spring.web.service.mapper.ShoppingCartResponseMapper;

@RestController
@RequestMapping("/shopping-carts")
public class ShoppingCartController {
    private final ShoppingCartResponseMapper shoppingCartMapper;
    private final ShoppingCartService shoppingCartService;
    private final MatchService matchService;
    private final UserService userService;

    public ShoppingCartController(ShoppingCartResponseMapper shoppingCartMapper,
                                  ShoppingCartService shoppingCartService,
                                  MatchService matchService,
                                  UserService userService) {
        this.shoppingCartMapper = shoppingCartMapper;
        this.shoppingCartService = shoppingCartService;
        this.matchService = matchService;
        this.userService = userService;
    }

    @PostMapping("/matches")
    public void addToCart(Authentication auth, @RequestParam @Min(1) Long id) {
        UserDetails details = (UserDetails) auth.getPrincipal();
        User user = userService.findByEmail(details.getUsername()).get();
        Match match = matchService.get(id);
        shoppingCartService.addMatch(match, user);
    }

    @GetMapping("/by-user")
    public ShoppingCartResponseDto getByUser(Authentication auth) {
        UserDetails details = (UserDetails) auth.getPrincipal();
        User user = userService.findByEmail(details.getUsername()).get();
        return shoppingCartMapper.mapToDto(shoppingCartService.getByUser(user));
    }
}
