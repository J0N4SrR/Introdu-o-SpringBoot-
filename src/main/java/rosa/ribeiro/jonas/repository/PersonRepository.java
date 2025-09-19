package rosa.ribeiro.jonas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rosa.ribeiro.jonas.model.PersonModel;

public interface PersonRepository extends JpaRepository<PersonModel, Long> {}
