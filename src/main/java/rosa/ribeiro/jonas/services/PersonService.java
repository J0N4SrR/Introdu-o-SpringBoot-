package rosa.ribeiro.jonas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rosa.ribeiro.jonas.exception.ResourceNotFoundExeption;
import rosa.ribeiro.jonas.model.PersonModel;
import rosa.ribeiro.jonas.repository.PersonRepository;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonService {
    private final AtomicLong counter = new AtomicLong();
    private final Logger logger = Logger.getLogger(PersonService.class.getName());

    @Autowired
    PersonRepository repository;


    public List<PersonModel> findAll(){
        logger.info("Finding all People!");

        return repository.findAll();

    }

    public PersonModel findById(Long id){
        logger.info("Finding one People!");
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundExeption("No records found for this id"));
    }

    public PersonModel create(PersonModel person){
        logger.info("Creating one Person!");
        return repository.save(person);
    }

    public PersonModel update(PersonModel person){
        logger.info("Updating one Person!");
        PersonModel entity = repository.findById(person.getId()).orElseThrow(() -> new ResourceNotFoundExeption("No records found for this id"));
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());
        return repository.save(person);
    }

    public void delete(Long id){
        logger.info("Deleting one Person!");
        PersonModel entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundExeption("No records found for this id"));
        repository.delete(entity);
    }
}


