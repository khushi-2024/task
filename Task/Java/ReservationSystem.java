import java.util.*;

public class ReservationSystem 
{
    private static Map<String, Boolean> rooms = new HashMap<>();

    public static void main(String[] args) 
    {
        initializeRooms();
        Scanner scanner = new Scanner(System.in);

        while (true) 
        {
            System.out.println("Welcome to the Hotel Reservation System");
            System.out.println("1. Book a room");
            System.out.println("2. Cancel a reservation");
            System.out.println("3. View available rooms");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) 
            {
                case 1:
                    bookRoom(scanner);
                    break;
                case 2:
                    cancelReservation(scanner);
                    break;
                case 3:
                    viewAvailableRooms();
                    break;
                case 4:
                    System.out.println("Thank you for using the Hotel Reservation System.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void initializeRooms() 
    {
        for (int i = 1; i <= 10; i++) 
        {
            rooms.put("Room " + i, true);
        }
    }

    private static void bookRoom(Scanner scanner) 
    {
        System.out.println("Available Rooms:");
        viewAvailableRooms();

        System.out.print("Enter room number to book (e.g., Room 1): ");
        String room = scanner.next();

        if (rooms.containsKey(room) && rooms.get(room)) 
        {
            rooms.put(room, false);
            System.out.println(room + " has been booked successfully.");
        } 
        else 
        {
            System.out.println("Room is not available or invalid room number.");
        }
    }

    private static void cancelReservation(Scanner scanner) 
    {
        System.out.print("Enter room number to cancel reservation (e.g., Room 1): ");
        String room = scanner.next();

        if (rooms.containsKey(room) && !rooms.get(room)) 
        {
            rooms.put(room, true);
            System.out.println(room + " reservation has been canceled.");
        } 
        else 
        {
            System.out.println("Invalid room number or no reservation found.");
        }
    }

    private static void viewAvailableRooms() 
    {
        for (Map.Entry<String, Boolean> entry : rooms.entrySet()) 
        {
            if (entry.getValue()) 
            {
                System.out.println(entry.getKey());
            }
        }
    }
}