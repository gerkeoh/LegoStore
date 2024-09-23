import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductList {
    private List<LegoTheme> themes;
    private Scanner scanner;
    private Basket basket;

    public ProductList(Scanner scanner, Basket basket) {
        this.scanner = scanner;
        this.basket = basket;
        themes = new ArrayList<>();

        // Lego Harry Potter theme
        LegoTheme harryPotterTheme = new LegoTheme("Lego Harry Potter");
        harryPotterTheme.addSet(new LegoSet("The Whomping Willow Adventure", 60.00, "Lego Harry Potter"));
        harryPotterTheme.addSet(new LegoSet("Hogwarts Attack", 20.00, "Lego Harry Potter"));
        themes.add(harryPotterTheme);

        // Lego Star Wars theme
        LegoTheme starWarsTheme = new LegoTheme("Lego Star Wars");
        starWarsTheme.addSet(new LegoSet("Millenium Falcon", 120.00, "Lego Star Wars"));
        starWarsTheme.addSet(new LegoSet("Tie Bomber", 70.00, "Lego Star Wars"));
        themes.add(starWarsTheme);

        // Lego Ninjago theme
        LegoTheme ninjagoTheme = new LegoTheme("Lego Ninjago");
        ninjagoTheme.addSet(new LegoSet("Ninja Mech", 50.00, "Lego Ninjago"));
        ninjagoTheme.addSet(new LegoSet("Dragon Battle", 90.00, "Lego Ninjago"));
        themes.add(ninjagoTheme);

        // Lego City theme
        LegoTheme cityTheme = new LegoTheme("Lego City");
        cityTheme.addSet(new LegoSet("Police Station", 80.00, "Lego City"));
        cityTheme.addSet(new LegoSet("Fire Truck", 40.00, "Lego City"));
        themes.add(cityTheme);

        // Lego Batman theme
        LegoTheme batmanTheme = new LegoTheme("Lego Batman");
        batmanTheme.addSet(new LegoSet("Batmobile", 100.00, "Lego Batman"));
        batmanTheme.addSet(new LegoSet("Joker's Lair", 60.00, "Lego Batman"));
        themes.add(batmanTheme);

        // Lego Duplo theme
        LegoTheme duploTheme = new LegoTheme("Lego Duplo");
        duploTheme.addSet(new LegoSet("Farm Animals", 30.00, "Lego Duplo"));
        duploTheme.addSet(new LegoSet("My First Train", 25.00, "Lego Duplo"));
        themes.add(duploTheme);
    }

    public void displayProductList() {
        do {
            System.out.println("\nProduct List:");
            System.out.println("--------------------");
            int i = 1;
            System.out.println("1. Home Menu");
            for (LegoTheme theme : themes) {
                System.out.println((i + 1) + ". " + theme.getName());
                i++;
            }
            System.out.println("0. Exit");
            System.out.print("Enter the number of the theme (or 1 to go home, 0 to exit): ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.println("\nGoing back to Home Menu...\n");
                break;
            } else if (choice > 1 && choice <= themes.size() + 1) {
                displaySets(themes.get(choice - 2));
                System.out.print("Enter the number of the set to add to the basket (or 0 to go back): ");
                int setChoice = scanner.nextInt();
                scanner.nextLine();

                if (setChoice >= 1 && setChoice <= themes.get(choice - 2).getSets().size()) {
                    LegoSet selectedSet = themes.get(choice - 2).getSets().get(setChoice - 1);
                    basket.addToBasket(selectedSet);
                    System.out.println("\nAdded to Basket:");
                    System.out.println("-------------------------------");
                    System.out.println(selectedSet.getName() + "\n");
                } else if (setChoice != 0) {
                    System.out.println("Invalid choice. Please try again.\n");
                }
            } else if (choice != 0) {
                System.out.println("Invalid choice. Please try again.\n");
            }

        } while (true);
    }

    private void displaySets(LegoTheme theme) {
        System.out.println("\nSets in " + theme.getName() + ":");
        System.out.println("--------------------------------");
        int i = 1;
        for (LegoSet set : theme.getSets()) {
            System.out.println(i + ". " + set.getName() + " - $" + set.getPrice());
            i++;
        }
    }
}