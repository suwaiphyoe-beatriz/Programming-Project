package OrientationTask3_7;

import java.util.ArrayList;

public class EventList {
    public ArrayList<Event> list = new ArrayList<>();

    public void add(Event e) {
        list.add(e);
    }

    public void print() {
        for (Event e : list) {
            System.out.println(e);
        }
    }
}