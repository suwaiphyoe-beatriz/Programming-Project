package OrientationTask3_7;

public class Clock {

    private static Clock instance = new Clock();
    private double time = 0;

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

