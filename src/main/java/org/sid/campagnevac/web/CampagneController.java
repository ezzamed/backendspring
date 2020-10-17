package org.sid.campagnevac.web;

import org.sid.campagnevac.dao.AppUserRepository;
import org.sid.campagnevac.dao.CampagneRepository;
import org.sid.campagnevac.entities.AppUser;
import org.sid.campagnevac.entities.Campagne;
import org.sid.campagnevac.entities.Demographie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.sid.campagnevac.entities.Campagne;
@RestController
public class CampagneController {
    @Autowired
    private CampagneRepository campagneRepository;

    @PutMapping(value="/modifierCampagne")
    public Campagne updateCampagne(@RequestBody Campagne c) {
        //d.setId(id);
        return campagneRepository.save(c);
        //return demographieRepository.save(d);
    }

    @DeleteMapping(value="/supprimerCampagne/{id}")
    public void deleteCampagne(@PathVariable long id){
        campagneRepository.deleteById(id);
    }

   // @DeleteMapping(value="/supprimerCampagne/{id}")
    //public void deleteAppUser(@PathVariable long id){
      //  campagneRepository.deleteById(id);
    //}

}

