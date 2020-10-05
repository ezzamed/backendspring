package org.sid.campagnevac.dao;

import java.util.List;

import org.sid.campagnevac.entities.Moughataa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;


@RepositoryRestResource
@CrossOrigin("*")
public interface MoughataaRepository extends JpaRepository<Moughataa,Long> {
	
	@Query(
			value="SELECT * FROM moughataa WHERE wilaya_id = ?1",
			nativeQuery = true)
	public List<Moughataa> findByWilaya(long id);
	
	@Query(
			value="SELECT M.* FROM moughataa M, vaccination V, campagne C WHERE C.id = V.campagne_id AND M.id = V.moughataa_id AND C.id = ?1",
			nativeQuery = true
			)
	public List<Moughataa> findByCampagne(long id);

}
