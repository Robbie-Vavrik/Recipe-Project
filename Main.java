import java.util.Scanner;

public class DinnerRecipes {

    private static final Scanner scan = new Scanner(System.in);

    public void playDinnerRecipes() {
        foodLoop:
        while (true) {
            clearScreen();
            System.out.println("""
                    Welcome to the Dinner recipe book!
                    Please select one of the following cuisine cultures:
                    \\t1. American\s
                    \\t2. British\s
                    \\t3. Mexican\s
                    \\t9. Exit
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
                    break foodLoop;
                default:
                    System.out.println("Invalid choice! Exiting...");
                    break foodLoop;
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
