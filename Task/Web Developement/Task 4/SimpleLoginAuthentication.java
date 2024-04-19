import java.util.Scanner;

public class SimpleLoginAuthentication 
{
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password123";

    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Login Authentication System!");

        System.out.print("Enter username: ");
        String enteredUsername = scanner.nextLine();

        System.out.print("Enter password: ");
        String enteredPassword = scanner.nextLine();

        if (authenticate(enteredUsername, enteredPassword)) 
            System.out.println("Authentication successful. Welcome " + enteredUsername + "!");
        else 
            System.out.println("Invalid username or password. Please try again.");
        scanner.close();
    }
    
    private static boolean authenticate(String username, String password) 
    {
        return USERNAME.equals(username) && PASSWORD.equals(password);
    }
}