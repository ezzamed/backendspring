package org.sid.campagnevac.web;

import com.sun.org.apache.xerces.internal.xs.StringList;
import org.sid.campagnevac.dao.AppUserRepository;
import org.sid.campagnevac.entities.AppUser;
import org.sid.campagnevac.entities.Demographie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.*;


@RestController
public class MyuserController {
    @Autowired
    private AppUserRepository appUserRepository;
    @PutMapping(value="/modifierUser")
    public AppUser updateAppUser(@RequestBody AppUser a) {
        //d.setId(id);
        return appUserRepository.save(a);
        //return demographieRepository.save(d);
    }

    @DeleteMapping(value="/supprimerUser/{id}")
    public void deleteAppUser(@PathVariable long id){
        appUserRepository.deleteById(id);
    }

}
