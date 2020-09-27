package org.sid.campagnevac;

import org.sid.campagnevac.dao.DemographieRepository;
import org.sid.campagnevac.entities.Demographie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DemoRestController {
    @Autowired
    private DemographieRepository demographieRepository;
    @GetMapping(value = "/listedemo")
    public List<Demographie> listedemo(){
        return demographieRepository.findAll();
    }
    @GetMapping(value = "/listedemo/{id}")
    public Demographie listedemo(@PathVariable(name="id") Long id){
        return demographieRepository.findById(id).get();
    }
    @PutMapping(value="/liste/{id}")
    public Demographie update(@PathVariable(name="id") Long id, @RequestBody Demographie d){
        d.setId(id);
        return demographieRepository.save(d);
    }
    @DeleteMapping(value="/listedemo")
    public Demographie save(@RequestBody Demographie d){
        return demographieRepository.save(d);
    }
    @DeleteMapping(value="/listedemo/{id}")
    public void delete(@PathVariable(name="id") Long id){
        demographieRepository.deleteById(id);
    }

}


