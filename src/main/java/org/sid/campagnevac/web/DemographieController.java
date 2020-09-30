package org.sid.campagnevac.web;

import com.sun.org.apache.xerces.internal.xs.StringList;
import org.sid.campagnevac.dao.DemographieRepository;
import org.sid.campagnevac.entities.Demographie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
//@Query("from Demographie")
@RestController
public class DemographieController {
    @Autowired
    private DemographieRepository demographieRepository;

    //@GetMapping("/lien")
    //public List<Demographie> findBynameContains(@Param("mc") String nm);
 
    @GetMapping("/getDemographie/{id}")
    public Demographie getDemographie(@PathVariable long id) {
    	return demographieRepository.getOne(id);
    }
    
    @PutMapping(value="/modifierDemographie")
    public Demographie updateDemographie(@RequestBody Demographie d) {
        //d.setId(id);
        return demographieRepository.save(d);
        //return demographieRepository.save(d);
    }
    
    @DeleteMapping(value="/supprimerDemographie/{id}")
    public void deleteDemographie(@PathVariable long id){
        demographieRepository.deleteById(id);
    }

}

