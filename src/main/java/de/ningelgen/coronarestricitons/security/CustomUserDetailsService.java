package de.ningelgen.coronarestricitons.security;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import de.ningelgen.coronarestricitons.user.AreaAdminUser;
import de.ningelgen.coronarestricitons.user.AreaAdminUserDAO;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    // @Override
    // public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    //     // TODO
    //     return new User("foo", "foo", new ArrayList<>());
    // }

    @Autowired
    private AreaAdminUserDAO adminUserDAO;

    @Autowired
    PasswordEncoder pwenc;

    @Override
    public UserDetails loadUserByUsername(String loginname) throws UsernameNotFoundException {
        AreaAdminUser user = adminUserDAO.findByLoginname(loginname);

        if (user == null) {
            throw new UsernameNotFoundException(loginname);
        }

        return org.springframework.security.core.userdetails.User
        .withUsername(loginname)
        .password(pwenc.encode(user.getPassword()))
        .roles("USER")
        .build();
    }
    
}
