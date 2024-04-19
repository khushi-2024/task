import java.util.*;

public class OnlineExamSystem 
{
    private static String username;
    private static String password;
    private static int score = 0;
    private static Timer timer;

    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Online Examination System!");

        login(scanner);
        updateProfileAndPassword(scanner);
        startExam(scanner);
        scanner.close();
    }

    private static void login(Scanner scanner) 
    {
        System.out.println("Please login to continue.");
        System.out.print("Enter username: ");
        username = scanner.nextLine();

        System.out.print("Enter password: ");
        password = scanner.nextLine();

        if (!"admin".equals(username) || !"password".equals(password)) 
        {
            System.out.println("Invalid username or password. Please try again.");
            login(scanner);
        } 
        else
            System.out.println("Login successful!");
    }

    private static void updateProfileAndPassword(Scanner scanner) 
    {
        System.out.println("Would you like to update your profile or password? (yes/no)");
        String choice = scanner.nextLine();

        if ("yes".equalsIgnoreCase(choice)) 
        {
            System.out.println("Update Profile:");
            System.out.print("Enter new username: ");
            username = scanner.nextLine();

            System.out.print("Enter new password: ");
            password = scanner.nextLine();
        }
    }

    private static void startExam(Scanner scanner) 
    {
        System.out.println("Exam started! You have 5 minutes to complete the exam.");

        timer = new Timer();
        timer.schedule(new TimerTask() 
        {
            @Override
            public void run() 
            {
                submitExam();
            }
        }, 5 * 60 * 1000);

        String[] questions = 
        {
            "1. What is the capital of India?\nA. London\nB. Paris\nC. Berlin\nD. Delhi",
            "2. Who is the President of India ?\nA. Charles Dickens\nB. William Shakespeare\nC. Narendra Modi\nD. Mark Twain"
        };

        String[] answers = {"B", "B"};

        for (int i = 0; i < questions.length; i++) 
        {
            System.out.println(questions[i]);
            System.out.print("Enter your answer (A/B/C/D): ");
            String userAnswer = scanner.nextLine().toUpperCase();

            if (userAnswer.equals(answers[i])) 
                score++;
        }
        submitExam();
    }

    private static void submitExam() 
    {
        timer.cancel();
        System.out.println("Exam submitted!");

        System.out.println("Your score: " + score + "/" + 2); 
        logout();
    }

    private static void logout() 
    {
        System.out.println("Logout successful! Thank you for giving the exam.");
        System.exit(0);
    }
}
