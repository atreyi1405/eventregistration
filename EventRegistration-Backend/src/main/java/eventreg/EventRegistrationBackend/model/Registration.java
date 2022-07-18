package eventreg.EventRegistrationBackend.model;/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.31.1.5860.78bb27cc6 modeling language!*/



// line 8 "model.ump"
// line 45 "model.ump"
public class Registration
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Registration Attributes
  private int id;

  //Registration Associations
  private RegistrationManager registrationManager;
  private Person person;
  private Event event;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Registration(int aId, RegistrationManager aRegistrationManager, Person aPerson, Event aEvent)
  {
    id = aId;
    boolean didAddRegistrationManager = setRegistrationManager(aRegistrationManager);
    if (!didAddRegistrationManager)
    {
      throw new RuntimeException("Unable to create registration due to registrationManager. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    boolean didAddPerson = setPerson(aPerson);
    if (!didAddPerson)
    {
      throw new RuntimeException("Unable to create registration due to person. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    boolean didAddEvent = setEvent(aEvent);
    if (!didAddEvent)
    {
      throw new RuntimeException("Unable to create registration due to event. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setId(int aId)
  {
    boolean wasSet = false;
    id = aId;
    wasSet = true;
    return wasSet;
  }

  public int getId()
  {
    return id;
  }
  /* Code from template association_GetOne */
  public RegistrationManager getRegistrationManager()
  {
    return registrationManager;
  }
  /* Code from template association_GetOne */
  public Person getPerson()
  {
    return person;
  }
  /* Code from template association_GetOne */
  public Event getEvent()
  {
    return event;
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
      existingRegistrationManager.removeRegistration(this);
    }
    registrationManager.addRegistration(this);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_SetOneToMany */
  public boolean setPerson(Person aPerson)
  {
    boolean wasSet = false;
    if (aPerson == null)
    {
      return wasSet;
    }

    Person existingPerson = person;
    person = aPerson;
    if (existingPerson != null && !existingPerson.equals(aPerson))
    {
      existingPerson.removeRegistration(this);
    }
    person.addRegistration(this);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_SetOneToMany */
  public boolean setEvent(Event aEvent)
  {
    boolean wasSet = false;
    if (aEvent == null)
    {
      return wasSet;
    }

    Event existingEvent = event;
    event = aEvent;
    if (existingEvent != null && !existingEvent.equals(aEvent))
    {
      existingEvent.removeRegistration(this);
    }
    event.addRegistration(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    RegistrationManager placeholderRegistrationManager = registrationManager;
    this.registrationManager = null;
    if(placeholderRegistrationManager != null)
    {
      placeholderRegistrationManager.removeRegistration(this);
    }
    Person placeholderPerson = person;
    this.person = null;
    if(placeholderPerson != null)
    {
      placeholderPerson.removeRegistration(this);
    }
    Event placeholderEvent = event;
    this.event = null;
    if(placeholderEvent != null)
    {
      placeholderEvent.removeRegistration(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "id" + ":" + getId()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "registrationManager = "+(getRegistrationManager()!=null?Integer.toHexString(System.identityHashCode(getRegistrationManager())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "person = "+(getPerson()!=null?Integer.toHexString(System.identityHashCode(getPerson())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "event = "+(getEvent()!=null?Integer.toHexString(System.identityHashCode(getEvent())):"null");
  }
}