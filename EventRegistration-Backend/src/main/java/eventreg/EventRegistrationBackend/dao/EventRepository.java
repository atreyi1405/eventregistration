package eventreg.EventRegistrationBackend.dao;
import org.springframework.data.repository.CrudRepository;

import eventreg.EventRegistrationBackend.model.Event;

public interface EventRepository extends CrudRepository<Event, String> {
    Event findEventByName(String name);
}