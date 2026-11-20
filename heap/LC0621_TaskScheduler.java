package heap;

import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class LC0621_TaskScheduler {
    public static int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char task : tasks) {
            freq[task - 'A']++;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int f : freq) {
            if (f > 0) pq.offer(f);
        }
        Queue<int[]> cooldown = new LinkedList<>();
        int time = 0;
        while (!pq.isEmpty() || !cooldown.isEmpty()) {
            time++;
            if (!cooldown.isEmpty() && cooldown.peek()[1] <= time) {
                int[] ready = cooldown.poll();
                pq.offer(ready[0]);
            }
            if (!pq.isEmpty()) {
                int remaining = pq.poll();
                remaining--;
                if (remaining > 0) {
                    cooldown.offer(new int[]{remaining, time + n + 1});
                }
            }
        }
        return time;
    }

    public static void main(String[] args) {
        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
        int n = 2;
        System.out.println("Least Interval Time: " + leastInterval(tasks, n));
    }
}