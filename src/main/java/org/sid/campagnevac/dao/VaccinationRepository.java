package org.sid.campagnevac.dao;

import org.sid.campagnevac.entities.Demographie;
import org.sid.campagnevac.entities.Vaccination;
import org.sid.campagnevac.entities.Wilaya;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RepositoryRestResource
@CrossOrigin("*")
public interface VaccinationRepository extends JpaRepository<Vaccination,Long> {
















    //@Query("SELECT COUNT(v.nombre) FROM Vaccination \n" +
            //" v JOIN v.Campagne c JOIN c.Moughataa m JOIN m.Enquete e")

   // @Query("SELECT v.nombre ,m.name FROM vaccination v JOIN moughataa m ON\n" +
           // "v.id=m.id ")
   // JOIN v.moughataa
  // @RestResource(path = "/lll")
   //@Query("SELECT v  FROM Vaccination v JOIN v.moughataa")
   //public List <Vaccination>trouver();


   // @RestResource(path = "/lll")
    //@Query("select new org.sid.campagnevac.entities.Vaccination(v.nombre, v.moughataa.name) from Vaccination v, Moughataa m where v.moughataa= m")
    //public List <Vaccination>trouver();

}
