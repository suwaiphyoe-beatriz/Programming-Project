package OrientationTask3_6;

public class Test {

    public static void main(String[] args) {

        Clock clock = Clock.getInstance();
        clock.setTime(0);

        EventList events = new EventList();
        ArrivalProcess arrivals = new ArrivalProcess(5, "ARRIVAL"); // mean = 5 units

        arrivals.createArrivals(10, events, clock);

        System.out.println("Generated events:");
        events.print();

        System.out.println("\nClock now at: " + clock.getTime());
    }
}

