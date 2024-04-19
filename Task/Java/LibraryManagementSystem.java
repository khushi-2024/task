import java.util.*;

public class LibraryManagementSystem 
{   
    private static Map<String, String> books = new HashMap<>();
    private static List<String> borrowedBooks = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) 
    {
        while (true) 
        {
            System.out.println("Welcome to Digital Library Management System");
            System.out.println("1. Admin Login");
            System.out.println("2. User Login");
            System.out.println("3. Exit");
            
            int choice = scanner.nextInt();
            
            switch (choice) 
            {
                case 1: adminLogin();
                        break;
                case 2: userLogin();
                        break;
                case 3: System.out.println("Exiting the program. Goodbye!");
                        System.exit(0);
                        break;
                default:    System.out.println("Invalid choice. Please try again.");
                            break;
            }
        }
    }
    
    private static void adminLogin() 
    {
        System.out.println("Enter admin username:");
        String username = scanner.next();
        System.out.println("Enter admin password:");
        String password = scanner.next();
        
        if ("admin".equals(username) && "password".equals(password))
            adminMenu();
        else
            System.out.println("Invalid credentials. Please try again.");
    }
    
    private static void adminMenu() 
    {
        while (true) 
        {
            System.out.println("Admin Menu:");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. List All Books");
            System.out.println("4. Logout");
            
            int choice = scanner.nextInt();
            
            switch (choice) 
            {
                case 1: addBook();
                        break;
                case 2: removeBook();
                        break;
                case 3: listBooks();
                        break;
                case 4: return;
                default:System.out.println("Invalid choice. Please try again.");
                        break;
            }
        }
    }
    
    private static void addBook() 
    {
        System.out.println("Enter book ISBN:");
        String isbn = scanner.next();
        System.out.println("Enter book title:");
        String title = scanner.next();
        
        books.put(isbn, title);
        System.out.println("Book added successfully!");
    }
    
    private static void removeBook() 
    {
        System.out.println("Enter book ISBN to remove:");
        String isbn = scanner.next();
        
        if (books.containsKey(isbn)) 
        {
            books.remove(isbn);
            System.out.println("Book removed successfully!");
        } 
        else 
            System.out.println("Book not found!");
    }
    
    private static void listBooks() 
    {
        if (books.isEmpty())
            System.out.println("No books available.");
        else 
        {
            System.out.println("List of Books:");
            for (Map.Entry<String, String> entry : books.entrySet()) 
            {
                System.out.println("ISBN: " + entry.getKey() + ", Title: " + entry.getValue());
            }
        }
    }
    
    private static void userLogin() 
    {
        System.out.println("Enter user name:");
        String username = scanner.next();
        System.out.println("Enter password:");
        String password = scanner.next();
        
        if ("user".equals(username) && "password".equals(password))
            userMenu();
        else
            System.out.println("Invalid credentials. Please try again.");
    }
    
    private static void userMenu() 
    {
        while (true) 
        {
            System.out.println("User Menu:");
            System.out.println("1. Borrow a Book");
            System.out.println("2. Return a Book");
            System.out.println("3. List Borrowed Books");
            System.out.println("4. Logout");
            
            int choice = scanner.nextInt();
            
            switch (choice) 
            {
                case 1: borrowBook();
                        break;
                case 2: returnBook();
                        break;
                case 3: listBorrowedBooks();
                        break;
                case 4: return;
                default:    System.out.println("Invalid choice. Please try again.");
                            break;
            }
        }
    }
    
    private static void borrowBook() 
    {
        System.out.println("Enter book ISBN to borrow:");
        String isbn = scanner.next();
        
        if (books.containsKey(isbn)) 
        {
            borrowedBooks.add(books.get(isbn));
            System.out.println("Book borrowed successfully!");
        } 
        else 
            System.out.println("Book not found!");
    }
    
    private static void returnBook() 
    {
        System.out.println("Enter book title to return:");
        String title = scanner.next();
        
        if (borrowedBooks.contains(title)) 
        {
            borrowedBooks.remove(title);
            System.out.println("Book returned successfully!");
        } 
        else 
            System.out.println("Book not borrowed!");
    }
    
    private static void listBorrowedBooks() 
    {
        if (borrowedBooks.isEmpty()) 
            System.out.println("No books borrowed.");
        else 
        {
            System.out.println("List of Borrowed Books:");
            for (String book : borrowedBooks) 
            {
                System.out.println(book);
            }
        }
    }
}