import java.util.LinkedList;

public class OrientationTask1_5{

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

        public int getId() {
            return id;
        }

        public long getArrivalTime() {
            return arrivalTime;
        }

        public void setServiceStartTime(long time) {
            this.serviceStartTime = time;
        }

        public void setServiceEndTime(long time) {
            this.serviceEndTime = time;
        }

        public long getServiceTime() {
            return serviceEndTime - serviceStartTime;
        }

        public long getResponseTime() {
            return serviceEndTime - arrivalTime;
        }
    }

    static class ServicePoint {
        private LinkedList<Customer> queue = new LinkedList<>();

        public void addToQueue(Customer c) {
            queue.addLast(c);
        }


        public Customer removeFromQueue() {
            return queue.pollFirst();
        }

        // Serve customers one by one
        public void serve() {
            System.out.println("\n    Service started :))    ");
            while (!queue.isEmpty()) {
                Customer current = removeFromQueue();
                current.setServiceStartTime(System.nanoTime());

                // <rdm service time < 1500 ms
                int serviceTime = (int) (500 + Math.random() * 1000);
                System.out.println("Serving Customer " + current.getId() + " for " + serviceTime + " ms...");

                try {
                    Thread.sleep(serviceTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                current.setServiceEndTime(System.nanoTime());

                System.out.println("Customer " + current.getId() + " finished!");
                System.out.println("  Response time (wait + service): " + current.getResponseTime() + " ns");
                System.out.println("  Service time: " + current.getServiceTime() + " ns\n");
            }
            System.out.println(" All customers served ");
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
                System.out.println("Customer " + c.getId() + " added to queue.");
            }
        }
    }

    public static void main(String[] args) {
        ServicePoint sp = new ServicePoint();
        CustomerGenerator generator = new CustomerGenerator(sp);

        generator.generateCustomers(5); // create 5 custs
        sp.serve(); // serve all custs
    }
}