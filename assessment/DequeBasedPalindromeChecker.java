package assessment;
import java.util.*;
public class DequeBasedPalindromeChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        
        Deque<Character> dq = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                dq.addLast(Character.toLowerCase(c));
            }
        }
        
        boolean isPalindrome = true;
        while (dq.size() > 1) {
            if (dq.removeFirst() != dq.removeLast()) {
                isPalindrome = false;
                break;
            }
        }
        
        if (isPalindrome) {
            System.out.println("PALINDROME");
        } else {
            System.out.println("NOT PALINDROME");
        }
        sc.close();
    }
}