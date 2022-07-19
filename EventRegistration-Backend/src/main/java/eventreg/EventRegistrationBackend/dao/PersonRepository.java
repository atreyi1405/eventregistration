package eventreg.EventRegistrationBackend.dao;
import org.springframework.data.repository.CrudRepository;

import eventreg.EventRegistrationBackend.model.Person;

public interface PersonRepository extends CrudRepository<Person, String>{
    Person findPersonByName(String name);
}
