import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Orders implements Serializable {
    private Customer customer;
    private List<LegoSet> legoSets;
    private static List<Orders> orderHistory = new ArrayList<>();
    private static final String ORDERS_FOLDER = "../database/orders";

    public Orders(Customer customer) {
        this.customer = customer;
        this.legoSets = new ArrayList<>();
    }

    public void addLegoSet(LegoSet legoSet) {
        legoSets.add(legoSet);
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<LegoSet> getLegoSets() {
        return legoSets;
    }

    public static List<Orders> getOrderHistory() {
        return orderHistory;
    }

    public static void addToOrderHistory(Orders order) {
        orderHistory.add(order);
    }

    // View Orders

    public static void viewOrderFile(Customer customer) {
        String fileName = ORDERS_FOLDER + "/" + customer.getName() + "_order.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            System.out.println("\nOrder Details for " + customer.getName());
            System.out.println("-------------------------------------------------------");

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading order file: " + e.getMessage());
        }
    }

    // Save Orders

    public static void saveOrderToFile(Orders order) {
        String fileName = ORDERS_FOLDER + "/" + order.getCustomer().getName() + "_order.txt";

        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName, true))) {
            writer.println("\nCustomer: " + order.getCustomer().getName());
            writer.println("Items Purchased:");

            for (LegoSet set : order.getLegoSets()) {
                writer.println(set.getName() + " - $" + set.getPrice());
            }

            System.out.println("Order saved to file: " + fileName);
        } catch (IOException e) {
            System.err.println("Error saving order to file: " + e.getMessage());
        }
    }

    // Save Orders

    public static Orders loadOrderFromFile(String customerName) {
        String fileName = ORDERS_FOLDER + "/" + customerName + "_order.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            Orders order = new Orders(new Customer(customerName, "", "", "", "", 0, ""));
            String line;

            reader.readLine();

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            return order;
        } catch (IOException e) {

            return null;
        }
    }

    // Display Orders

    public static void displayOrderHistory(Customer customer) {
        System.out.println("\nOrder History");
        System.out.println("-------------------------------------------------------");
    
        if (orderHistory.isEmpty()) {
            System.out.println("No orders yet.");
        } else {
            for (Orders order : orderHistory) {
                if (customer == null || (order.getCustomer() != null && order.getCustomer().equals(customer))) {
                    displayOrderDetails(order);
                    System.out.println("---------------------");
                }
            }
        }
        if (customer != null) {
            viewOrderFile(customer);
        }
    }

    private static void displayOrderDetails(Orders order) {
        OrderUtils.displayOrderDetails(order);
    }
    
}
