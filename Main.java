import java.util.Scanner;

public class Main {
    private static final int SUBJECT_COUNT = 5;
    private static final double PASS_MARKS = 33.0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=================================");
        System.out.println("     STUDENT GRADE CALCULATOR");
        System.out.println("=================================");

        System.out.print("Enter student name: ");
        String studentName = sc.nextLine().trim();

        if (studentName.isEmpty()) {
            studentName = "Student";
        }

        double[] marks = new double[SUBJECT_COUNT];
        double total = 0;
        boolean passedAllSubjects = true;

        for (int i = 0; i < SUBJECT_COUNT; i++) {
            while (true) {
                System.out.print("Enter marks for subject " + (i + 1) + " (0-100): ");

                if (!sc.hasNextDouble()) {
                    System.out.println("Invalid input. Please enter a number.");
                    sc.next();
                    continue;
                }

                double value = sc.nextDouble();

                if (value < 0 || value > 100) {
                    System.out.println("Marks must be between 0 and 100.");
                    continue;
                }

                marks[i] = value;
                total += value;

                if (value < PASS_MARKS) {
                    passedAllSubjects = false;
                }
                break;
            }
        }

        double percentage = total / SUBJECT_COUNT;
        String grade;

        if (!passedAllSubjects) {
            grade = "F (Fail)";
        } else if (percentage >= 90) {
            grade = "A+";
        } else if (percentage >= 80) {
            grade = "A";
        } else if (percentage >= 70) {
            grade = "B";
        } else if (percentage >= 60) {
            grade = "C";
        } else if (percentage >= 50) {
            grade = "D";
        } else {
            grade = "E";
        }

        System.out.println("\n========== RESULT ==========");
        System.out.println("Student Name : " + studentName);
        System.out.println("Total Marks  : " + total + " / " + (SUBJECT_COUNT * 100));
        System.out.printf("Percentage   : %.2f%%%n", percentage);
        System.out.println("Grade        : " + grade);
        System.out.println("Result       : " + (passedAllSubjects ? "PASS" : "FAIL"));
        System.out.println("============================");

        sc.close();
    }
}
