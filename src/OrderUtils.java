public class OrderUtils {
    public static void displayOrderDetails(Orders order) {
        Customer customer = order.getCustomer();
        System.out.println("Customer: " + (customer != null ? customer.getName() : ""));

        System.out.println("\nItems Purchased:");
        for (LegoSet set : order.getLegoSets()) {
            System.out.println(set.getName() + " - $" + set.getPrice());
        }
    }
}
