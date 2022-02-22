import java.util.GregorianCalendar;
import java.util.Calendar;

public class Meeting extends Event{
    private int endBuffer;

    public Meeting(Contact organizer, String description){
        this.organizer = organizer;
        this.description = description;
    }

    public void setEndBuffer(int endBuffer){
        this.endBuffer = endBuffer;
    }

    public void schedule(GregorianCalendar dateTime){
        if(dateTime != null){
            GregorianCalendar dateTimeCopy = new GregorianCalendar(dateTime.get(Calendar.YEAR), 
            dateTime.get(Calendar.MONTH), dateTime.get(Calendar.DAY_OF_MONTH), dateTime.get(Calendar.HOUR_OF_DAY), 
            dateTime.get(Calendar.MINUTE), dateTime.get(Calendar.SECOND));

            dateTime.add(Calendar.MINUTE, 60 + endBuffer);
            startTime = dateTimeCopy;
            endTime = dateTime;
        }
        else{
            endTime = null;
            startTime = null;
        }
    }
}
