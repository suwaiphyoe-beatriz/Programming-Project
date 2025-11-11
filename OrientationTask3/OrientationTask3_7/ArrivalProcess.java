package OrientationTask3_7;

import eduni.distributions.Negexp;

public class ArrivalProcess {
    private Negexp generator;
    private String type;

    public ArrivalProcess(double mean, String type) {
        this.generator = new Negexp(mean);
        this.type = type;
    }

    public void createArrivals(int n, EventList list, Clock clock) {
        double currentTime = clock.getTime();
        for (int i = 0; i < n; i++) {
            currentTime += generator.sample();
            list.add(new Event(currentTime, type));
            clock.setTime(currentTime);
        }
    }
}
