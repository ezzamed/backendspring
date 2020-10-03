package org.sid.campagnevac.web;

import org.sid.campagnevac.dao.VaccinRepository;
import org.sid.campagnevac.entities.Moughataa;
import org.sid.campagnevac.entities.Vaccin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VaccinController {
    @Autowired
    private VaccinRepository vaccinRepository;
    @GetMapping("/allVaccins")
    public List<Vaccin> getVaccins(){
        return this.vaccinRepository.findAll();
    }

}
