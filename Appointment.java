import java.util.Calendar;
import java.util.GregorianCalendar;

public class Appointment extends Event{
    private int startBuffer;

    public Appointment(Contact organizer, String description){
        this.organizer = organizer;
        this.description = description;
    }

    public void setStartBuffer(int startBuffer){
        this.startBuffer = startBuffer;
    }

    public void schedule(GregorianCalendar dateTime){
        if(dateTime != null){
            GregorianCalendar dateTimeCopy = new GregorianCalendar(dateTime.get(Calendar.YEAR), 
            dateTime.get(Calendar.MONTH), dateTime.get(Calendar.DAY_OF_MONTH), dateTime.get(Calendar.HOUR_OF_DAY), 
            dateTime.get(Calendar.MINUTE), dateTime.get(Calendar.SECOND));
    
            dateTimeCopy.add(Calendar.MINUTE, -startBuffer);
            dateTime.add(Calendar.MINUTE, 60);
    
            startTime = dateTimeCopy;
            endTime = dateTime;
        }
        else{
            endTime = null;
            startTime = null;
        }
    }
}
