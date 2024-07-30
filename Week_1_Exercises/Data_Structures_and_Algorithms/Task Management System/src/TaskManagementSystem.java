import java.util.Scanner;
class Node {
    Task task;
    Node next;

    public Node(Task task) {
        this.task = task;
        this.next = null;
    }
}

public class TaskManagementSystem {
    private Node head;

    public TaskManagementSystem() {
        this.head = null;
    }

    // Method to add a task
    public void addTask(Task task) {
        Node newNode = new Node(task);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // Method to search a task by ID
    public Task searchTask(String taskId) {
        Node current = head;
        while (current != null) {
            if (current.task.getTaskId().equals(taskId)) {
                return current.task;
            }
            current = current.next;
        }
        return null; // Task not found
    }

    // Method to traverse and display all tasks
    public void traverseTasks() {
        Node current = head;
        while (current != null) {
            System.out.println(current.task);
            current = current.next;
        }
    }

    // Method to delete a task by ID
    public void deleteTask(String taskId) {
        if (head == null) {
            System.out.println("List is empty. Cannot delete.");
            return;
        }
        if (head.task.getTaskId().equals(taskId)) {
            head = head.next;
            return;
        }
        Node current = head;
        while (current.next != null && !current.next.task.getTaskId().equals(taskId)) {
            current = current.next;
        }
        if (current.next == null) {
            System.out.println("Task not found.");
        } else {
            current.next = current.next.next;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskManagementSystem tms = new TaskManagementSystem();

        while (true) {
            System.out.println("\nTask Management System Menu:");
            System.out.println("1. Add Task");
            System.out.println("2. Search Task");
            System.out.println("3. Traverse Tasks");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Task ID: ");
                    String taskId = scanner.nextLine();
                    System.out.print("Enter Task Name: ");
                    String taskName = scanner.nextLine();
                    System.out.print("Enter Task Status: ");
                    String status = scanner.nextLine();

                    Task task = new Task(taskId, taskName, status);
                    tms.addTask(task);
                    System.out.println("Task added successfully!!");
                    break;

                case 2:
                    System.out.print("Enter Task ID to search: ");
                    String searchId = scanner.nextLine();
                    Task searchedTask = tms.searchTask(searchId);
                    if (searchedTask != null) {
                        System.out.println(searchedTask);
                    } else {
                        System.out.println("Task not found.");
                    }
                    break;

                case 3:
                    System.out.println("All Tasks:");
                    tms.traverseTasks();
                    break;

                case 4:
                    System.out.print("Enter Task ID to delete: ");
                    String deleteId = scanner.nextLine();
                    tms.deleteTask(deleteId);
                    System.out.println("Task deleted successfully!!");
                    break;

                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
