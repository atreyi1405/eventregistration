package eventreg.EventRegistrationBackend.model;


import javax.persistence.Entity;
import javax.persistence.Id;

// line 2 "model.ump"
// line 33 "model.ump"
@Entity
public class Person
{

 
  private String name;

  public void setName(String value)
  {
    this.name=value;
  }

@Id
  public String getName()
  {
    return name;
  }
  
}