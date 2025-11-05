package OrientationTask2_3;

public class Event implements Comparable<Event> {
    private EventType type;      // Event type (arrival or exit)
    private int time;            // When the event happens
    private String name;

    public Event(EventType type, int time, String name) {
        this.type = type;
        this.time = time;
        this.name = name;
    }

    public EventType getType() {
        return type;
    }

    public int getTime() {
        return time;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Event other) {
        return Integer.compare(this.time, other.time);
    }

    @Override
    public String toString() {
        return "Event{" +
                "type=" + type +
                ", time=" + time +
                ", name='" + name + '\'' +
                '}';
    }
}
