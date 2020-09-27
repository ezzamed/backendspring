package org.sid.campagnevac;

import org.sid.campagnevac.entities.AppRole;
import org.sid.campagnevac.entities.Campagne;
import org.sid.campagnevac.entities.Demographie;
import org.sid.campagnevac.entities.Enquete;
import org.sid.campagnevac.service.AccountService;
import org.sid.campagnevac.service.ICampagneInitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.stream.Stream;

@SpringBootApplication
public class CampagneVacApplication implements CommandLineRunner {
	@Autowired
	private ICampagneInitService iCampagneInitService;
	@Autowired
	private RepositoryRestConfiguration restConfiguration;

	public static void main(String[] args) {

		SpringApplication.run(CampagneVacApplication.class, args);
	}
	
	
	@Bean
	CommandLineRunner start(AccountService accountService){
		return args->{
			accountService.save(new AppRole(null,"USER"));
			accountService.save(new AppRole(null,"ADMIN"));
			Stream.of("user1","user2","user3","admin").forEach(un->{
				accountService.saveUser(un,"1234","1234");
			});
			accountService.addRoleToUser("admin","ADMIN");
		};
	}
	
	@Bean
	BCryptPasswordEncoder getBCPE(){
		return new BCryptPasswordEncoder();
	}



	
	@Override
	public void run(String... args) throws Exception {
		restConfiguration.exposeIdsFor(Demographie.class, Enquete.class, Campagne.class);
		iCampagneInitService.initDemographie();
		iCampagneInitService.initWilaya();
		iCampagneInitService.initMoughataa();
		iCampagneInitService.initEnquete();
		iCampagneInitService.initCampagne();
		iCampagneInitService.initVaccination();
		iCampagneInitService.initVaccin();

	}


}