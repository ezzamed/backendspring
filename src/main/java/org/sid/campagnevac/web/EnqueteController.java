package org.sid.campagnevac.web;

import org.sid.campagnevac.dao.EnqueteRepository;
import org.sid.campagnevac.entities.Demographie;
import org.sid.campagnevac.entities.Enquete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class EnqueteController {
    @Autowired
    private EnqueteRepository enqueteRepository;

    @PutMapping(value="/modifierEnquete")
    public Enquete updateEnquete(@RequestBody Enquete e) {
        //d.setId(id);
        return enqueteRepository.save(e);
        //return demographieRepository.save(d);
    }

    @DeleteMapping(value="/supprimerEnquete/{id}")
    public void deleteDemographie(@PathVariable long id){
        enqueteRepository.deleteById(id);
    }

}

