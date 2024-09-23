import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Customer {
    private String name;
    private String contactNumber;
    private String cardPin;
    private String nameOnCard;
    private String expiryDate;
    private int securityPin;
    private String password;
    private List<Orders> orderHistory;
    
    private static Scanner scanner = new Scanner(System.in);

    public Customer(String name, String contactNumber, String cardPin, String nameOnCard, String expiryDate, int securityPin, String password) {
        this.name = name;
        this.contactNumber = contactNumber;
        this.cardPin = cardPin;
        this.nameOnCard = nameOnCard;
        this.expiryDate = expiryDate;
        this.securityPin = securityPin;
        this.password = password;
        this.orderHistory = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getCardPin() {
        return cardPin;
    }

    public String getNameOnCard() {
        return nameOnCard;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public int getSecurityPin() {
        return securityPin;
    }

    public String getPassword() {
        return password;
    }

    public List<Orders> getOrderHistory() {
        return orderHistory;
    }

    public void addToOrderHistory(Orders order) {
        orderHistory.add(order);
    }

    public Orders placeOrder() {
        Orders order = new Orders(this);
        orderHistory.add(order);
        return order;
    }

    // Display Account info

    public void displayAccountInfo() {
        System.out.println("\nAccount Information");
        System.out.println("----------------------------------");
        System.out.println("Name: " + name);
        System.out.println("Contact Number: " + contactNumber);
        System.out.println("Card Pin: " + cardPin);
        System.out.println("Name on Card: " + nameOnCard);
        System.out.println("Expiry Date: " + expiryDate);
        System.out.println("Security Pin: *** ");
        System.out.println("Password: ***");

        if (!orderHistory.isEmpty()) {
            System.out.println("\nOrder History:");
            for (Orders order : orderHistory) {
                displayOrderDetails(order);
            }
        }
    }

    // Update Account info

    public void updateAccountDetails(Scanner scanner) {
        System.out.println("\nUpdate Account Details");
        System.out.println("----------------------");
        System.out.print("Enter your current password to proceed: ");
        String currentPassword = scanner.nextLine();
    
        if (currentPassword.equals(password)) {
            boolean isUpdating = true;
            while (isUpdating) {
                System.out.println("\nChoose an option to update:");
                System.out.println("1. Name");
                System.out.println("2. Contact Number");
                System.out.println("3. Card Pin");
                System.out.println("4. Name on Card");
                System.out.println("5. Expiry Date");
                System.out.println("6. Security Pin");
                System.out.println("0. Finish updating and go back to Account menu");
    
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine();
    
                switch (choice) {
                    case 1:
                        System.out.print("Enter your new name: ");
                        String newName = scanner.nextLine();
                        if (!newName.isEmpty()) {
                            this.name = newName;
                            System.out.println("Name updated successfully!");
                        } else {
                            System.out.println("Name not updated. Field is empty.");
                        }
                        break;
                
                    case 2:
                        System.out.print("Enter your new contact number: ");
                        String newContactNumber = scanner.nextLine();
                        if (!newContactNumber.isEmpty()) {
                            this.contactNumber = newContactNumber;
                            System.out.println("Contact number updated successfully!");
                        } else {
                            System.out.println("Contact number not updated. Field is empty.");
                        }
                        break;
                
                    case 3:
                        System.out.print("Enter your new card pin: ");
                        String newCardPin = scanner.nextLine();
                        if (!newCardPin.isEmpty()) {
                            this.cardPin = newCardPin;
                            System.out.println("Card pin updated successfully!");
                        } else {
                            System.out.println("Card pin not updated. Field is empty.");
                        }
                        break;
                
                    case 4:
                        System.out.print("Enter your new name on card: ");
                        String newNameOnCard = scanner.nextLine();
                        if (!newNameOnCard.isEmpty()) {
                            this.nameOnCard = newNameOnCard;
                            System.out.println("Name on card updated successfully!");
                        } else {
                            System.out.println("Name on card not updated. Field is empty.");
                        }
                        break;
                
                    case 5:
                        System.out.print("Enter your new expiry date: ");
                        String newExpiryDate = scanner.nextLine();
                        if (!newExpiryDate.isEmpty()) {
                            this.expiryDate = newExpiryDate;
                            System.out.println("Expiry date updated successfully!");
                        } else {
                            System.out.println("Expiry date not updated. Field is empty.");
                        }
                        break;
                
                    case 6:
                        System.out.print("Enter your new security pin: ");
                        int newSecurityPin = scanner.nextInt();
                        scanner.nextLine();
                        this.securityPin = newSecurityPin;
                        System.out.println("Security pin updated successfully!");
                        break;

                    case 7:
                        System.out.print("Enter your new password: ");
                        String newPassword = scanner.nextLine();
                        if (!newPassword.isEmpty()) {
                            this.password = newPassword;
                            System.out.println("Password updated successfully!");
                        } else {
                            System.out.println("Password not updated. Field is empty.");
                        }
                        break;
                    
                    case 0:
                        isUpdating = false;
                        System.out.println("Account details updated successfully!");
                        saveToFile(this);
                        break;
                
                    default:
                        System.out.println("Invalid choice. Please enter a valid option.");
                        break;
                }
                
            }
        } else {
            System.out.println("Incorrect password. Account details not updated.");
        }
    }

    // Register
    
    public static Customer register(Scanner scanner) {
        System.out.println("\nRegister");
        System.out.println("----------------------------------");
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.print("Enter your contact number: ");
        String contactNumber = scanner.nextLine();
        System.out.print("Enter your card pin: ");
        String cardPin = scanner.nextLine();
        System.out.print("Enter your name on card: ");
        String nameOnCard = scanner.nextLine();
        System.out.print("Enter your expiry date: ");
        String expiryDate = scanner.nextLine();
        System.out.print("Enter your security pin: ");
        int securityPin = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        Customer newCustomer = new Customer(name, contactNumber, cardPin, nameOnCard, expiryDate, securityPin, password);
        System.out.println("Registration successful. Welcome, " + name + "!\n");

        saveToFile(newCustomer);

        return newCustomer;
    }

    // Find Customer info
    
    public static Customer loadFromFile(String name, String password) {
        try {
            try (BufferedReader reader = new BufferedReader(new FileReader("../database/customer_info.txt"))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] customerInfo = line.split(",");
                    if (customerInfo.length >= 7 && customerInfo[0].equals(name) && customerInfo[6].equals(password)) {
                        String contactNumber = customerInfo[1];
                        String cardPin = customerInfo[2];
                        String nameOnCard = customerInfo[3];
                        String expiryDate = customerInfo[4];
                        int securityPin = Integer.parseInt(customerInfo[5]);
    
                        Customer customer = new Customer(name, contactNumber, cardPin, nameOnCard, expiryDate, securityPin, password);
    
                        return customer;
                    }
                }
            }
    
            return null;
        } catch (Exception e) {
            System.err.println("Error loading customer information from file: " + e.getMessage());
        }
        return null;
    }
    
    // Order Display in OrderUtils.java

    private static void displayOrderDetails(Orders order) {
        OrderUtils.displayOrderDetails(order);
    }    

    // Save Customer into to file

    public static void saveToFile(Customer customer) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("../database/customer_info.txt", true))) {
            writer.write(customer.getName() + "," +
                    customer.getContactNumber() + "," +
                    customer.getCardPin() + "," +
                    customer.getNameOnCard() + "," +
                    customer.getExpiryDate() + "," +
                    customer.getSecurityPin() + "," +
                    customer.getPassword());
    
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Error saving customer information to file: " + e.getMessage());
        }
    }
    
}

