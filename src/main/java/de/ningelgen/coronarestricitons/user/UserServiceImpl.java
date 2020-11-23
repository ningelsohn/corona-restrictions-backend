package de.ningelgen.coronarestricitons.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDAO userDAO;

    @Override
    public boolean checkLogin(String username, String password) {
        return findUser(username).getPassword().equals(password);
    }

    @Override
    public User registerUser(User newUser) {
        return userDAO.save(newUser);
    }

    @Override
    public User findUser(String username) {
        return userDAO.findByUsername(username);
    }

}
