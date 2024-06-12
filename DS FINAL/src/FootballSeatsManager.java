import java.util.*;

public class FootballSeatsManager {
    static int Arroperations;
    static int LLOperations;
    static int Qop;
    static int HMapOperations;
    static long arrayListTime;
    static long linkedListTime;
    static long queueTime;
    static long hashMapTime;

    public static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    public static void ArrayListTest(int totalSeat, int reservedSeat, int ticketsToBuy) {
        long start = System.nanoTime();
        ArrayList<Integer> allTotalSeat = new ArrayList<>(Collections.nCopies(totalSeat, 0));

        for (int i = 0; i < reservedSeat; i++) {
            int randomNum = getRandomNumber(0, totalSeat);
            while (allTotalSeat.get(randomNum) == 1) {
                randomNum = getRandomNumber(0, totalSeat);
            }
            allTotalSeat.set(randomNum, 1);
        }

        System.out.println("Initial seats:");
        for (Integer integer : allTotalSeat) {
            System.out.print(integer + " ");
        }
        System.out.println();

        for (int i = 0; i < ticketsToBuy; i++) {
            boolean ticketBought = false;
            for (int j = 0; j < allTotalSeat.size(); j++) {
                if (allTotalSeat.get(j) == 0) {
                    Arroperations++;
                    allTotalSeat.set(j, 1);
                    System.out.println("Ticket purchased for seat: " + j);
                    ticketBought = true;
                    break;
                }
            }
            if (!ticketBought) {
                System.out.println("No available seats for ticket " + (i + 1));
                break;
            }
        }

        System.out.println("Final seats:");
        for (Integer integer : allTotalSeat) {
            System.out.print(integer + " ");
        }
        System.out.println();

        long finish = System.nanoTime();
        arrayListTime = finish - start;

        System.out.println(arrayListTime + " nanoseconds");
        System.out.println("Array: " + Arroperations);
    }

    public static void LinkedListTest(int totalSeat, int reservedSeat, int ticketsToBuy) {
        long start = System.nanoTime();
        LinkedList<Integer> allTotalSeat = new LinkedList<>(Collections.nCopies(totalSeat, 0));

        for (int i = 0; i < reservedSeat; i++) {
            int randomNum = getRandomNumber(0, totalSeat);
            while (allTotalSeat.get(randomNum) == 1) {
                randomNum = getRandomNumber(0, totalSeat);
            }
            allTotalSeat.set(randomNum, 1);
        }

        System.out.println("Initial seats:");
        for (Integer integer : allTotalSeat) {
            System.out.print(integer + " ");
        }
        System.out.println();

        for (int i = 0; i < ticketsToBuy; i++) {
            boolean ticketBought = false;
            for (int j = 0; j < allTotalSeat.size(); j++) {
                if (allTotalSeat.get(j) == 0) {
                    LLOperations++;
                    allTotalSeat.set(j, 1);
                    System.out.println("Ticket purchased for seat: " + j);
                    ticketBought = true;
                    break;
                }
            }
            if (!ticketBought) {
                System.out.println("No available seats for ticket " + (i + 1));
                break;
            }
        }

        System.out.println("Final seats:");
        for (Integer integer : allTotalSeat) {
            System.out.print(integer + " ");
        }
        System.out.println();

        long finish = System.nanoTime();
        linkedListTime = finish - start;

        System.out.println(linkedListTime + " nanoseconds");
        System.out.println("LinkedList: " + LLOperations);
    }

    public static void QueueTest(int totalSeat, int reservedSeat, int ticketsToBuy) {
        long start = System.nanoTime();
        Queue<Integer> allTotalSeat = new LinkedList<>();
        for (int i = 0; i < totalSeat; i++) {
            allTotalSeat.add(0);
        }

        List<Integer> tempList = new ArrayList<>(allTotalSeat);
        for (int i = 0; i < reservedSeat; i++) {
            int randomNum = getRandomNumber(0, totalSeat);
            while (tempList.get(randomNum) == 1) {
                randomNum = getRandomNumber(0, totalSeat);
            }
            tempList.set(randomNum, 1);
        }
        allTotalSeat.clear();
        allTotalSeat.addAll(tempList);

        System.out.println("Initial seats:");
        for (Integer integer : allTotalSeat) {
            System.out.print(integer + " ");
        }
        System.out.println();

        tempList = new ArrayList<>(allTotalSeat);
        for (int i = 0; i < ticketsToBuy; i++) {
            boolean ticketBought = false;
            for (int j = 0; j < tempList.size(); j++) {
                if (tempList.get(j) == 0) {
                    Qop++;
                    tempList.set(j, 1);
                    System.out.println("Ticket purchased for seat: " + j);
                    ticketBought = true;
                    break;
                }
            }
            if (!ticketBought) {
                System.out.println("No available seats for ticket " + (i + 1));
                break;
            }
        }
        allTotalSeat.clear();
        allTotalSeat.addAll(tempList);

        System.out.println("Final seats:");
        for (Integer integer : allTotalSeat) {
            System.out.print(integer + " ");
        }
        System.out.println();

        long finish = System.nanoTime();
        queueTime = finish - start;

        System.out.println(queueTime + " nanoseconds");
        System.out.println("Queue: " + Qop);
    }

    public static void HashMapTest(int totalSeat, int reservedSeat, int ticketsToBuy) {
        long start = System.nanoTime();
        HashMap<Integer, Integer> allTotalSeat = new HashMap<>();
        for (int i = 0; i < totalSeat; i++) {
            allTotalSeat.put(i, 0);
        }

        for (int i = 0; i < reservedSeat; i++) {
            int randomNum = getRandomNumber(0, totalSeat);
            while (allTotalSeat.get(randomNum) == 1) {
                randomNum = getRandomNumber(0, totalSeat);
            }
            allTotalSeat.put(randomNum, 1);
        }

        System.out.println("Initial seats:");
        for (int i = 0; i < totalSeat; i++) {
            System.out.print(allTotalSeat.get(i) + " ");
        }
        System.out.println();

        for (int i = 0; i < ticketsToBuy; i++) {
            boolean ticketBought = false;
            for (int j = 0; j < allTotalSeat.size(); j++) {
                if (allTotalSeat.get(j) == 0) {
                    HMapOperations++;
                    allTotalSeat.put(j, 1);
                    System.out.println("Ticket purchased for seat: " + j);
                    ticketBought = true;
                    break;
                }
            }
            if (!ticketBought) {
                System.out.println("No available seats for ticket " + (i + 1));
                break;
            }
        }

        System.out.println("Final seats:");
        for (int i = 0; i < totalSeat; i++) {
            System.out.print(allTotalSeat.get(i) + " ");
        }
        System.out.println();

        long finish = System.nanoTime();
        hashMapTime = finish - start;

        System.out.println(hashMapTime + " nanoseconds");
        System.out.println("HashMap: " + HMapOperations);
    }
}
