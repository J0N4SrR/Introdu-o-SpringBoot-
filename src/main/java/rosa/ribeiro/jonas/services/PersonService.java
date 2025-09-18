package rosa.ribeiro.jonas.services;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
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
        logger.info("Finding all People!");
        //MockPerson
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

    public PersonModel create(PersonModel person){
        logger.info("Creating one Person!");
        return person;
    }

    public PersonModel update(PersonModel person){
        logger.info("Updating one Person!");
        return person;
    }

    public void delete(String id){
        logger.info("Deleting one Person!");

    }
}


