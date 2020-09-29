package org.sid.campagnevac.web;

import lombok.Data;
import org.sid.campagnevac.dao.*;
import org.sid.campagnevac.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CampagneRestContoller{
    @Autowired
    private DemographieRepository demographieRepository;
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
    private VaccinationRepository vaccinationRepository;
    @GetMapping("/allMoughataas")
    public List<Moughataa> getMoughataas(){
        return this.moughataaRepository.findAll();
    }

    @GetMapping("/allVaccinations")
    public List<Vaccination> getVaccinations(){
        return this.vaccinationRepository.findAll();
    }
    @GetMapping("/allWilayas")
    public List<Wilaya> getWilayas(){
        return this.wilayaRepository.findAll();
    }
    @GetMapping("/allRoles")
    public List<AppRole> getAppRoles(){
        return this.appRoleRepository.findAll();
    }
    @GetMapping("/allUsers")
    public List<AppUser> getAppUsers(){
        return this.appUserRepository.findAll();
    }
    @PostMapping("/AjouterDonnesDemographie")
    public Enquete addEnquete(@RequestBody Integer nb011, @RequestBody Integer nb1259, @RequestBody Integer popvisee,@RequestBody Long de) {
        System.out.println(nb011);
        Demographie demographie = demographieRepository.findById(de).orElseGet(null);

        Enquete enquete = new Enquete();
        enquete.setNb011(nb011);
        enquete.setNb1259(nb1259);
        enquete.setPopvisee(popvisee);
        enquete.setDemographie(demographie);

        return enqueteRepository.saveAndFlush(enquete);
    }

    @DeleteMapping(value="/supprimer/{id}")
    public void delete(@PathVariable(name="id") Long id){

        demographieRepository.deleteById(id);
    }
    @PutMapping(value="/modifier/{id}")
    public Demographie update(@PathVariable(name="id") Long id,
                        @RequestBody Demographie d) {
        d.setId(id);
        return demographieRepository.save(d);
    }


    /*@PostMapping("/AjouterDonnesDemographie")
    public Enquete ajoutes;
    public Enquete AjouterDonnesDemographie(@RequestBody EnqueteForm enqueteform){
        enqueteform.getEnquetes().ForEach(idEnquete->{
            Enquete enquete=enqueteRepository.findAllById(idEnquete).get();
            enquete.setNb1259(enqueteform.getNb1259());
            enquete.setNb011(enqueteform.getNb011());
            enquete.setPopvisee(enqueteform.getPopvisee());
            enqueteRepository.save(enquete);
            ajoutes.add(enquete);

        });
        return  ajoutes;
    }
    @Data
    class EnqueteForm{
        private int nb011;
        private int nb1259;
        private int popvisee;
        private Long iddemo;
    }*/

}
