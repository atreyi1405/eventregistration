package eventreg.EventRegistrationBackend.model;
import java.util.*;

// line 2 "model.ump"
// line 33 "model.ump"
public class Person
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Person Attributes
  private String name;

  //Person Associations
  private List<Registration> registration;
  private RegistrationManager registrationManager;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Person(String aName, RegistrationManager aRegistrationManager)
  {
    name = aName;
    registration = new ArrayList<Registration>();
    boolean didAddRegistrationManager = setRegistrationManager(aRegistrationManager);
    if (!didAddRegistrationManager)
    {
      throw new RuntimeException("Unable to create person due to registrationManager. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setName(String aName)
  {
    boolean wasSet = false;
    name = aName;
    wasSet = true;
    return wasSet;
  }

  public String getName()
  {
    return name;
  }
  /* Code from template association_GetMany */
  public Registration getRegistration(int index)
  {
    Registration aRegistration = registration.get(index);
    return aRegistration;
  }

  public List<Registration> getRegistration()
  {
    List<Registration> newRegistration = Collections.unmodifiableList(registration);
    return newRegistration;
  }

  public int numberOfRegistration()
  {
    int number = registration.size();
    return number;
  }

  public boolean hasRegistration()
  {
    boolean has = registration.size() > 0;
    return has;
  }

  public int indexOfRegistration(Registration aRegistration)
  {
    int index = registration.indexOf(aRegistration);
    return index;
  }
  /* Code from template association_GetOne */
  public RegistrationManager getRegistrationManager()
  {
    return registrationManager;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfRegistration()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Registration addRegistration(int aId, RegistrationManager aRegistrationManager, Event aEvent)
  {
    return new Registration(aId, aRegistrationManager, this, aEvent);
  }

  public boolean addRegistration(Registration aRegistration)
  {
    boolean wasAdded = false;
    if (registration.contains(aRegistration)) { return false; }
    Person existingPerson = aRegistration.getPerson();
    boolean isNewPerson = existingPerson != null && !this.equals(existingPerson);
    if (isNewPerson)
    {
      aRegistration.setPerson(this);
    }
    else
    {
      registration.add(aRegistration);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeRegistration(Registration aRegistration)
  {
    boolean wasRemoved = false;
    //Unable to remove aRegistration, as it must always have a person
    if (!this.equals(aRegistration.getPerson()))
    {
      registration.remove(aRegistration);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addRegistrationAt(Registration aRegistration, int index)
  {  
    boolean wasAdded = false;
    if(addRegistration(aRegistration))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfRegistration()) { index = numberOfRegistration() - 1; }
      registration.remove(aRegistration);
      registration.add(index, aRegistration);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveRegistrationAt(Registration aRegistration, int index)
  {
    boolean wasAdded = false;
    if(registration.contains(aRegistration))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfRegistration()) { index = numberOfRegistration() - 1; }
      registration.remove(aRegistration);
      registration.add(index, aRegistration);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addRegistrationAt(aRegistration, index);
    }
    return wasAdded;
  }
  /* Code from template association_SetOneToMany */
  public boolean setRegistrationManager(RegistrationManager aRegistrationManager)
  {
    boolean wasSet = false;
    if (aRegistrationManager == null)
    {
      return wasSet;
    }

    RegistrationManager existingRegistrationManager = registrationManager;
    registrationManager = aRegistrationManager;
    if (existingRegistrationManager != null && !existingRegistrationManager.equals(aRegistrationManager))
    {
      existingRegistrationManager.removePerson(this);
    }
    registrationManager.addPerson(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    for(int i=registration.size(); i > 0; i--)
    {
      Registration aRegistration = registration.get(i - 1);
      aRegistration.delete();
    }
    RegistrationManager placeholderRegistrationManager = registrationManager;
    this.registrationManager = null;
    if(placeholderRegistrationManager != null)
    {
      placeholderRegistrationManager.removePerson(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "name" + ":" + getName()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "registrationManager = "+(getRegistrationManager()!=null?Integer.toHexString(System.identityHashCode(getRegistrationManager())):"null");
  }
}