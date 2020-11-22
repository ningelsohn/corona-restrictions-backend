package de.ningelgen.coronarestricitons.restriction;

import java.util.List;

import de.ningelgen.coronarestricitons.area.AdministrativeArea;
import de.ningelgen.coronarestricitons.area.District;

public interface RestrictionService {
    List<Restriction> restrictionsOfDistrict(District district);
    List<Restriction> restrictionsOfArea(AdministrativeArea area);
}
