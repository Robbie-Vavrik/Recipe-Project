import java.util.*;

public class DinnerRecipes {
    private static final Scanner scan = new Scanner(System.in);

    public void playDinnerRecipes() {
        while (true) {
            clearScreen();
            System.out.println("""
                    Welcome to the dinner recipe book!
                    Please select one of the following cuisine cultures:
                    	1. American
                    	2. British
                    	3. Mexican
                    	9. Exit
                    """);

            int choice = Integer.parseInt(scan.nextLine());
            switch (choice) {
                case 1 -> american();
                case 2 -> british();
                case 3 -> mexican();
                case 9 -> {
                    System.out.println("Thanks for playing! Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid choice!");
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

    private static void clearScreen() {
        if (System.getProperty("os.name").toLowerCase().startsWith("windows")) {
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n");
        } else {
            System.out.print("\033[H\033[2J");
        }
        System.out.flush();
    }
}
