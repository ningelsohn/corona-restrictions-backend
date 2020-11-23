package de.ningelgen.coronarestricitons.area;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.ningelgen.coronarestricitons.user.User;

@Service
public class AdministrativeAreaServiceImpl implements AdministrativeAreaService {

    @Autowired
    AdministrativeAreaDAO administrativeAreaDAO;

    @Override
    public AdministrativeArea getArea(User user) {
        return administrativeAreaDAO.findByAdmin(user);
    }
    
}
