package rosa.ribeiro.jonas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import rosa.ribeiro.jonas.model.PersonModel;
import rosa.ribeiro.jonas.services.PersonService;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService service;

    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<PersonModel> findAll(){
        return service.findAll();
    }

    @RequestMapping(value = "/{id}",
        method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public PersonModel findById(@PathVariable("id") String id){
        return service.findById(id);
    }
}
