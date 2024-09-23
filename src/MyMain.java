import java.util.Scanner;

public class MyMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Basket basket = new Basket();
        ProductList productList = new ProductList(scanner, basket);
        Customer customer = null;

        // Welcome page options 

        int welcomeChoice;
        do {
            System.out.println("Welcome to the Lego Store!");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. About");
            System.out.println("4. Help");
            System.out.println("0. Exit");
            System.out.print("Please choose one of these options: ");

            welcomeChoice = scanner.nextInt();
            scanner.nextLine();

            switch (welcomeChoice) {
                case 1:
                    customer = Customer.register(scanner);
                    break;
                case 2:
                    customer = Login.login(scanner);
                    break;
                case 3:
                    About.displayAbout();
                    break;
                case 4:
                    Help.displayHelp();
                    break;
                case 0:
                    System.out.println("Exiting the program...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            // Continue to the main menu if the user is registered or logged in
            if (customer != null) {
                int mainChoice;

                do {
                    System.out.println("\nWelcome to the Shop!");
                    System.out.println("--------------------");
                    System.out.println("1. Product List");
                    System.out.println("2. Basket");
                    System.out.println("3. Orders");
                    System.out.println("4. Account");
                    System.out.println("5. About");
                    System.out.println("6. Help");
                    System.out.println("7. Logout");
                    System.out.println("0. Exit");
                    System.out.print("Enter your choice: ");

                    mainChoice = scanner.nextInt();
                    scanner.nextLine();

                    switch (mainChoice) {
                        case 1:
                            productList.displayProductList();
                            break;
                        case 2:
                            basket.displayBasketMenu(scanner, customer);
                            break;
                        case 3:
                            handleOrdersOption(scanner, customer);
                            break;
                        case 4:
                            handleAccountOption(scanner, customer);
                            break;
                        case 5:
                            About.displayAbout();
                            break;
                        case 6:
                            Help.displayHelp();
                            break;
                        case 7:
                            System.out.println("Logging out...\n");
                            customer = null;
                            break;
                        case 0:
                            System.out.println("Exiting the program...");
                            break;
                        default:
                            System.out.println("Invalid choice. Please try again.");
                    }

                } while (mainChoice != 0 && customer != null);
            }

        } while (welcomeChoice != 0);

        scanner.close();
    }

    // Orders

    private static void handleOrdersOption(Scanner scanner, Customer customer) {
        System.out.println("\nOrder Details:");
        System.out.println("--------------------");

        if (customer != null) {
            Orders.viewOrderFile(customer);
        } else {
            System.out.println("Please log in to view your order details.");
        }
    }

    // Account options

    private static void handleAccountOption(Scanner scanner, Customer customer) {
        int accountChoice;
        do {
            System.out.println("\nAccount Options:");
            System.out.println("----------------");
            System.out.println("1. Display Account Information");
            System.out.println("2. Update Account Details");
            System.out.println("3. Back to Main Menu");
            System.out.print("Enter your choice: ");

            accountChoice = scanner.nextInt();
            scanner.nextLine();
            switch (accountChoice) {
                case 1:
                    customer.displayAccountInfo();
                    break;
                case 2:
                    customer.updateAccountDetails(scanner);
                break;
                case 3:
                    System.out.println("Returning to the main menu...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (accountChoice != 3);
    }
}
