import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class User {
    private String username;
    private String password;
    private UserType type;

    public User(String username, String password, UserType type) {
        this.username = username;
        this.password = password;
        this.type = type;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public UserType getType() {
        return type;
    }
}

enum UserType {
    ADMIN,
    USER
}

public class usermang1 {
    private static Map<String, User> users = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Sign Up");
            System.out.println("2. Log In");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    signUp(scanner);
                    break;
                case 2:
                    logIn(scanner);
                    break;
                case 3:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void signUp(Scanner scanner) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        System.out.print("Enter user type (ADMIN or USER): ");
        String userTypeString = scanner.nextLine().toUpperCase();
        UserType userType = UserType.valueOf(userTypeString);

        if (users.containsKey(username)) {
            System.out.println("Username already exists. Please choose another one.");
        } else {
            User user = new User(username, password, userType);
            users.put(username, user);
            System.out.println("User created successfully.");
        }
    }

    private static void logIn(Scanner scanner) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        User user = users.get(username);
        if (user != null && user.getPassword().equals(password)) {
            System.out.println("Login successful. Welcome, " + user.getUsername() + "!");
            System.out.println("User type: " + user.getType());
        } else {
            System.out.println("Invalid username or password.");
        }
    }
}
