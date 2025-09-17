package rosa.ribeiro.jonas.services;

import org.springframework.stereotype.Service;
import rosa.ribeiro.jonas.model.PersonModel;

import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonService {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonService.class.getName());

    public PersonModel findById(String id){
        logger.info("Finding one Person!");
        PersonModel person = new PersonModel();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Leandro");
        person.setLastName("Silva");
        person.setAddress("Uberlândia-MG");
        person.setGender("Male");
        return person;
    }

}
