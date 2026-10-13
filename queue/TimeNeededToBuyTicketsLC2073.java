package queue;
import java.util.LinkedList;
import java.util.Queue;

public class TimeNeededToBuyTicketsLC2073 {
    public static int timeRequiredToBuy(int[] tickets, int k) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < tickets.length; i++) {
            q.add(i);
        }
        int time = 0;
        while (true) {
            int person = q.poll();
            tickets[person]--;
            time++;
            if (person == k && tickets[person] == 0) return time;
            if (tickets[person] > 0) q.add(person);
        }
    }

    public static void main(String[] args) {
        int[] tickets = {2, 3, 2};
        int k = 2;
        System.out.println(timeRequiredToBuy(tickets, k));
    }
}