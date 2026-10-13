package queue;
import java.util.LinkedList;
import java.util.Queue;

public class Dota2SenateLC649 {
    public static String predictPartyVictory(String senate) {
        Queue<Integer> r = new LinkedList<>();
        Queue<Integer> d = new LinkedList<>();
        int n = senate.length();
        for (int i = 0; i < n; i++) {
            if (senate.charAt(i) == 'R') {
                r.add(i);
            } else {
                d.add(i);
            }
        }
        while (!r.isEmpty() && !d.isEmpty()) {
            int rIdx = r.poll();
            int dIdx = d.poll();
            if (rIdx < dIdx) {
                r.add(rIdx + n);
            } else {
                d.add(dIdx + n);
            }
        }
        return r.isEmpty() ? "Dire" : "Radiant";
    }

    public static void main(String[] args) {
        String senate = "RD";
        System.out.println(predictPartyVictory(senate));
    }
}