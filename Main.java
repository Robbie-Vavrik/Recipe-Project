import java.util.*;

public class BreakfastRecipes {
    private static final Scanner scan = new Scanner(System.in);

    public void playBreakfastRecipes() {
        while (true) {
            clearScreen();
            System.out.println("""
                    Welcome to the breakfast recipe book!
                    Please select one of the following cuisine cultures:
                    	1. American
                    	2. British
                    	3. Mexican
                    	9. Exit
                    """);

            int choice = 0;
            choice = Integer.parseInt(scan.nextLine());
            // above removes extra newline & ensures an integer value

            switch (choice) {
                case 1:
                    american();
                    break;
                case 2:
                    british();
                    break;
                case 3:
                    mexican();
                    break;
                case 9:
                    System.out.println("Thanks for playing! Goodbye!");
                    break breakfastLoop;
                default:
                    System.out.println("Invalid choice! Exiting...");
                    break breakfastLoop;
            }
        }
    }


    private static void american() {

    }

    private static void british() {

    }

    private static void mexican() {

    }

    private static void clearScreen() {
        if (System.getProperty("os.name").toLowerCase().startsWith("windows")) {
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n");
        } else {
            System.out.print("\033[H\033[2J");
        }
        System.out.flush();
    }
}
