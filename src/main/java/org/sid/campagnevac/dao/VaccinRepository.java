package org.sid.campagnevac.dao;

import org.sid.campagnevac.entities.Vaccin;
import org.sid.campagnevac.entities.Vaccination;
import org.sid.campagnevac.entities.Wilaya;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin("*")
@RepositoryRestResource
public interface VaccinRepository extends JpaRepository<Vaccin,Long> {
    @Query(value="SELECT * FROM vaccin WHERE campagne_id = ?1",
            nativeQuery = true)
    public List<Vaccin> getCampagneVaccins(long id);

}
