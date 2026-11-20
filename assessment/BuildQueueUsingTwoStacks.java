package assessment;
import java.util.*;

public class BuildQueueUsingTwoStacks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int Q = scanner.nextInt();
        
        Stack<String> s1 = new Stack<>(); 
        Stack<String> s2 = new Stack<>();
        
        for (int i = 0; i < Q; i++) {
            String op = scanner.next();
            
            if (op.equals("ENQUEUE")) {
                String x = scanner.next();
                s1.push(x);
            } 
            else if (op.equals("DEQUEUE")) {
                if (s2.isEmpty()) {
                    while (!s1.isEmpty()) {
                        s2.push(s1.pop());
                    }
                }
                
                if (s2.isEmpty()) {
                    System.out.println("EMPTY");
                } else {
                    System.out.println(s2.pop());
                }
            } 
            else if (op.equals("FRONT")) {
                if (s2.isEmpty()) {
                    while (!s1.isEmpty()) {
                        s2.push(s1.pop());
                    }
                }
                if (s2.isEmpty()) {
                    System.out.println("EMPTY");
                } else {
                    System.out.println(s2.peek());
                }
            }
        }
        scanner.close();
    }
}