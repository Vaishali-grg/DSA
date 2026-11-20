package assessment;
import java.util.*;
public class SlidingWindowMaximumWithDeque {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }
        Deque<Integer> dq = new ArrayDeque<>();
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < N; i++) {
            if (!dq.isEmpty() && dq.peekFirst() < i - K + 1) {
                dq.pollFirst();
            }
            while (!dq.isEmpty() && arr[dq.peekLast()] <= arr[i]) {
                dq.pollLast();
            }
            dq.addLast(i);
            if (i >= K - 1) {
                result.append(arr[dq.peekFirst()]);
                if (i < N - 1) {
                    result.append(" ");
                }
            }
        }
        
        System.out.println(result.toString());
        scanner.close();
    }
}