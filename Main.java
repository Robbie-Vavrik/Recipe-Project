import java.util.*;

public class BreakfastRecipes {
    // Scanner object used to read user input
    private static final Scanner scan = new Scanner(System.in);

    /**
     * Starts the breakfast recipe mini-game.
     * Prompts the user to select a cuisine culture or exit.
     * Filters and displays recipes based on the user's choice.
     */
    public void playBreakfastRecipes(List<Recipe> recipes) {
        while (true) {
            clearScreen(); // Clear the screen for a clean interface
            System.out.println("""
                    Welcome to the breakfast recipe book!
                    Please select one of the following cuisine cultures:
                    	1. American
                    	2. British
                    	3. Mexican
                    	9. Exit
                    """);

            int choice = Integer.parseInt(scan.nextLine()); // Read user input

            // Handle user selection
            switch (choice) {
                case 1:
                    american(recipes);
                    break;
                case 2:
                    british(recipes);
                    break;
                case 3:
                    mexican(recipes);
                    break;
                case 9:
                    System.out.println("Thanks for playing! Goodbye!");
                    return; // Exit the method
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    /**
     * Handles the filtering and selection of recipes based on allergies.
     * Displays filtered recipes and lets the user choose or get a random one.
     */
    private static void handleRecipes(List<Recipe> recipes) {
        // Ask the user about allergies
        System.out.println("Do you have any allergies? (comma separated, e.g., dairy,nuts) or press enter to skip:");
        String allergyInput = scan.nextLine().toLowerCase();

        // Put allergy input into a list
        List<String> userAllergies = allergyInput.isBlank()
                ? new ArrayList<>()
                : List.of(allergyInput.split("\\s*,\\s*"));

        // Filter recipes that don't contain any of the user's allergens
        List<Recipe> filtered = recipes.stream()
                .filter(recipe -> recipe.getAllergies().stream().noneMatch(userAllergies::contains))
                .toList();

        // If no recipes remain after filtering, notify the user
        if (filtered.isEmpty()) {
            System.out.println("No recipes found without your listed allergens.");
            return;
        }

        // Display available recipe choices
        System.out.println("Here are your recipe options:");
        for (int i = 0; i < filtered.size(); i++) {
            System.out.println((i + 1) + ". " + filtered.get(i).getName());
        }
        System.out.println((filtered.size() + 1) + ". Surprise me!"); // Option for random recipe

        // Get user choice
        int choice;
        try {
            choice = Integer.parseInt(scan.nextLine());
        } catch (NumberFormatException e) {
            // If input is invalid, default to "Surprise me"
            choice = filtered.size() + 1;
        }

        // Determine which recipe to show
        Recipe selected = (choice >= 1 && choice <= filtered.size())
                ? filtered.get(choice - 1)
                : filtered.get(new Random().nextInt(filtered.size()));

        // Display the selected recipe card
        selected.displayCard();

        // Ask user if they like the recipe; offer retry if not
        System.out.println("Do you like this recipe? (yes/no)");
        if (scan.nextLine().equalsIgnoreCase("no")) {
            handleRecipes(filtered); 
        }
    }

    // Displays American recipes using the common filtering handler
    private static void american(List<Recipe> recipes) {
        handleRecipes(recipes);
    }

    // Displays British recipes using the common filtering handler
    private static void british(List<Recipe> recipes) {
        handleRecipes(recipes);
    }

    // Displays Mexican recipes using the common filtering handler
    private static void mexican(List<Recipe> recipes) {
        handleRecipes(recipes);
    }

    /**
     * Clears the console screen to improve readability.
     * Uses platform-specific logic.
     */
    private static void clearScreen() {
        if (System.getProperty("os.name").toLowerCase().startsWith("windows")) {
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n");
        } else {
            System.out.print("\033[H\033[2J");
        }
        System.out.flush();
    }
}
