package OrientationTask3_7;

public class Event {
    public double time;
    public String type;

    public Event(double time, String type) {
        this.time = time;
        this.type = type;
    }

    public String toString() {
        return type + " at time " + time;
    }
}

