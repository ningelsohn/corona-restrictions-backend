package de.ningelgen.coronarestricitons.user;

public interface UserService {
    boolean checkLogin(String username, String password);
    // String getPassword(String username); // TODO: unnecessary?
    User registerUser(User newUser);
    User findUser(String username);
}
