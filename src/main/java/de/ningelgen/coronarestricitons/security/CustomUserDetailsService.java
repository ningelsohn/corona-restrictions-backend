package de.ningelgen.coronarestricitons.security;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import de.ningelgen.coronarestricitons.user.User;
import de.ningelgen.coronarestricitons.user.UserDAO;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    // @Override
    // public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    //     // TODO
    //     return new User("foo", "foo", new ArrayList<>());
    // }

    @Autowired
    private UserDAO adminUserDAO;

    @Autowired
    PasswordEncoder pwenc;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = adminUserDAO.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        
        return UserPrincipal.create(user);

        // return org.springframework.security.core.userdetails.User
        //     .withUsername(username)
        //     .password(pwenc.encode(user.getPassword()))
        //     .roles("USER")
        //     .build();
    }
    
    @Transactional
    public UserDetails loadUserById(Long id) throws Exception {
        User areaUser = adminUserDAO.findById(id).orElseThrow(
            () ->  new Exception("Resouce not Found") // new ResourceNotFoundException("User", "id", "id")
        );

        return UserPrincipal.create(areaUser);
    }
}
