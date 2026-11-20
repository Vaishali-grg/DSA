package assessment;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ServiceDeskQueue {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int Q = scanner.nextInt();

        Queue<Integer> queue = new LinkedList<>();
        
        for (int i = 0; i < Q; i++) {
            String op = scanner.next();
            if (op.equals("JOIN")) {
                int ticket = scanner.nextInt();
                queue.add(ticket);
            } 
            else if (op.equals("SERVE")) {
                if (queue.isEmpty()) {
                    System.out.println("EMPTY");
                } else {
                    System.out.println(queue.poll());
                }
            } 
            else if (op.equals("CANCEL")) {
                int ticket = scanner.nextInt();
                queue.remove(Integer.valueOf(ticket));
            }
        }
        scanner.close();

    }
}
