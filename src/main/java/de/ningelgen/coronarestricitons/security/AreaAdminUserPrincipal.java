package de.ningelgen.coronarestricitons.security;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import de.ningelgen.coronarestricitons.user.AreaAdminUser;

public class AreaAdminUserPrincipal implements UserDetails {

    private Long id;

    private String username;

    // @JsonIgnore
    private String email;

    // @JsonIgnore
    private String password;

    private Collection<? extends GrantedAuthority> authorities;

    public AreaAdminUserPrincipal(Long id, String username, String email, String password /*, Collection<? extends GrantedAuthority> authorities */) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        // this.authorities = authorities;
    }

    public static AreaAdminUserPrincipal create(AreaAdminUser areaUser) {
        // List<GrantedAuthority> authorities = areaUser.getRoles().stream().map(role -> 
        //     new SimpleGrantedAuthority(role.getName().name())
        // ).collect(Collectors.toList());

        return new AreaAdminUserPrincipal(
            areaUser.getId(), 
            areaUser.getUsername(), 
            areaUser.getEmail(), 
            areaUser.getPassword() //, 
            //authorities
        );
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // TODO Auto-generated method stub
        return null;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isEnabled() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AreaAdminUserPrincipal that = (AreaAdminUserPrincipal) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    
}
