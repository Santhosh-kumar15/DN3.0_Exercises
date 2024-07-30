import java.util.Scanner;

public class MVCPatternExample {
    public static void main(String[] args) {
        // Create initial student data
        Student student = new Student();
        student.setId("1");
        student.setName("John Doe");
        student.setGrade("A");

        // Create the view
        StudentView view = new StudentView();

        // Create the controller
        StudentController controller = new StudentController(student, view);

        // Initial display of student details
        System.out.println("Initial Student Details:");
        controller.updateView();

        // Input for updating student details
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nEnter new student name:");
        String name = scanner.nextLine();
        controller.setStudentName(name);

        System.out.println("Enter new student ID:");
        String id = scanner.nextLine();
        controller.setStudentId(id);

        System.out.println("Enter new student grade:");
        String grade = scanner.nextLine();
        controller.setStudentGrade(grade);

        // Display updated student details
        System.out.println("\nUpdated Student Details:");
        controller.updateView();

        scanner.close();
    }
}
