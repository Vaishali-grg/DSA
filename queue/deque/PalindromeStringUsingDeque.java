package queue.deque;
import java.util.ArrayDeque;
import java.util.Deque;

public class PalindromeStringUsingDeque {
    public static void main(String[] args) {
        String s = "Hello";
        Deque<Character> dq = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            dq.addLast(s.charAt(i));
        }
        StringBuilder result = new StringBuilder();
        while (!dq.isEmpty()) {
            result.append(dq.removeLast());
        }

        if (s.contentEquals(result)) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not a Palindrome");
        }
    }
}