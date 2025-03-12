import java.util.Scanner;

public class Main {
    // scan is used as a class variable (not global) for now to handle input
    private static final Scanner scan = new Scanner(System.in);


    public static void main(String[] args) {

        int choice = 0;
        while (choice < 1 || choice > 3) {
            clearScreen();
            System.out.println("""
                    Welcome to our recipe book
                    Please select which meal your eating:
                    \t1. Breakfast
                    \t2. Lunch
                    \t3. Dinner
                    """);

            choice = scan.nextInt();
            scan.nextLine(); // remove extra newline

            if (choice >= 3 && choice > 1) {
                System.out.print("Thanks for making a correct choice");
                break;
            }
        }

        switch (choice) {
            case 1:
                breakfastRecipes();
                break;
            case 2:
                lunchRecipes();
                break;
            case 3:
                dinnerRecipes();
                break;
            default:
                System.out.println("Invalid choice! Exiting...");
                break;
        }
    }
    private static void  breakfastRecipes(){

    }

    private static void  lunchRecipes(){

    }

    private static void  dinnerRecipes(){

    }

    private static void clearScreen() {
        // System has a few cool methods including one that gets the OS name
        if (System.getProperty("os.name").toLowerCase().startsWith("windows")) {
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n");
        } else {
            // This works in Linux and ....Mac?
            System.out.print("\033[H\033[2J");
        }
        // Always flush when you use escape codes or use too many newlines
        System.out.flush();

    }
}


