import java.util.Scanner;

public class Help {
    public static void displayHelp() {
        System.out.println("\nHelp and Support");
        System.out.println("----------------------------------");
        System.out.println("If you need assistance, please contact our customer support at support@legostore.com");
        System.out.println("Press Enter to return to the main menu...");
        
        // Wait for user to press Enter
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }
}
