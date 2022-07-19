package eventreg.EventRegistrationBackend.dao;
import org.springframework.data.repository.CrudRepository;

import eventreg.EventRegistrationBackend.model.Event;
import eventreg.EventRegistrationBackend.model.Person;
import eventreg.EventRegistrationBackend.model.Registration;

import java.util.List;
public interface RegistrationRepository extends CrudRepository<Registration, Integer> {
    List<Registration> findByPerson(Person personName);

	boolean existsByPersonAndEvent(Person person, Event eventName);

	Registration findByPersonAndEvent(Person person, Event eventName);
}