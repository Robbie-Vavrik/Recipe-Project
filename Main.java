import java.util.*;

public class DinnerRecipes {
    // Scanner object for reading user input
    private static final Scanner scan = new Scanner(System.in);

    // Main method to start the dinner recipe interaction
    public void playDinnerRecipes() {
        dinnerLoop:
        while (true) {
            clearScreen();
            System.out.println("""
                    Welcome to the lunch recipe book!
                    Please select one of the following cuisine cultures:
                    	1. American
                    	2. British
                    	3. Mexican
                    	9. Exit
                    """);

            // Parse user's menu choice
            int choice = 0;
            choice = Integer.parseInt(scan.nextLine());

            // Perform action based on the user's choice
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
                    break dinnerLoop; // Exit the game loop
                default:
                    System.out.println("Invalid choice! Exiting...");
                    break dinnerLoop;
            }
        }
    }

    // Filters recipes based on allergies and handles selection and display
    private static void handleRecipes(List<Recipe> recipes) {
        System.out.println("Do you have any allergies? (comma separated, e.g., dairy,nuts) or press enter to skip:");
        String allergyInput = scan.nextLine().toLowerCase();

        // Convert input into a list of lowercase allergy keywords
        List<String> userAllergies = allergyInput.isBlank()
                ? new ArrayList<>()
                : List.of(allergyInput.split("\\s*,\\s*"));

        // Filter out recipes that contain any of the user's allergens
        List<Recipe> filtered = recipes.stream()
                .filter(recipe -> recipe.getAllergies().stream().noneMatch(userAllergies::contains))
                .toList();

        // Notify the user if no recipes remain
        if (filtered.isEmpty()) {
            System.out.println("No recipes found without your listed allergens.");
            return;
        }

        // List the available (filtered) recipe names
        System.out.println("Here are your recipe options:");
        for (int i = 0; i < filtered.size(); i++) {
            System.out.println((i + 1) + ". " + filtered.get(i).getName());
        }
        System.out.println((filtered.size() + 1) + ". Surprise me!"); // Add random option

        // Try to read the user's recipe choice
        int choice;
        try {
            choice = Integer.parseInt(scan.nextLine());
        } catch (NumberFormatException e) {
            choice = filtered.size() + 1; // Default to "surprise me"
        }

        // Pick the selected or a random recipe
        Recipe selected = (choice >= 1 && choice <= filtered.size())
                ? filtered.get(choice - 1)
                : filtered.get(new Random().nextInt(filtered.size()));

        // Display the recipe card
        selected.displayCard();

        // Ask for user feedback and offer alternative options
        System.out.println("Do you like this recipe? (yes/no)");
        if (scan.nextLine().equalsIgnoreCase("no")) {
            handleRecipes(filtered); 
        }
    }

    // Adds American dinner recipes and processes them
    private static void american() {
        List<Recipe> recipes = new ArrayList<>();
        recipes.add(new Recipe("Meatloaf", List.of("Ground Beef", "Breadcrumbs", "Onions", "Eggs"), 60,
                "A classic American comfort dish of seasoned beef loaf.", List.of("gluten", "eggs"), """
                _________
               |MEATLOAF|
               | CLASSIC|
               |_________|
                """));
        recipes.add(new Recipe("Mac and Cheese", List.of("Macaroni", "Cheddar Cheese", "Milk", "Butter"), 30,
                "Creamy baked macaroni and cheese.", List.of("dairy", "gluten"), """
                _________
               |  MAC & |
               | CHEESE |
               |_________|
                """));
        handleRecipes(recipes); 
    }

    // Adds British dinner recipes and processes them
    private static void british() {
        List<Recipe> recipes = new ArrayList<>();
        recipes.add(new Recipe("Shepherd’s Pie", List.of("Ground Lamb", "Potatoes", "Onions", "Carrots"), 45,
                "Baked meat pie topped with mashed potatoes.", List.of("none"), """
                _________
               |SHEPHERD|
               |  PIE   |
               |_________|
                """));
        recipes.add(new Recipe("Bangers and Mash", List.of("Sausages", "Mashed Potatoes", "Gravy"), 35,
                "Sausages served with mashed potatoes and gravy.", List.of("dairy"), """
                _________
               |BANGERS |
               |  MASH  |
               |_________|
                """));
        handleRecipes(recipes); 
    }

    // Adds Mexican dinner recipes and processes them
    private static void mexican() {
        List<Recipe> recipes = new ArrayList<>();
        recipes.add(new Recipe("Enchiladas", List.of("Tortillas", "Chicken", "Enchilada Sauce", "Cheese"), 40,
                "Rolled tortillas with filling, covered in sauce.", List.of("dairy", "gluten"), """
                _________
               |ENCHILAD|
               |  AS!   |
               |_________|
                """));
        recipes.add(new Recipe("Pozole", List.of("Pork", "Hominy", "Chili Peppers", "Lettuce", "Radishes"), 60,
                "A rich soup traditionally served with toppings.", List.of("none"), """
                _________
               | POZOLE |
               |  SOUP  |
               |_________|
                """));
        handleRecipes(recipes); 
    }

    // Clears the console 
    private static void clearScreen() {
        if (System.getProperty("os.name").toLowerCase().startsWith("windows")) {
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n");
        } else {
            System.out.print("\033[H\033[2J");
        }
        System.out.flush(); 
    }
}
