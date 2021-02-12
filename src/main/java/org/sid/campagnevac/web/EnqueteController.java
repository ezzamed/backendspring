package org.sid.campagnevac.web;

import org.sid.campagnevac.dao.*;
import org.sid.campagnevac.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class EnqueteController {
    @Autowired
    private EnqueteRepository enqueteRepository;
    @Autowired
    private AppUserRepository appUserRepository;
    @Autowired
    private AppRoleRepository appRoleRepository;
    @Autowired
    private MoughataaRepository moughataaRepository;
    @Autowired
    private WilayaRepository wilayaRepository;
    @Autowired
    private VaccinRepository vaccinRepository;

    @PutMapping(value="/modifierEnquete")
    public Enquete updateEnquete(@RequestBody Enquete e) {
        //d.setId(id);
        return enqueteRepository.save(e);
        //return demographieRepository.save(d);
    }
    @PutMapping(value="/modifierRole")
    public AppRole updateRole(@RequestBody AppRole a) {
        //d.setId(id);
        return appRoleRepository.save(a);
        //return demographieRepository.save(d);
    }
    @PutMapping(value="/modifierWilaya")
    public Wilaya updatewilaya(@RequestBody Wilaya w) {
        //d.setId(id);
        return wilayaRepository.save(w);
        //return demographieRepository.save(d);
    }
    @GetMapping(value="/enquete/getOne/{id}")
    public Enquete getOne(@PathVariable long id) {
        return this.enqueteRepository.getOne(id);
    }
    @GetMapping(value="/wilaya/getOne/{id}")
    public Wilaya getOnewilaya(@PathVariable long id) {
        return this.wilayaRepository.getOne(id);
    }
    @GetMapping(value="/moughataa/getOne/{id}")
    public Moughataa getOnemoughataa(@PathVariable long id) {
        return this.moughataaRepository.getOne(id);}
    @GetMapping(value="/user/getOne/{id}")
    public AppUser getOneuser(@PathVariable long id) {
        return this.appUserRepository.getOne(id);
    }
    @GetMapping(value="/appRole/getOne/{id}")
    public AppRole getOnerole(@PathVariable long id) {
        return this.appRoleRepository.getOne(id);
    }

    @DeleteMapping(value="/supprimerEnquete/{id}")
    public void deleteDemographie(@PathVariable long id){
        enqueteRepository.deleteById(id);
    }
    @DeleteMapping(value="/supprimermoughataa/{id}")
    public void deleteMoughataa(@PathVariable long id){
        moughataaRepository.deleteById(id);
    }
    @DeleteMapping(value="/supprimerVaccin/{id}")
    public void deleteVaccin(@PathVariable long id){
        vaccinRepository.deleteById(id);
    }

}

