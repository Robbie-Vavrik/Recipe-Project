import java.util.*;

public class LunchRecipes {
    private static final Scanner scan = new Scanner(System.in);

    public void playLunchRecipes() {
        lunchLoop:
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
                    break lunchLoop;
                default:
                    System.out.println("Invalid choice! Exiting...");
                    break lunchLoop;
            }
        }
    }

    private static void handleRecipes(List<Recipe> recipes) {
        System.out.println("Do you have any allergies? (comma separated, e.g., dairy,nuts) or press enter to skip:");
        String allergyInput = scan.nextLine().toLowerCase();
        List<String> userAllergies = allergyInput.isBlank() ? new ArrayList<>() : List.of(allergyInput.split("\\s*,\\s*"));

        List<Recipe> filtered = recipes.stream()
                .filter(recipe -> recipe.getAllergies().stream().noneMatch(userAllergies::contains))
                .toList();

        if (filtered.isEmpty()) {
            System.out.println("No recipes found without your listed allergens.");
            return;
        }

        System.out.println("Here are your recipe options:");
        for (int i = 0; i < filtered.size(); i++) {
            System.out.println((i + 1) + ". " + filtered.get(i).getName());
        }
        System.out.println((filtered.size() + 1) + ". Surprise me!");

        int choice;
        try {
            choice = Integer.parseInt(scan.nextLine());
        } catch (NumberFormatException e) {
            choice = filtered.size() + 1;
        }

        Recipe selected = (choice >= 1 && choice <= filtered.size()) ? filtered.get(choice - 1)
                : filtered.get(new Random().nextInt(filtered.size()));

        selected.displayCard();

        System.out.println("Do you like this recipe? (yes/no)");
        if (scan.nextLine().equalsIgnoreCase("no")) {
            handleRecipes(filtered);
        }
    }

    private static void american() {
        List<Recipe> recipes = new ArrayList<>();
        recipes.add(new Recipe("Grilled Cheese Sandwich", List.of("Bread", "Cheddar Cheese", "Butter"), 10,
                "Toasted bread with melted cheese in the middle.", List.of("gluten", "dairy"), """
                _________
               | GRILLED |
               | CHEESE  |
               |_________|
                """));
        recipes.add(new Recipe("Chicken Caesar Wrap", List.of("Tortilla", "Chicken", "Lettuce", "Caesar Dressing"), 15,
                "Chicken Caesar salad wrapped in a tortilla.", List.of("gluten", "dairy"), """
               _________
              | WRAP IT |
              |  UP!    |
              |_________|
                """));
        handleRecipes(recipes);
    }

    private static void british() {
        List<Recipe> recipes = new ArrayList<>();
        recipes.add(new Recipe("Ploughman’s Lunch", List.of("Cheese", "Bread", "Pickles", "Apple"), 15,
                "A cold lunch with cheese, pickles, and bread.", List.of("dairy", "gluten"), """
                _________
               |PLOUGHMAN|
               | LUNCH  |
               |_________|
                """));
        recipes.add(new Recipe("Cornish Pasty", List.of("Pastry", "Beef", "Potatoes"), 25,
                "A meat and vegetable filled pastry.", List.of("gluten"), """
                _________
               | PASTY  |
               | PLEASE |
               |_________|
                """));
        handleRecipes(recipes);
    }

    private static void mexican() {
        List<Recipe> recipes = new ArrayList<>();
        recipes.add(new Recipe("Tacos", List.of("Tortilla", "Ground Beef", "Cheese", "Lettuce", "Tomatoes"), 20,
                "Classic Mexican tacos with toppings.", List.of("dairy"), """
                _________
               | TACOS  |
               | YUM!   |
               |_________|
                """));
        recipes.add(new Recipe("Quesadilla", List.of("Tortilla", "Cheese", "Chicken"), 15,
                "Grilled tortilla with cheese and chicken.", List.of("dairy"), """
                _________
               |QUESADIL|
               |  LA!   |
               |_________|
                """));
        handleRecipes(recipes);
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
