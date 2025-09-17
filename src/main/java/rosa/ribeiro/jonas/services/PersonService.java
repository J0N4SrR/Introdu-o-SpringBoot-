package rosa.ribeiro.jonas.services;

import org.springframework.stereotype.Service;
import rosa.ribeiro.jonas.model.PersonModel;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonService {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonService.class.getName());

    public List<PersonModel> findAll(){
        List<PersonModel> persons = new ArrayList<>();
        for(int i =0; i < 8; i++){
            PersonModel person = mockPerson(i);
            persons.add(person);
        }
        return persons;
    }

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

    private PersonModel mockPerson(int i) {
        PersonModel person = new PersonModel();
        person.setId(counter.incrementAndGet());
        person.setFirstName("FirstName" + i);
        person.setLastName("LastName" + i);
        person.setAddress("Address"+i);
        person.setGender("Male");
        return person;
    }

}
