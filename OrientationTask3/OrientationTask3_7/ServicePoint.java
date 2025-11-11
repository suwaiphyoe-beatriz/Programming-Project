package OrientationTask3_7;

import java.util.LinkedList;
import java.util.Queue;

public class ServicePoint {
    private Queue<Customer> queue = new LinkedList<>();

    public void add(Customer c) {
        queue.add(c);
    }

    public Customer serve(double currentTime) {
        Customer c = queue.poll();
        if (c != null) {
            c.departure = currentTime;
        }
        return c;
    }

    public boolean hasCustomers() {
        return !queue.isEmpty();
    }
}

