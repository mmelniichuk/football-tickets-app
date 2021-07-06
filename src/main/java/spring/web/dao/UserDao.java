package spring.web.dao;

import java.util.Optional;
import spring.web.model.User;

public interface UserDao {
    User add(User user);

    Optional<User> get(Long id);

    Optional<User> findByEmail(String email);
}
