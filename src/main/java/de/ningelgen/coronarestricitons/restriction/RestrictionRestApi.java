package de.ningelgen.coronarestricitons.restriction;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.ningelgen.coronarestricitons.area.AdministrativeAreaService;
import de.ningelgen.coronarestricitons.district.DistrictService;

@RestController
@RequestMapping("/api/restriction")
public class RestrictionRestApi {

    @Autowired
    RestrictionService restrictionService;

    @Autowired
    DistrictService districtService;

    @Autowired
    AdministrativeAreaService areaService;

    @GetMapping("/{postcode}")
    public List<Restriction> restrictionsOfDistrict(@PathVariable int postcode){
        return restrictionService.restrictionsOfDistrict(districtService.findDistrictByPostCode(postcode));
    }

    @GetMapping("/manage")
    public List<Restriction> restrictionsOfArea(Principal user){
        // TODO
        return null;
    }

    @PostMapping("/manage")
    public void updateRestriction(@RequestBody Restriction restriction){
        //TODO
    }

    
}
