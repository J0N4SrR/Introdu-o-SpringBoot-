package rosa.ribeiro.jonas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
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
    public List<PersonModel> findAll() {
        return service.findAll();
    }

    @RequestMapping(value = "/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public PersonModel findById(@PathVariable("id") String id) {
        return service.findById(id);
    }


    @RequestMapping(method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public PersonModel create(@RequestBody PersonModel person) {
        return service.create(person);
    }

    @RequestMapping(method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public PersonModel update(@RequestBody PersonModel person) {
        return service.create(person);
    }

    @RequestMapping(value = "/{id}",
            method = RequestMethod.DELETE
    )
    public void delete(@PathVariable("id") String id) {
        service.delete(id);
    }

}
