package org.sid.campagnevac.web;

import lombok.Data;
import org.sid.campagnevac.dao.*;
import org.sid.campagnevac.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class CampagneRestContoller{
	
	@Autowired
	private CampagneRepository campagneRepository;
	
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
    
    @GetMapping("/allDemographies")
    public List<Demographie> getDemographies(){
    	return this.demographieRepository.findAll();
    }
    
    @GetMapping("/wilayaMoughataa/{idWilaya}")
    public List<Moughataa> getWilayaMoughataas(@PathVariable long idWilaya){
        return this.moughataaRepository.findByWilaya(idWilaya);
    }
    
    @GetMapping("/allEnquetes")
    public List<Enquete> getEnquetes(){
    	return this.enqueteRepository.findAll();
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
    
    @GetMapping("/campagne/{id}")
	public Campagne getCampagne(@PathVariable long id) {
		return this.campagneRepository.getOne(id);
	}
	
	@GetMapping("/demographie/{id}")
	public Demographie getDemographie(@PathVariable long id) {
		return this.demographieRepository.getOne(id);
	}
	
	@GetMapping("/campagne/vaccinations/{id}")
    public List<Vaccination> getAllVaccinsations(@PathVariable long id){
    	return this.vaccinationRepository.getCampagneVaccinations(id);
    }
	
	@GetMapping("/campagne/moughataas/{id}")
	public List<Moughataa> getCampagneMoughataas(@PathVariable long id){
		return this.moughataaRepository.findByCampagne(id);
	}
	
	@GetMapping("/campagne/moughataa/enquetes/{id_campagne}/{id_moughataa}")
	public List<Enquete> getCampagneMoughataaEnquetes(@PathVariable long id_campagne, @PathVariable long id_moughataa){
		return this.enqueteRepository.getCampagneMoughataaEnquetes(id_moughataa, id_campagne);
	}
    
    //public Enquete addEnquete(@RequestBody Integer nb011, @RequestBody Integer nb1259, @RequestBody Integer popvisee,@RequestBody Demographie de, @RequestBody Moughataa moughataa ) {
    @PostMapping("/AjouterDonnesDemographie")
    public Enquete addEnquete(@RequestBody Enquete enq) {
        //System.out.println(nb011);
        //Demographie demographie = demographieRepository.findById(de).orElseGet(null);
        //Enquete enquete = new Enquete();
        //enquete.setNb011(nb011);
        //enquete.setNb1259(nb1259);
        //enquete.setPopvisee(popvisee);
        //enquete.setDemographie(demographie);
        //enquete.setDemographie(de);
        //enquete.setMoughataa(moughataa);
        //return enqueteRepository.saveAndFlush(enquete);
    	//return enqueteRepository.saveAndFlush(enq);
    	return enqueteRepository.save(enq);
    }

    /*
    @PostMapping("/AjouterDonnesDemographie")
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
    }
    */

}
