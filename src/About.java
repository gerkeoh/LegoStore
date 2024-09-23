import java.util.Scanner;

public class About {
    public static void displayAbout() {
        System.out.println("\nAbout This Application");
        System.out.println("----------------------------------");
        System.out.println("Welcome to the Lego Store Application!");
        System.out.println("Version: 1.0");
        System.out.println("Developed by: Gerard Keohane, R00228234");
        System.out.println("Description: This application allows users to browse and purchase Lego sets!");
        System.out.println("             Users can also update their account details and view their order history.");
        System.out.println("Press Enter to return to the main menu...");
        
        // Wait for user to press Enter
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }
}
