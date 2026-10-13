package queue.deque;
import java.util.ArrayDeque;
import java.util.Deque;

public class ReverseStringUsingDeque {
    public static void main(String[] args) {
        String s = "Hello";
        Deque<Character> dq = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            dq.addFirst(s.charAt(i));
        }
        StringBuilder result = new StringBuilder();
        while (!dq.isEmpty()) {
            result.append(dq.removeFirst());
        }
        System.out.println("Original list: " + s);
        System.out.println("Reversed list: " + result);
    }
}