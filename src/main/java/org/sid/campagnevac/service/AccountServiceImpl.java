package org.sid.campagnevac.service;

import org.sid.campagnevac.dao.*;
import org.sid.campagnevac.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
    private AppUserRepository appUserRepository;
    private AppRoleRepository appRoleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public AccountServiceImpl(AppUserRepository appUserRepository, AppRoleRepository appRoleRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.appUserRepository = appUserRepository;
        this.appRoleRepository = appRoleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
    @Autowired
    private EnqueteRepository enqueteRepository;
    @Autowired
    private VaccinationRepository vaccinationRepository;
    @Override
    public Page<Enquete> afficherAllEnquete(int page, int size,long id) {
        Pageable pageable= PageRequest.of(page, size);
        return enqueteRepository.affichierEnquete(pageable,id);
    }
    @Override
    public Page<AppUser> afficherAllAppUser(int page, int size) {
        Pageable pageable= PageRequest.of(page, size);
        return appUserRepository.affichierAppUser(pageable);
    }
    @Override
    public Page<Vaccination> afficherAllvaccinations(int page, int size) {
        Pageable pageable= PageRequest.of(page, size);
        return vaccinationRepository.affichierVaccination(pageable);
    }

    @Autowired
    private DemographieRepository demographieRepository;


    @Override
    public AppUser saveUser(String username, String password, String confirmedPassword) {
        AppUser  user=appUserRepository.findByUsername(username);
        if(user!=null) throw new RuntimeException("User already exists");
        if(!password.equals(confirmedPassword)) throw new RuntimeException("Please confirm your password");
        AppUser appUser=new AppUser();
        appUser.setUsername(username);
        appUser.setActived(true);
        appUser.setPassword(bCryptPasswordEncoder.encode(password));
        appUserRepository.save(appUser);
        addRoleToUser(username,"USER");
        return appUser;
    }

    @Override
    public AppRole save(AppRole role) {
        return appRoleRepository.save(role);
    }

    @Override
    public AppUser loadUserByUsername(String username) {
        return appUserRepository.findByUsername(username);
    }

    @Override
    public void addRoleToUser(String username, String rolename) {
        AppUser appUser=appUserRepository.findByUsername(username);
        AppRole appRole=appRoleRepository.findByRoleName(rolename);
        appUser.getRoles().add(appRole);
    }

}
