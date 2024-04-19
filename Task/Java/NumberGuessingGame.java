import java.util.*;

public class NumberGuessingGame 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int secretNumber = random.nextInt(101);
        int attempts = 0;
        boolean hasGuessedCorrectly = false;
        
        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("Guess a number between 0 and 100:");

        while (!hasGuessedCorrectly) 
        {
            int guess = scanner.nextInt();
            attempts++;

            if (guess < secretNumber) 
                System.out.println("Too low! Try again:");
            else if (guess > secretNumber)
                System.out.println("Too high! Try again:");
            else
                hasGuessedCorrectly = true;
        }
        System.out.println("Congratulations! You've guessed the number " + secretNumber + " in " + attempts + " attempts.");
        scanner.close();
    }
}