package de.ningelgen.coronarestricitons.district;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DistrictDAO extends JpaRepository<District, Long> {
    District findByPostcode(int postcode);
}
