package org.sid.campagnevac.web;

import java.util.List;
import org.sid.campagnevac.dao.AppUserRepository;
import org.sid.campagnevac.dao.CampagneRepository;
import org.sid.campagnevac.dao.MoughataaRepository;
import org.sid.campagnevac.dao.VaccinRepository;
import org.sid.campagnevac.dao.VaccinationRepository;
import org.sid.campagnevac.entities.AppUser;
import org.sid.campagnevac.entities.Campagne;
import org.sid.campagnevac.entities.Moughataa;
import org.sid.campagnevac.entities.Vaccin;
import org.sid.campagnevac.entities.Vaccination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
public class AgentRestController {
	
	@Autowired
	AppUserRepository appUserRepository;
	@Autowired
	VaccinRepository vaccinRepository;
	@Autowired
	MoughataaRepository moughataaRepository;
	@Autowired
	CampagneRepository campagneRepository;
	@Autowired
	VaccinationRepository vaccinationRepository;

	@GetMapping(value="/agent/authentification/{login}/{password}")
	public AppUser authentification(@PathVariable String login, @PathVariable String password) {
		AppUser user = new AppUser();
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		List<AppUser> users = appUserRepository.findAll();
		int i=0;
		for(i=0;i<users.size();i++) {
			if(users.get(i).getUsername().equals(login)&&bCryptPasswordEncoder.matches(password, users.get(i).getPassword())){
				user = users.get(i);
				break;
			}
		}
		return user;
		//System.out.println(bCryptPasswordEncoder.encode(password));
		
		//return this.appUserRepository.authentification(login, /*bCryptPasswordEncoder.encode(password)*/ password);
	}
	
	@GetMapping("/agent/allVaccins")
	public List<Vaccin> getVaccins(){
		return this.vaccinRepository.findAll();        
	}
	
	@GetMapping("/agent/allMoughataas")
	public List<Moughataa> getMoughataas(){
		return this.moughataaRepository.findAll();
	}
	
	@GetMapping("/agent/allCampagnes")
	public List<Campagne> getCampagnes(){
		return this.campagneRepository.findAll();
	}
	
	@PostMapping(value="/agent/addVaccination")
	public Vaccination addVaccination(@RequestBody Vaccination vaccination) {
		vaccination.setUser(appUserRepository.findById(vaccination.getUser().getId()).get());
		return this.vaccinationRepository.save(vaccination);
	}
	
	

}
