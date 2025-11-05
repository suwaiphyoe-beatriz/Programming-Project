package OrientationTask2_3;

public class Test {
    public static void main(String[] args) {
        EventList eventList = new EventList();

        // Add events
        eventList.addEvent(new Event(EventType.ARRIVAL, 9, "Customer A"));
        eventList.addEvent(new Event(EventType.EXIT, 1, "Customer C"));
        eventList.addEvent(new Event(EventType.ARRIVAL, 6, "Customer E"));

        System.out.println("All events in chronological order:");
        eventList.printEventsChronologically();

        System.out.println("\nNext event to process:");
        System.out.println(eventList.getNextEvent());
    }
}



