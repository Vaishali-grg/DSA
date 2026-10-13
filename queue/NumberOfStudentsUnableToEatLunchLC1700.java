package queue;
import java.util.LinkedList;
import java.util.Queue;

public class NumberOfStudentsUnableToEatLunchLC1700 {
    public static int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> q = new LinkedList<>();
        for (int student : students) q.add(student);
        int sI = 0;
        int rot = 0;
        while (!q.isEmpty() && rot < q.size()) {
            if (q.peek() == sandwiches[sI]) {
                q.poll();
                sI++;
                rot = 0;
            } else {
                q.add(q.poll());
                rot++;
            }
        }
        return q.size();
    }

    public static void main(String[] args) {
        int[] students = {1, 1, 0, 0};
        int[] sandwiches = {0, 1, 0, 1};
        System.out.println(countStudents(students, sandwiches));
    }
}