package org.sid.campagnevac.dao;

import java.util.List;

import org.sid.campagnevac.entities.Demographie;
import org.sid.campagnevac.entities.Enquete;
import org.sid.campagnevac.entities.Moughataa;
import org.sid.campagnevac.entities.Vaccination;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin("*")
public interface EnqueteRepository extends JpaRepository<Enquete,Long> {
	
	@Query(
			value="SELECT E.* FROM enquete E, campagne C, demographie D WHERE E.moughataa_id = ?1 AND C.id = ?2 AND D.id = C.demographie_id AND E.demographie_id = D.id",
			nativeQuery = true
			)
	public List<Enquete> getCampagneMoughataaEnquetes(long moughataa_id, long campagne_id);
	
	@Query(
			value = "SELECT E.* FROM enquete E, campagne C, demographie D WHERE C.id = ?1 AND D.id = C.demographie_id AND E.demographie_id = D.id",
			nativeQuery = true
			)
	public List<Enquete> getCampagneEnquetes(long id);

	//@Query(value="SELECT * FROM enquete WHERE demographie_id = ?1",
			//nativeQuery = true)
	//public List<Enquete> findByDemographie(long id);
	//@Query(value="select e from Enquete e WHERE Demographie.id=? ")
	@Query(value="SELECT * FROM enquete WHERE demographie_id = ?1",
			nativeQuery = true)
	public Page<Enquete> affichierEnquete(Pageable pageable,long id);




}
