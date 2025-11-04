import java.util.LinkedList;
import java.util.Scanner;

public class OrientationTask1_4 {

    static class Customer {
        private static int nextId = 1;
        private int id;
        private long startTime;
        private long endTime;

        public Customer(long startTime) {
            this.id = nextId++;
            this.startTime = startTime;
        }

        public int getId() {
            return id;
        }

        public long getStartTime() {
            return startTime;
        }

        public void setEndTime(long endTime) {
            this.endTime = endTime;
        }

        public long getTimeSpent() {
            return endTime - startTime;
        }

        public void printTimeSpent() {
            System.out.println("Customer " + id + " Time spent in queue: " + getTimeSpent() + " ns");
        }

        @Override
        public String toString() {
            return "Customer ID: " + id + " | Start: " + startTime + " ns";
        }
    }

    public static void main(String[] args) {
        LinkedList<Customer> queue = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("OrientationTask1_4");
        System.out.println("Commands:");
        System.out.println("1 - Add customer to queue");
        System.out.println("2 - (Dequeue) Remove customer from queue");
        System.out.println("3 - Show queue");//extra just want to practice
        System.out.println("0 - Exit program");//extra just to pt

        while (running) {
            System.out.print("\nEnter command: ");
            int command = scanner.nextInt();

            switch (command) {
                case 1 -> { // Add (queue)
                    Customer newCustomer = new Customer(System.nanoTime());
                    queue.addFirst(newCustomer);
                    System.out.println("Added " + newCustomer);
                }

                case 2 -> { // Remove (dequeue)
                    if (queue.isEmpty()) {
                        System.out.println("Queue is empty! Nothing to remove.");
                    } else {
                        Customer removed = queue.removeLast();
                        removed.setEndTime(System.nanoTime());
                        removed.printTimeSpent();
                    }
                }

                case 3 -> { // Display queue (can check already add or rm the q><)
                    if (queue.isEmpty()) {
                        System.out.println("Queue is empty.");
                    } else {
                        System.out.println("Current queue (front → back):");
                        for (Customer c : queue) {
                            System.out.println("  " + c);
                        }
                    }
                }

                case 0 -> {
                    running = false;
                    System.out.println("Exiting program. Goodbye!");
                }

                default -> System.out.println("Invalid command. Please try again.");
            }
        }

        scanner.close();
    }
}