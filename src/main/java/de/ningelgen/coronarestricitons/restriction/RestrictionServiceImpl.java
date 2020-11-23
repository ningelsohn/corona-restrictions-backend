package de.ningelgen.coronarestricitons.restriction;

import java.util.List;

import org.springframework.stereotype.Service;

import de.ningelgen.coronarestricitons.area.AdministrativeArea;
import de.ningelgen.coronarestricitons.district.District;

@Service
public class RestrictionServiceImpl implements RestrictionService {

    @Override
    public List<Restriction> restrictionsOfDistrict(District district) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Restriction> restrictionsOfArea(AdministrativeArea area) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
