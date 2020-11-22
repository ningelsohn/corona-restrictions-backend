package de.ningelgen.coronarestricitons.restriction;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.ningelgen.coronarestricitons.area.DistrictService;

@RestController
@RequestMapping("/api/restriction")
public class RestrictionRestApi {

    @Autowired
    RestrictionService restrictionService;

    @Autowired
    DistrictService districtService;

    @GetMapping("/{postcode}")
    public List<Restriction> restrictionsOfDistrict(@PathVariable int postcode){
        return restrictionService.restrictionsOfDistrict(districtService.findDistrictByPostCode(postcode));
    }

    
}
