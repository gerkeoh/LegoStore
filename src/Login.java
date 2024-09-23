import java.util.Scanner;

// Login option

public class Login {
    public static Customer login(Scanner scanner) {
        System.out.println("\nLogin");
        System.out.println("----------------------------------");
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        Customer customer = Customer.loadFromFile(name, password);

        if (customer != null) {
            System.out.println("Login successful. Welcome back, " + name + "!\n");
        } else {
            System.out.println("Invalid login credentials. Please try again or register.\n");
        }

        return customer;
    }
}
