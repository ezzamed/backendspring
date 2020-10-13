package org.sid.campagnevac.dao;

import org.sid.campagnevac.entities.Demographie;
import org.sid.campagnevac.entities.Moughataa;
import org.sid.campagnevac.entities.Wilaya;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Collection;
import java.util.List;

@RepositoryRestResource
@CrossOrigin("*")
public interface WilayaRepository extends JpaRepository<Wilaya,Long> {




    /*@RestResource(path = "/liens")
    @Query("SELECT w FROM Wilaya w WHERE w.id = 1")
    Collection<Wilaya> findAllActiveUsers();*/
    //@RestResource(path = "/x")
    //@Query("from Wilaya")
    //public List<Wilaya> trouver();

    @RestResource(path = "/x")
    @Query("from Wilaya")
    public List<Wilaya> trouver();
    
    @Query(
			value="SELECT W.* "
					+ "FROM wilaya W, vaccination V, campagne C, moughataa M "
					+ "WHERE V.campagne_id = C.id "
					+ "AND M.id = V.moughataa_id "
					+ "AND W.id = M.wilaya_id "
					+ "AND C.id = ?1 "
					+ "GROUP BY W.id",
			nativeQuery = true
			)
	public List<Wilaya> findByCampagne(long id);
}
