package org.sid.campagnevac.service;

import org.sid.campagnevac.dao.*;
import org.sid.campagnevac.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class CampagneInitService implements ICampagneInitService {
    @Autowired
    private DemographieRepository demographieRepository;
    @Autowired
    private WilayaRepository wilayaRepository;
    @Autowired
    private MoughataaRepository moughataaRepository;
    @Autowired
    private EnqueteRepository enqueteRepository;
    @Autowired
    private VaccinRepository vaccinRepository;

    @Autowired
    private VaccinationRepository vaccinationRepository;
    @Autowired
    private CampagneRepository campagneRepository;

    public void initDemographie() {
        Stream.of("Demo1", "Demo2", "Demo3","Demo4").forEach(namedemographie -> {
            Demographie demographie = new Demographie();
            demographie.setName(namedemographie);
            demographieRepository.save(demographie);
        });
    }

    @Override
    public void initWilaya() {

        Stream.of("Adrar", "Assaba", "Brakna").forEach(namewilaya -> {
            Wilaya wilaya = new Wilaya();
            wilaya.setName(namewilaya);
            wilayaRepository.save(wilaya);

        });

    }

    @Override
    public void initMoughataa() {
        wilayaRepository.findAll().forEach(w -> {
            Stream.of("Atar", "Aïn Ehel Taya", "Tawaz", "Choum").forEach(n -> {
                Moughataa moughataa = new Moughataa();
                moughataa.setMoughataaname(n);
                moughataa.setWilaya(w);
                moughataaRepository.save(moughataa);
            });

        });

    }

    @Override
    public void initEnquete() {
                /*wilayaRepository.findAll().forEach(w -> {
                demographieRepository.findAll().forEach(d -> {
                    Stream.of("Enquete1", "Enquete2", "Enquete3", "Enquete4").forEach(en -> {
                        Enquete enquete = new Enquete();
                        enquete.setPop_visee(en);
                        enquete.setDemogarphie(d);
                        enqueteRepository.save(enquete);

                    });

                });
                });*/

    }

   @Override
    public void initCampagne() {

       demographieRepository.findAll().forEach(d -> {
           Stream.of("c1", "c2","c3").forEach(c -> {
               Campagne campagne = new Campagne();
               campagne.setName(c);
               campagne.setDemographie(d);
              campagneRepository.save(campagne);
           });

       });

       }




    @Override
    public void initVaccination() {
       campagneRepository.findAll().forEach(w -> {
            Stream.of(5,4).forEach(n -> {
                Vaccination vaccination = new Vaccination();
                vaccination.setCampagne(w);
                vaccinationRepository.save(vaccination);
            });

        });

    }

	@Override
	public void initVaccin() {
		// TODO Auto-generated method stub
		campagneRepository.findAll().forEach(w -> {
            Stream.of(5,4).forEach(n -> {
                Vaccin vaccin = new Vaccin();
                vaccin.setNom_vaccin("Vaccin num"+w.getId());
                vaccin.setCampagne(w);
                vaccinRepository.save(vaccin);
            });

        });
	}
}