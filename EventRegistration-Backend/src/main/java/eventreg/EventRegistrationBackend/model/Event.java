package eventreg.EventRegistrationBackend.model;
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.31.1.5860.78bb27cc6 modeling language!*/


import java.sql.Date;
import java.sql.Time;
import java.util.*;

// line 15 "model.ump"
// line 51 "model.ump"
public class Event
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Event Attributes
  private String name;
  private Date eventDate;
  private Time startTime;
  private Time endTime;

  //Event Associations
  private List<Registration> registration;
  private RegistrationManager registrationManager;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Event(String aName, Date aEventDate, Time aStartTime, Time aEndTime, RegistrationManager aRegistrationManager)
  {
    name = aName;
    eventDate = aEventDate;
    startTime = aStartTime;
    endTime = aEndTime;
    registration = new ArrayList<Registration>();
    boolean didAddRegistrationManager = setRegistrationManager(aRegistrationManager);
    if (!didAddRegistrationManager)
    {
      throw new RuntimeException("Unable to create event due to registrationManager. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
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

  public boolean setEventDate(Date aEventDate)
  {
    boolean wasSet = false;
    eventDate = aEventDate;
    wasSet = true;
    return wasSet;
  }

  public boolean setStartTime(Time aStartTime)
  {
    boolean wasSet = false;
    startTime = aStartTime;
    wasSet = true;
    return wasSet;
  }

  public boolean setEndTime(Time aEndTime)
  {
    boolean wasSet = false;
    endTime = aEndTime;
    wasSet = true;
    return wasSet;
  }

  public String getName()
  {
    return name;
  }

  public Date getEventDate()
  {
    return eventDate;
  }

  public Time getStartTime()
  {
    return startTime;
  }

  public Time getEndTime()
  {
    return endTime;
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
  public Registration addRegistration(int aId, RegistrationManager aRegistrationManager, Person aPerson)
  {
    return new Registration(aId, aRegistrationManager, aPerson, this);
  }

  public boolean addRegistration(Registration aRegistration)
  {
    boolean wasAdded = false;
    if (registration.contains(aRegistration)) { return false; }
    Event existingEvent = aRegistration.getEvent();
    boolean isNewEvent = existingEvent != null && !this.equals(existingEvent);
    if (isNewEvent)
    {
      aRegistration.setEvent(this);
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
    //Unable to remove aRegistration, as it must always have a event
    if (!this.equals(aRegistration.getEvent()))
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
      existingRegistrationManager.removeEvent(this);
    }
    registrationManager.addEvent(this);
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
      placeholderRegistrationManager.removeEvent(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "name" + ":" + getName()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "eventDate" + "=" + (getEventDate() != null ? !getEventDate().equals(this)  ? getEventDate().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "startTime" + "=" + (getStartTime() != null ? !getStartTime().equals(this)  ? getStartTime().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "endTime" + "=" + (getEndTime() != null ? !getEndTime().equals(this)  ? getEndTime().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "registrationManager = "+(getRegistrationManager()!=null?Integer.toHexString(System.identityHashCode(getRegistrationManager())):"null");
  }
}