import java.util.GregorianCalendar;
import java.util.Calendar;
import java.util.ArrayList;

public class EventBook{
    protected ArrayList<Event> eventList = new ArrayList<Event>();

    public boolean addEvent(Event event, GregorianCalendar dateTime){
        event.schedule(dateTime);
        for(int i = 0; i < eventList.size(); i++){
            if(eventList.get(i).overlaps(event)){
                event.schedule(null); 
                return false;
            }
        }
        eventList.add(event);
        return true;
    }

    public ArrayList<Event> getEventsForDate(GregorianCalendar dateTime){
        ArrayList<Event> eventsForDate = new ArrayList<Event>();
        for(Event e : eventList){
            if (e.getDate() == (dateTime.get(Calendar.DAY_OF_MONTH))){
                eventsForDate.add(e);
            }
        }
        return eventsForDate;
    }    
}
