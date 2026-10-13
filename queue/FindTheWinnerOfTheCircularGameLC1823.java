package queue;
import java.util.LinkedList;
import java.util.Queue;

public class FindTheWinnerOfTheCircularGameLC1823 {
    public static int findTheWinner(int n, int k) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            q.add(i);
        }
        while (q.size() > 1) {
            for (int i = 1; i < k; i++) {
                q.add(q.poll());
            }
            q.poll();
        }
        return q.peek();
    }

    public static void main(String[] args) {
        int n = 5, k = 2;
        System.out.println(findTheWinner(n, k));
    }
}