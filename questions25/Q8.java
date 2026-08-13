import java.util.Scanner;

public class Q8 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter percentage: ");
        double per = sc.nextDouble();

        if (per >= 90)
            System.out.println("Grade: A+");
        else if (per >= 80)
            System.out.println("Grade: A");
        else if (per >= 70)
            System.out.println("Grade: B");
        else if (per >= 60)
            System.out.println("Grade: C");
        else
            System.out.println("Fail");
    }
}