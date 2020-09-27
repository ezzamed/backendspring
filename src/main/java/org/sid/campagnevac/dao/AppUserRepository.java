package org.sid.campagnevac.dao;

import org.sid.campagnevac.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface AppUserRepository extends JpaRepository<AppUser,Long> {
    public AppUser findByUsername(String username);
    
    @Query(
    		value="SELECT * FROM AppUser WHERE username = ?1 AND password = ?2",
    		nativeQuery = true
    		)
    public AppUser authentification(String username, String password);
}
