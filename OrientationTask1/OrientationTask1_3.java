public class OrientationTask1_3 {

    static class Customer {
        private static int nextId = 1; // static ka unique id atwk
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

        public void setStartTime(long startTime) {
            this.startTime = startTime;
        }

        public long getEndTime() {
            return endTime;
        }

        public void setEndTime(long endTime) {
            this.endTime = endTime;
        }

        public long getTimeSpent() {
            return endTime - startTime;
        }

        public void printDetails() {
            System.out.println("Customer ID: " + id);
            System.out.println("Customer " + id + " Start Time: " + startTime + " ms");
            System.out.println("Customer " + id + " End Time: " + endTime + " ms");
            System.out.println("Customer " + id + " Total Time Spent: " + getTimeSpent() + " ms" +"\n");
        }
    }

    public static void main(String[] args) {

        Customer c1 = new Customer(System.currentTimeMillis());
        sleep(500); //0.5s
        c1.setEndTime(System.currentTimeMillis());

        Customer c2 = new Customer(System.currentTimeMillis());
        sleep(700); //0.7s
        c2.setEndTime(System.currentTimeMillis());

        c1.printDetails();
        c2.printDetails();
    }

    // helper method to pause execution
    private static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}