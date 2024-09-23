import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Basket {
    private List<LegoSet> setsInBasket;

    public Basket() {
        setsInBasket = new ArrayList<>();
    }

    public void addToBasket(LegoSet legoSet) {
        setsInBasket.add(legoSet);
    }

    public void displayBasket() {
        System.out.println("\nBasket Contents:");
        System.out.println("----------------------------------------");
        for (LegoSet set : getSetsInBasket()) {
            System.out.println(set.getName() + " - $" + set.getPrice());
        }
        System.out.println("Total Price: $" + calculateTotalPrice() + "\n");
    }

    public List<LegoSet> getSetsInBasket() {
        return setsInBasket;
    }

    public double calculateTotalPrice() {
        double totalPrice = 0.0;
        for (LegoSet set : getSetsInBasket()) {
            totalPrice += set.getPrice();
        }
        return totalPrice;
    }

    public void clearBasket() {
        getSetsInBasket().clear();
    }

    public void displayBasketMenu(Scanner scanner, Customer customer) {
        displayBasket();

        if (!getSetsInBasket().isEmpty()) {
            System.out.println("1. Pay");
        }

        System.out.println("2. Back to Main Menu");
        System.out.print("Enter your choice: ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                if (!getSetsInBasket().isEmpty()) {
                    processCardPayment(customer);
                } else {
                    System.out.println("Basket is empty. No items to pay for.");
                }
                break;
            case 2:
                System.out.println("Returning to the main menu...");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    private void processCardPayment(Customer customer) {
        System.out.println("\nCard Payment Processed Successfully!");

        Orders order = new Orders(customer);
        for (LegoSet set : getSetsInBasket()) {
            order.addLegoSet(set);
        }

        Orders.addToOrderHistory(order);
        Orders.saveOrderToFile(order);
        displayReceipt(customer);
        clearBasket();
    }

    private void displayReceipt(Customer customer) {
        System.out.println("\nReceipt:");
        System.out.println("---------------------");
        if (customer != null) {
            System.out.println("Customer: " + customer.getName());
            System.out.println("Contact Number: " + customer.getContactNumber());
            System.out.println("Payment Type: Credit Card");
        }

        System.out.println("\nItems Purchased:");
        for (LegoSet set : getSetsInBasket()) {
            System.out.println(set.getName() + " - $" + set.getPrice());
        }

        System.out.println("\nTotal Price: $" + calculateTotalPrice());
        System.out.println("Thank you for shopping with us!");
    }
}
