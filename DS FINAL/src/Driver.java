public class Driver {
    public static void main(String[] args) {
        // Initialize parameters
        int totalSeat = 1000;
        int reservedSeat = 100;
        int ticketsToBuy = 800; // Adjust this value as needed

        System.out.println("ArrayList Test:");
        FootballSeatsManager.ArrayListTest(totalSeat, reservedSeat, ticketsToBuy);

        System.out.println("LinkedList Test:");
        FootballSeatsManager.LinkedListTest(totalSeat, reservedSeat, ticketsToBuy);

        System.out.println("Queue Test:");
        FootballSeatsManager.QueueTest(totalSeat, reservedSeat, ticketsToBuy);

        System.out.println("HashMap Test:");
        FootballSeatsManager.HashMapTest(totalSeat, reservedSeat, ticketsToBuy);

        System.out.println("\nSummary of Execution Times:");
        System.out.println("For a Total Seat of" + totalSeat + "," + reservedSeat + "Researved Seat," + ticketsToBuy+ ("Seat Bought"));
        System.out.println("ArrayList Time: " + FootballSeatsManager.arrayListTime + " nanoseconds");
        System.out.println("LinkedList Time: " + FootballSeatsManager.linkedListTime + " nanoseconds");
        System.out.println("Queue Time: " + FootballSeatsManager.queueTime + " nanoseconds");
        System.out.println("HashMap Time: " + FootballSeatsManager.hashMapTime + " nanoseconds");
    }
}
