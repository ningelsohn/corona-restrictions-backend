package de.ningelgen.coronarestricitons.area;

import org.springframework.data.jpa.repository.JpaRepository;

import de.ningelgen.coronarestricitons.user.User;

public interface AdministrativeAreaDAO extends JpaRepository<AdministrativeArea, Long> {
    AdministrativeArea findByAdmin(User user);
}
