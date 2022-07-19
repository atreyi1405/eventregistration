package eventreg.EventRegistrationBackend.dao;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, String>{
    Person findPersonByName(String name);
}
