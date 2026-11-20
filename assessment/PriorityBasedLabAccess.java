package assessment;
import java.util.*;
public class PriorityBasedLabAccess {
    static class Request {
        String id;
        int priority;
        long order;

        Request(String id, int priority, long order) {
            this.id = id;
            this.priority = priority;
            this.order = order;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int Q = scanner.nextInt();
        
        PriorityQueue<Request> pq = new PriorityQueue<>((a, b) -> {
            if (a.priority != b.priority) {
                return Integer.compare(a.priority, b.priority);
            }
            return Long.compare(a.order, b.order);
        });
        
        long counter = 0;
        
        for (int i = 0; i < Q; i++) {
            String op = scanner.next();
            
            if (op.equals("REQUEST")) {
                String id = scanner.next();
                int priority = scanner.nextInt();
                pq.offer(new Request(id, priority, counter++));
            } 
            else if (op.equals("NEXT")) {
                if (pq.isEmpty()) {
                    System.out.println("EMPTY");
                } else {
                    System.out.println(pq.poll().id);
                }
            }
        }
        
        scanner.close();
    }
}