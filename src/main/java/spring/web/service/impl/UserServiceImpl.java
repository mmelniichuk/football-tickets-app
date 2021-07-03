package spring.web.service.impl;

import java.util.Optional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import spring.web.dao.UserDao;
import spring.web.lib.exception.DataProcessingException;
import spring.web.model.User;
import spring.web.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    private final PasswordEncoder encoder;
    private final UserDao userDao;

    public UserServiceImpl(PasswordEncoder encoder, UserDao userDao) {
        this.encoder = encoder;
        this.userDao = userDao;
    }

    @Override
    public User add(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        return userDao.add(user);
    }

    @Override
    public User get(Long id) {
        return userDao.get(id).orElseThrow(
                () -> new DataProcessingException("User with id: " + id + " not found"));
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userDao.findByEmail(email);
    }
}
