package de.ningelgen.coronarestricitons.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AreaAdminUserDAO extends JpaRepository<AreaAdminUser, Long> {
    AreaAdminUser findByLoginname(String Loginname);
}
