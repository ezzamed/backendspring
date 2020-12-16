package org.sid.campagnevac.web;

import org.sid.campagnevac.dao.AppUserRepository;
import org.sid.campagnevac.dao.EnqueteRepository;
import org.sid.campagnevac.entities.AppUser;
import org.sid.campagnevac.entities.Demographie;
import org.sid.campagnevac.entities.Enquete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class EnqueteController {
    @Autowired
    private EnqueteRepository enqueteRepository;
    @Autowired
    private AppUserRepository appUserRepository;

    @PutMapping(value="/modifierEnquete")
    public Enquete updateEnquete(@RequestBody Enquete e) {
        //d.setId(id);
        return enqueteRepository.save(e);
        //return demographieRepository.save(d);
    }
    @GetMapping(value="/enquete/getOne/{id}")
    public Enquete getOne(@PathVariable long id) {
        return this.enqueteRepository.getOne(id);
    }
    @GetMapping(value="/user/getOne/{id}")
    public AppUser getOneuser(@PathVariable long id) {
        return this.appUserRepository.getOne(id);
    }

    @DeleteMapping(value="/supprimerEnquete/{id}")
    public void deleteDemographie(@PathVariable long id){
        enqueteRepository.deleteById(id);
    }
    
}

