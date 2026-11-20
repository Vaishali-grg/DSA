package assessment;
import java.util.*;
public class CircularBufferRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int C = scanner.nextInt(); 
        int Q = scanner.nextInt(); 
        
        String[] arr = new String[C];
        int front = 0;
        int rear = 0;
        int size = 0;
        
        for (int i = 0; i < Q; i++) {
            String op = scanner.next();
            
            if (op.equals("ADD")) {
                String x = scanner.next();
                if (size == C) {
                    System.out.println("FULL");
                } else {
                    arr[rear] = x;
                    rear = (rear + 1) % C;
                    size++;
                }
            } 
            else if (op.equals("REMOVE")) {
                if (size == 0) {
                    System.out.println("EMPTY");
                } else {
                    System.out.println(arr[front]);
                    front = (front + 1) % C;
                    size--;
                }
            } 
            else if (op.equals("ROTATE")) {
                int k = scanner.nextInt();
                if (size > 1) {
                    k = k % size;
                    for (int j = 0; j < k; j++) {
                        String temp = arr[front];
                        front = (front + 1) % C;
                        arr[rear] = temp;
                        rear = (rear + 1) % C;
                    }
                }
            }
        }
        
        scanner.close();
    }
}