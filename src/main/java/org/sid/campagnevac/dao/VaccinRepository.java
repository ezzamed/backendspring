package org.sid.campagnevac.dao;

import org.sid.campagnevac.entities.Vaccin;
import org.sid.campagnevac.entities.Wilaya;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
@RepositoryRestResource
public interface VaccinRepository extends JpaRepository<Vaccin,Long> {
}
