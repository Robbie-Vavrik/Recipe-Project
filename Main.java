import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.io.*;

public class Main {
    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        DinnerRecipes dinnerRecipes = new DinnerRecipes();
        LunchRecipes lunchRecipes = new LunchRecipes();
        BreakfastRecipes breakfastRecipes = new BreakfastRecipes();

        // Load recipes from file
        List<Recipe> recipes = loadRecipesFromFile("recipes.txt");

        // Using label to break out of game loop
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

            switch (choice) {
                case 1:
                    breakfastRecipes.playBreakfastRecipes(recipes);
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

    private static List<Recipe> loadRecipesFromFile(String filename) {
        List<Recipe> recipes = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                String name = data[0];
                List<String> ingredients = List.of(data[1].split(" "));
                int cookTime = Integer.parseInt(data[6]);
                String description = data[7];
                List<String> allergies = List.of(data[8].split(" "));
                String asciiArt = data[9];

                Recipe recipe = new Recipe(name, ingredients, cookTime, description, allergies, asciiArt);
                recipes.add(recipe);
            }
        } catch (IOException e) {
            System.out.println("Error reading recipes file: " + e.getMessage());
        }
        return recipes;
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
