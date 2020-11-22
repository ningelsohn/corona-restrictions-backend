package de.ningelgen.coronarestricitons.restriction;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RestrictionDAO extends JpaRepository<Restriction, String>{
    List<Restriction> findByAreaId(int id);
}
