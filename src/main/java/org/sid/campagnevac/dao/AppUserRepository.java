package org.sid.campagnevac.dao;

import org.sid.campagnevac.entities.AppUser;
import org.sid.campagnevac.entities.Demographie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource
public interface AppUserRepository extends JpaRepository<AppUser,Long> {
    public AppUser findByUsername(String username);

    @RestResource(path = "/Bynameuser")
    public Page<AppUser> findByusernameContains(@Param("mc") String nm, Pageable pageable);
    
    @Query(
    		value="SELECT * FROM AppUser WHERE username = ?1 AND password = ?2",
    		nativeQuery = true
    		)
    public AppUser authentification(String username, String password);
    @Query(value="select a from AppUser a")
    public Page<AppUser> affichierAppUser(Pageable pageable);
}
