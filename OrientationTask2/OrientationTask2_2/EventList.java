package OrientationTask2_2;

import java.util.PriorityQueue;

public class EventList {
    private PriorityQueue<Event> events = new PriorityQueue<>();

    public void addEvent(Event e) {
        events.add(e);
    }

    public Event getNextEvent() {
        return events.poll();
    }

    public boolean isEmpty() {
        return events.isEmpty();
    }

    // print events in chronological order
    public void printEventsChronologically() {
        PriorityQueue<Event> copy = new PriorityQueue<>(events);
        while (!copy.isEmpty()) {
            System.out.println(copy.poll());
        }
    }
}

