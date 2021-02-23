package org.sid.campagnevac.web;

import org.sid.campagnevac.dao.*;
import org.sid.campagnevac.entities.*;
import org.sid.campagnevac.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class CampagneRestContoller  {
	
	@Autowired
	private CampagneRepository campagneRepository;
    @Autowired
    private AccountService accountService;
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
    @Autowired
    private VaccinRepository vaccinRepository;
    
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
    
    @GetMapping("/allEnquetes/{id}")
    public Page<Enquete> afficherAllEnquete(
            @RequestParam(name="page",defaultValue ="0") int page,
            @RequestParam(name="size",defaultValue ="1") int size,
            @PathVariable long id){
        return accountService.afficherAllEnquete(page, size,id);
    }
    @GetMapping("/allVaccinations2/{id}")
    public Page<Vaccination> afficherAllvaccis(
            @RequestParam(name="page",defaultValue ="0") int page,
            @RequestParam(name="size",defaultValue ="1") int size,
            @PathVariable long id){
        return accountService.afficherAllvaccinations2(page, size,id);
    }

    @GetMapping("/allUserspage")
    public Page<AppUser> afficherAppUser(
            @RequestParam(name="page",defaultValue ="0") int page,
            @RequestParam(name="size",defaultValue ="1") int size){
        return accountService.afficherAllAppUser(page, size);
    }
    @GetMapping("/allVacs")
    public Page<Vaccination> affichervacs(
            @RequestParam(name="page",defaultValue ="0") int page,
            @RequestParam(name="size",defaultValue ="1") int size)
    {
        return accountService.afficherAllvaccinations(page, size);
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
    @GetMapping("/getenquetecurrent/{id}")
    public Enquete getEnquete(@PathVariable long id) {
        return this.enqueteRepository.getOne(id);
    }
	@GetMapping("/campagne/vaccinations/{id}")
    public List<Vaccination> getAllVaccinsations(@PathVariable long id){
    	return this.vaccinationRepository.getCampagneVaccinations(id);
    }
    @GetMapping("/campagne/vaccins/{id}")
    public List<Vaccin> getAllVaccins(@PathVariable long id){
        return this.vaccinRepository.getCampagneVaccins(id);
    }
    @GetMapping("/vaccin/vaccinations/{id}")
    public List<Vaccination> getAllVaccinationss(@PathVariable long id){
        return this.vaccinationRepository.getVaccinVacctination(id);
    }
	
	@GetMapping("/campagne/moughataas/{id}")
	public List<Moughataa> getCampagneMoughataas(@PathVariable long id){
		return this.moughataaRepository.findByCampagne(id);
	}
   /* @GetMapping("/demographie/enquetes/{id}")
    public List<Enquete> getDemographieEnquetes(@PathVariable long id){
        return this.enqueteRepository.findByDemographie(id);
    }*/
	
	@GetMapping("/campagne/wilayas/{id}")
	public List<Wilaya> getCampagneWilayas(@PathVariable long id){
		return this.wilayaRepository.findByCampagne(id);
	}
	
	@GetMapping("/campagne/moughataa/enquetes/{id_campagne}/{id_moughataa}")
	public List<Enquete> getCampagneMoughataaEnquetes(@PathVariable long id_campagne, @PathVariable long id_moughataa){
		return this.enqueteRepository.getCampagneMoughataaEnquetes(id_moughataa, id_campagne);
	}
	
	@GetMapping("/campagne/enquetes/{id}")
	public List<Enquete> getCampagneEnquetes(@PathVariable long id){
		return this.enqueteRepository.getCampagneEnquetes(id);
	}
    
    //public Enquete addEnquete(@RequestBody Integer nb011, @RequestBody Integer nb1259, @RequestBody Integer popvisee,@RequestBody Demographie de, @RequestBody Moughataa moughataa ) {
    @PostMapping("/AjouterDonnesDemographie")
    public Enquete addEnquete(@RequestBody Enquete enq) {
    	return enqueteRepository.save(enq);
    }

    @PostMapping("/AjouterDemographie")
    public Demographie addDemo(@RequestBody Demographie demo) {
        return demographieRepository.save(demo);
    }
    @PostMapping("/AjouterDonnesparcsv")
    public Enquete addEnquetecsv(@RequestBody Enquete enqu) {

        return enqueteRepository.save(enqu);
    }
    @PostMapping("/AjouterDonnesUtilisateur")
    public AppUser addUser(@RequestBody AppUser user) {

        return appUserRepository.save(user);

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
