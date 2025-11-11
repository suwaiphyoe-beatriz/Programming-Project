package OrientationTask3_7;

public class TestSuite {

    public static void main(String[] args) {

        Clock clock = Clock.getInstance();
        clock.setTime(0);

        EventList events = new EventList();
        ArrivalProcess arrivals = new ArrivalProcess(5, "ARRIVAL"); // mean 5 units

        arrivals.createArrivals(10, events, clock);

        ServicePoint sp = new ServicePoint();

        for (Event e : events.list) {
            sp.add(new Customer(e.time));
        }

        clock.setTime(clock.getTime() + 5);

        System.out.println("Customer time in system:");
        while (sp.hasCustomers()) {
            Customer c = sp.serve(clock.getTime());
            double timeSpent = c.departure - c.arrival;
            System.out.printf("%.2f%n", timeSpent);
        }

        System.out.println("\nFinal clock time: " + clock.getTime());
    }
}
