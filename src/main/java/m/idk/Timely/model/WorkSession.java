package m.idk.Timely.model;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "workSession")
public class WorkSession  {
     private long id;
     private Date startDate;
     private Date endDate;
     private String duration;
     private String sessionName;

     public WorkSession(){}

    public WorkSession(String sessionName, Date startDate, Date endDate, String duration){
         this.sessionName=sessionName;
         this.startDate=startDate;
         this.endDate=endDate;
         this.duration=duration;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//+1 INCREMENT
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    @Column (name="session_start", nullable = true)
 public Date getStartDate(){
         return startDate;
    }

    public void setStartDate(Date startDate){
       this.startDate=startDate;
    }

    @Column (name="session_end", nullable = true)
    public Date getEndDate(){
        return endDate;
    }
    public void setEndDate(Date endDate){
        this.endDate=endDate;
    }

    @Column (name="session_duration", nullable = true) //change this later to false
    public String getDuration(){
        return duration;
    }
    public void setDuration(String duration){
        this.duration=duration;
    }

    @Column (name="session_name", nullable = true)
    public String getSessionName(){
        return sessionName;
    }
    public void setSessionName(String sessionName){
        this.sessionName=sessionName;
    }

}


