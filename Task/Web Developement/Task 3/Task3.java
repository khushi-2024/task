import java.util.ArrayList;
import java.util.Scanner;

public class Task3 
{
    private ArrayList<String> tasks;

    public Task3() 
    {
        this.tasks = new ArrayList<>();
    }

    public void addTask(String task) 
    {
        tasks.add(task);
        System.out.println("Task added successfully!");
    }

    public void displayTasks() 
    {
        if (tasks.isEmpty()) 
            System.out.println("No tasks added yet!");
        else 
        {
            System.out.println("Tasks:");
            for (int i = 0; i < tasks.size(); i++) 
            {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }

    public static void main(String[] args) 
    {
        Task3 toDoList = new Task3();
        Scanner scanner = new Scanner(System.in);

        while (true) 
        {
            System.out.println("\nTo-Do List App");
            System.out.println("1. Add Task");
            System.out.println("2. Display Tasks");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) 
            {
                case 1: System.out.print("Enter task: ");
                        String task = scanner.nextLine();
                        toDoList.addTask(task);
                        break;
                case 2: toDoList.displayTasks();
                        break;
                case 3: System.out.println("Exiting the program!");
                        scanner.close();
                        System.exit(0);
                        break;
                default: System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}