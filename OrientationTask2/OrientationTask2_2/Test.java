package OrientationTask2_2;

public class Test {
    public static void main(String[] args) {
        EventList eventList = new EventList();

        // Add  events
        eventList.addEvent(new Event(10, "Customer A"));
        eventList.addEvent(new Event(5, "Customer U"));
        eventList.addEvent(new Event(8, "Customer P"));

        //print events in chronological order
        System.out.println("All events in chronological order:");
        eventList.printEventsChronologically();

        System.out.println("\nNext event to process:");
        System.out.println(eventList.getNextEvent());
    }
}

