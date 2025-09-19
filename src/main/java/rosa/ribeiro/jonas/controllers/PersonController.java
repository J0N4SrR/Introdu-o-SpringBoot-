package rosa.ribeiro.jonas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rosa.ribeiro.jonas.model.PersonModel;
import rosa.ribeiro.jonas.services.PersonService;
import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService service;

    @GetMapping(
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<PersonModel> findAll() {
        return service.findAll();
    }

    @GetMapping(value = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public PersonModel findById(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public PersonModel create(@RequestBody PersonModel person) {
        return service.create(person);
    }

    @PutMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public PersonModel update(@RequestBody PersonModel person) {
        return service.create(person);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
