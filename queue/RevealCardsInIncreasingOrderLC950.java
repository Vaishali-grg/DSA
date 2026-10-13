package queue;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Arrays;

public class RevealCardsInIncreasingOrderLC950 {
    public static int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        int n = deck.length;
        int[] ans = new int[n];
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            q.add(i);
        }
        for (int card : deck) {
            int index = q.poll();
            ans[index] = card;
            if (!q.isEmpty()) {
                q.add(q.poll());
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] deck = {17, 13, 11, 2, 3, 5, 7};
        System.out.println(Arrays.toString(deckRevealedIncreasing(deck)));
    }
}