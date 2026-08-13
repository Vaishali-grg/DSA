
import java.util.Scanner;

public class Q4 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int total = 0;

        for (int i = 1; i <= 5; i++) {
            System.out.print("Enter marks of subject " + i + ": ");
            int marks = sc.nextInt();

            total += marks;
        }

        double per = (total / 500.0) * 100;
        double avg = total / 5.0;

        System.out.println("Total Marks = " + total);
        System.out.println("Percentage = " + per + "%");
        System.out.println("Average = " + avg);
    }
}