package eventreg.EventRegistrationBackend.model;/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.31.1.5860.78bb27cc6 modeling language!*/
import javax.persistence.Entity;
  import javax.persistence.Id;
  import javax.persistence.ManyToOne;


// line 8 "model.ump"
// line 45 "model.ump"


  
  @Entity
  public class Registration{
  private int id;
     
     public void setId(int value) {
  this.id = value;
      }
  @Id
  public int getId() {
  return this.id;
      }
  private Person person;
  
  @ManyToOne(optional=false)
  public Person getPerson() {
     return this.person;
  }
  
  public void setPerson(Person person) {
     this.person = person;
  }
  
  private Event event;
  
  @ManyToOne(optional=false)
  public Event getEvent() {
     return this.event;
  }
  
  public void setEvent(Event event) {
     this.event = event;
  }
  
  }
