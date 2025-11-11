package OrientationTask3_5;

public class TestClock {
    public static void main(String[] args) {
        Clock clock = Clock.getInstance();

        clock.setTime(10.5);
        System.out.println("Clock time: " + clock.getTime());
    }
}
