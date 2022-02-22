import java.util.GregorianCalendar;
import java.util.Calendar;

public abstract class Event {
    protected GregorianCalendar startTime, endTime = null;
    protected Contact organizer;
    protected String description;

    public String getDescription(){
        return this.description;
    }

    public boolean overlaps(Event event){
        Event first, second;
        boolean overlap_found = true;

        if (this.startTime.compareTo(event.startTime) < 0){
           first = this;
           second = event;
        }
        else{
           first = event;
           second = this;
        }

        if (first.endTime.compareTo(second.startTime) <= 0){
           overlap_found = false;
        }
        return overlap_found;
    }

    public String toString(){
        if(startTime == null || endTime == null){
            String value = description + " not scheduled";

            return value;
        }
        else{
            int startTimeMonth = startTime.get(Calendar.MONTH) + 1;
            int endTimeMonth = endTime.get(Calendar.MONTH) + 1;
            
            String event = description + " start " + startTime.get(Calendar.YEAR) + "/" +  startTimeMonth + "/" + startTime.get(Calendar.DAY_OF_MONTH) + " " + startTime.get(Calendar.HOUR_OF_DAY) + ":" + startTime.get(Calendar.MINUTE) + " end " + endTime.get(Calendar.YEAR) + "/" +  endTimeMonth + "/" + endTime.get(Calendar.DAY_OF_MONTH) + " " + endTime.get(Calendar.HOUR_OF_DAY) + ":" + endTime.get(Calendar.MINUTE);

            return event;
        }
    }

    public int getDate(){
        return this.startTime.get(Calendar.DAY_OF_MONTH);
    }

    public GregorianCalendar getStartTime(){
        return this.startTime;
    }

    public GregorianCalendar getEndtime(){
        return this.endTime;
    }
    
    public abstract void schedule(GregorianCalendar dateTime);
}
