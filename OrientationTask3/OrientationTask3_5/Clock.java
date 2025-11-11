package OrientationTask3_5;

public class Clock {

    private static Clock instance = new Clock();

    private double time = 0;

    // Private constructor (prevents `new Clock()` from outside)
    private Clock() { }

    public static Clock getInstance() {
        return instance;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double t) {
        time = t;
    }
}
