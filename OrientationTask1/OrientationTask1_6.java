import java.util.LinkedList;

public class OrientationTask1_6 {

    static class Customer {
        private static int nextId = 1;
        private int id;
        private long arrivalTime;
        private long serviceStartTime;
        private long serviceEndTime;

        public Customer(long arrivalTime) {
            this.id = nextId++;
            this.arrivalTime = arrivalTime;
        }

        public int getId() { return id; }
        public long getArrivalTime() { return arrivalTime; }

        public void setServiceStartTime(long time) { this.serviceStartTime = time; }
        public void setServiceEndTime(long time) { this.serviceEndTime = time; }

        public long getServiceTimeNs() { return serviceEndTime - serviceStartTime; }

        public long getResponseTimeNs() { return serviceEndTime - arrivalTime; }
    }

    static class ServicePoint {
        private LinkedList<Customer> queue = new LinkedList<>();

        private long sumServiceTimeNs = 0;
        private int servedCount = 0;

        public void addToQueue(Customer c) {
            queue.addLast(c);
        }

        public Customer removeFromQueue() {
            return queue.pollFirst();
        }

        // Serve all custs in queue
        public void serve() {
            System.out.println("\n--- Service started ---");
            while (!queue.isEmpty()) {
                Customer current = removeFromQueue();

                current.setServiceStartTime(System.nanoTime());

                // <rdm service time < 1500 ms
                int serviceMillis = (int) (500 + Math.random() * 1000);
                System.out.println("Serving Customer " + current.getId() + " for " + serviceMillis + " ms...");

                try {
                    Thread.sleep(serviceMillis);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                current.setServiceEndTime(System.nanoTime());

                long serviceNs = current.getServiceTimeNs();
                long responseNs = current.getResponseTimeNs();

                sumServiceTimeNs += serviceNs;
                servedCount++;

                System.out.println("Customer " + current.getId() + " finished!");
                System.out.println("  Service time: " + serviceNs + " ns (" + (serviceNs / 1_000_000.0) + " ms)");
                System.out.println("  Response time (wait + service): " + responseNs + " ns (" + (responseNs / 1_000_000.0) + " ms)\n");
            }
            System.out.println("--- All customers served ---");

            // print average service time for this ServicePoint
            if (servedCount > 0) {
                double avgServiceNs = (double) sumServiceTimeNs / servedCount;
                double avgServiceMs = avgServiceNs / 1_000_000.0;
                System.out.println("Average service time: " + (long)avgServiceNs + " ns (" + String.format("%.3f", avgServiceMs) + " ms) over " + servedCount + " customers.");
            } else {
                System.out.println("No customers served, average service time undefined.");
            }
        }
    }

    static class CustomerGenerator {
        private ServicePoint servicePoint;

        public CustomerGenerator(ServicePoint sp) {
            this.servicePoint = sp;
        }

        public void generateCustomers(int count) {
            System.out.println("Generating " + count + " customers...");
            for (int i = 0; i < count; i++) {
                Customer c = new Customer(System.nanoTime());
                servicePoint.addToQueue(c);
                System.out.println("  Customer " + c.getId() + " added to queue.");
            }
        }
    }

    public static void main(String[] args) {
        // run the whole generate+serve sequence multiple times
        int runs = 3;               // no of full runs
        int customersPerRun = 5;    // customers per run

        for (int run = 1; run <= runs; run++) {
            System.out.println("\n ------- RUN " + run + "-------");
            ServicePoint sp = new ServicePoint();
            CustomerGenerator gen = new CustomerGenerator(sp);

            gen.generateCustomers(customersPerRun);
            sp.serve();
        }
    }
}