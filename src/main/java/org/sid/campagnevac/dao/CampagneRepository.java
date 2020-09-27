package org.sid.campagnevac.dao;

import org.sid.campagnevac.entities.Campagne;
import org.sid.campagnevac.entities.Demographie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin("*")
public interface CampagneRepository extends JpaRepository<Campagne,Long> {
}
