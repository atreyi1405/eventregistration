package eventreg.EventRegistrationBackend.model;
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.31.1.5860.78bb27cc6 modeling language!*/


import java.sql.Date;
import java.sql.Time;


import javax.persistence.Entity;
import javax.persistence.Id;

// line 15 "model.ump"
// line 51 "model.ump"



  
  @Entity
  public class Event
  {
    private String name;
  //------------------------
  // INTERFACE
  //------------------------

  public void setName(String value)
  {
   this.name=value;
  }


  @Id
  public String getName()
  {
    return this.name;
  }
  private Date date;

  public void setDate(Date value){
    this.date=value;
  }

  public Date getDate(){
    return this.date;
  }
  private Time startTime;

  public void setStartTime(Time value) {
  this.startTime = value;
      }
  public Time getStartTime() {
  return this.startTime;
      }
  private Time endTime;
  
  public void setEndTime(Time value) {
  this.endTime = value;
      }
  public Time getEndTime() {
  return this.endTime;
         }
  
}