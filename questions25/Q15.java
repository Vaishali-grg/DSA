import java.util.Scanner;

class Student {

    int id;
    String name;
    String course;
    double marks;

    void inputDetails() {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter ID: ");
        id = sc.nextInt();

        sc.nextLine();

        System.out.print("Enter name: ");
        name = sc.nextLine();

        System.out.print("Enter course: ");
        course = sc.nextLine();

        System.out.print("Enter marks: ");
        marks = sc.nextDouble();
    }

    void displayDetails() {

        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Course: " + course);
        System.out.println("Marks: " + marks);
    }

    void calculateGrade() {

        if (marks >= 90)
            System.out.println("Grade: A+");
        else if (marks >= 80)
            System.out.println("Grade: A");
        else if (marks >= 70)
            System.out.println("Grade: B");
        else if (marks >= 60)
            System.out.println("Grade: C");
        else
            System.out.println("Grade: Fail");
    }
}

public class Q15 {

    public static void main(String[] args) {

        Student s = new Student();

        s.inputDetails();

        System.out.println("\nStudent Details:");
        s.displayDetails();

        s.calculateGrade();
    }
}