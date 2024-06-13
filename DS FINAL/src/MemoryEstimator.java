import java.util.*;

public class MemoryEstimator {

    public static void main(String[] args) {
        int totalSeat = 100;
        int reservedSeat = 20;
        int ticketsToBuy = 10;

        // Estimate memory usage for ArrayList
        ArrayList<Integer> arrayList = new ArrayList<>(Collections.nCopies(totalSeat, 0));
        long arrayListSize = 12 + 4 * totalSeat + 24 * totalSeat; // 12 bytes for header, 4 bytes per reference, 24 bytes per Integer object
        System.out.println("Estimated ArrayList memory usage: " + arrayListSize + " bytes");

        // Estimate memory usage for LinkedList
        LinkedList<Integer> linkedList = new LinkedList<>(Collections.nCopies(totalSeat, 0));
        long linkedListSize = 12 + totalSeat * (24 + 4 * 2); // 12 bytes for header, 24 bytes per Integer object, 4 bytes per reference to next and previous node
        System.out.println("Estimated LinkedList memory usage: " + linkedListSize + " bytes");

        // Estimate memory usage for Queue (LinkedList)
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < totalSeat; i++) {
            queue.add(0);
        }
        long queueSize = 12 + totalSeat * (24 + 4 * 2); // 12 bytes for header, 24 bytes per Integer object, 4 bytes per reference to next and previous node
        System.out.println("Estimated Queue memory usage: " + queueSize + " bytes");

        // Estimate memory usage for HashMap
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < totalSeat; i++) {
            hashMap.put(i, 0);
        }
        long hashMapSize = 12 + totalSeat * (32 + 24 + 24); // 12 bytes for header, 32 bytes per entry overhead, 24 bytes per key (Integer), 24 bytes per value (Integer)
        System.out.println("Estimated HashMap memory usage: " + hashMapSize + " bytes");
    }
}
