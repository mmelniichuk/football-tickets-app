package spring.web.security;

import spring.web.model.User;

public interface AuthenticationService {
    User register(String email, String password);
}
