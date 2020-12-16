package org.sid.campagnevac.service;

import org.sid.campagnevac.dao.EnqueteRepository;
import org.sid.campagnevac.entities.AppRole;
import org.sid.campagnevac.entities.AppUser;
import org.sid.campagnevac.entities.Demographie;
import org.sid.campagnevac.entities.Enquete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

public interface AccountService {


    public AppUser saveUser(String username,String password,String confirmedPassword);
    public AppRole save(AppRole role);
    public AppUser loadUserByUsername(String username);
    public void addRoleToUser(String username,String rolename);
    public Page<Enquete> afficherAllEnquete(int page, int size,long id);
    public Page<AppUser> afficherAllAppUser(int page, int size);

    
}