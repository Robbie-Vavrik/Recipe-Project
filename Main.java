import java.util.Scanner;
import java.util.*;


public class Main {
    // scan is used as a class variable (not global) for now to handle input
    private static final Scanner scan = new Scanner(System.in);

    /**
     * A collection of Dice, Card, and other TableTop games.
     * Completed as spikes in IS 221: Programming Fundamentals
     * @param args Args are passed from the commandline (think flags)
     */
    public static void main(String[] args) {
        // Display main menu & get user choice (repeat until there is a correct choice)

        DinnerRecipes dinnerRecipes = new DinnerRecipes();
        LunchRecipes lunchRecipes = new LunchRecipes();
        BreakfastRecipes breakfastRecipes = new BreakfastRecipes();



        // Using label to break out of game - should use a function & return
        gameLoop:
        while (true) {
            clearScreen();
            System.out.println("""
                    Welcome to our little Game System!
                    Please select one of the following games:
                    \t1. Breakfast Recipes 
                    \t2. Lunch Recipes 
                    \t3. Dinner Recipes 
                    \t9. Exit
                    """);

            int choice = 0;
            choice = Integer.parseInt(scan.nextLine());
            // above removes extra newline & ensures an integer value

            switch (choice) {
                case 1:
                    breakfastRecipes.playBreakfastRecipes();
                    break;
                case 2:
                    lunchRecipes.playLunchRecipes();
                    break;
                case 3:
                    dinnerRecipes.playDinnerRecipes();
                    break;
                case 9:
                    System.out.println("Thanks for playing! Goodbye!");
                    break gameLoop;
                default:
                    System.out.println("Invalid choice! Exiting...");
                    break gameLoop;
            }
        }
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


