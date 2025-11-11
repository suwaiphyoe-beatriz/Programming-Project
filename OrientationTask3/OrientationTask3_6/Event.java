package OrientationTask3_6;

public class Event {
    public double time;
    public String type;

    public Event(double time, String type) {
        this.time = time;
        this.type = type;
    }

    @Override
    public String toString() {
        return type + " at time " + time;
    }
}
