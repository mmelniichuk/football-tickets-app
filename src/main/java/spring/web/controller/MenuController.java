package spring.web.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MenuController {
    @GetMapping("/index")
    public String index(Model model, Authentication authentication) {
        String userEmail = authentication.getName();
        model.addAttribute("name", userEmail);
        return "index";
    }

    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }
}
