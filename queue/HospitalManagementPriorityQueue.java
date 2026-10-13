package queue;
import java.util.PriorityQueue;

public class HospitalManagementPriorityQueue {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(3);
        pq.add(1);
        pq.add(2);
        pq.add(1);

        System.out.println("Highest priority waiting:" + pq.peek());
        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }
}