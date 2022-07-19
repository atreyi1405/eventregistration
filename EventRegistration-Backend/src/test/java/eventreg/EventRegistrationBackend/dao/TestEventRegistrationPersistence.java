package eventreg.EventRegistrationBackend.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import eventreg.EventRegistrationBackend.model.Event;
import eventreg.EventRegistrationBackend.model.Person;
import eventreg.EventRegistrationBackend.model.Registration;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class TestEventRegistrationPersistence {
    @Autowired
    private PersonRepository personRepository;
    @Autowired 
	private EventRepository eventRepository;
    @Autowired
    private RegistrationRepository registrationRepository;
    /** 
    @AfterEach
    public void clearDatabase(){
        registrationRepository.deleteAll;
        personRepository.deleteAll;
        eventRepository.deleteAll;
    }*/

    @Test
        public void testPersistAndLoadPerson() {
		String name = "TestPerson";
		// First example for object save/load
		Person person = new Person();
		// First example for attribute save/load
		person.setName(name);
		personRepository.save(person);

		person = null;

		person = personRepository.findPersonByName(name);
		assertNotNull(person);
		assertEquals(name, person.getName());
	}

    @Test
        public void testPersistAndLoadEvent(){
            String name="TestEvent";
            Date date = java.sql.Date.valueOf(LocalDate.of(2020, Month.JANUARY, 31));
		    Time startTime = java.sql.Time.valueOf(LocalTime.of(11, 35));
		    Time endTime = java.sql.Time.valueOf(LocalTime.of(13, 25));
		    Event event = new Event();
		    event.setName(name);
		    event.setDate(date);
		    event.setStartTime(startTime);
		    event.setEndTime(endTime);
		    eventRepository.save(event);

		    event = null;

		    event = eventRepository.findEventByName(name);

		    assertNotNull(event);
		    assertEquals(name, event.getName());
		    assertEquals(date, event.getDate());
		    assertEquals(startTime, event.getStartTime());
		    assertEquals(endTime, event.getEndTime());
        }


    @Test
        public void testPersistAndLoadRegistration() {
		String personName = "TestPerson";
		Person person = new Person();
		person.setName(personName);
		personRepository.save(person);
        String eventName ="TestEvent";
        Date date = java.sql.Date.valueOf(LocalDate.of(2020, Month.JANUARY, 31));
		Time startTime = java.sql.Time.valueOf(LocalTime.of(11, 35));
		Time endTime = java.sql.Time.valueOf(LocalTime.of(13, 25));
		Event event = new Event();
		event.setName(eventName);
		event.setDate(date);
		event.setStartTime(startTime);
		event.setEndTime(endTime);
		eventRepository.save(event);

		Registration reg = new Registration();
        int regId = 1;
		// First example for reference save/load
		reg.setId(regId);
		reg.setPerson(person);
		reg.setEvent(event);
		registrationRepository.save(reg);

		reg = null;

		reg = registrationRepository.findByPersonAndEvent(person, event);
		assertNotNull(reg);
		assertEquals(regId, reg.getId());
        assertEquals(person.getName(), reg.getPerson().getName());
		assertEquals(event.getName(), reg.getEvent().getName());

    }


}