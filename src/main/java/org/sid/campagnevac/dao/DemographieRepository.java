package org.sid.campagnevac.dao;

import org.sid.campagnevac.entities.Demographie;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
//import java.awt.print.Pageable;
import java.util.List;
import org.springframework.data.domain.Pageable;


@CrossOrigin("*")
@RepositoryRestResource
public interface DemographieRepository extends JpaRepository<Demographie,Long> {
    @RestResource(path = "/Bynamedemo")
    public List<Demographie> findBynameContains(@Param("mc") String nm);

    @RestResource(path = "/Bynamedemopage")
    public Page<Demographie> findBynameContains(@Param("mc") String nm, Pageable pageable);

    @RestResource(path = "/lien")
    @Query("from Demographie")
    public List<Demographie> trouver();

}