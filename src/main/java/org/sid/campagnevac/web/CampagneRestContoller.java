package org.sid.campagnevac.web;

import lombok.Data;
import org.sid.campagnevac.dao.DemographieRepository;
import org.sid.campagnevac.dao.EnqueteRepository;
import org.sid.campagnevac.entities.Demographie;
import org.sid.campagnevac.entities.Enquete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CampagneRestContoller{
    @Autowired
    private DemographieRepository demographieRepository;
    @Autowired
    private EnqueteRepository enqueteRepository;
    @PostMapping("/AjouterDonnesDemographie")
    public Enquete addEnquete(Integer nb011, Integer nb1259, Integer popvisee,Long de) {
        System.out.println(nb011);
        Demographie demographie = demographieRepository.findById(de).orElseGet(null);

        Enquete enquete = new Enquete();
        enquete.setNb011(nb011);
        enquete.setNb1259(nb1259);
        enquete.setPopvisee(popvisee);
        enquete.setDemographie(demographie);

        return enqueteRepository.saveAndFlush(enquete);
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
