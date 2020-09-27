package org.sid.campagnevac.web;

import com.sun.org.apache.xerces.internal.xs.StringList;
import org.sid.campagnevac.dao.DemographieRepository;
import org.sid.campagnevac.entities.Demographie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.GetMapping;
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

}

