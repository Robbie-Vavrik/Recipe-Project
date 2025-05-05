import java.util.*;

public class BreakfastRecipes {
    private static final Scanner scan = new Scanner(System.in);

    public void playBreakfastRecipes() {
        breakfastLoop:
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
        recipes.add(new Recipe("Pancakes", List.of("Flour", "Eggs", "Milk", "Baking Powder", "Sugar"), 20,
                "Fluffy American-style pancakes with syrup.", List.of("gluten", "eggs", "dairy"), """
                        ____
                      /      \
                     |PANCAKES|
                       ______/
                    """));
        recipes.add(new Recipe("Bacon & Eggs", List.of("Bacon", "Eggs", "Salt", "Pepper"), 10,
                "Crispy bacon and eggs.", List.of("eggs"), """
                
                Bacon & Eggs
                """));
        handleRecipes(recipes);
    }

    private static void british() {
        List<Recipe> recipes = new ArrayList<>();
        recipes.add(new Recipe("Full English Breakfast", List.of("Bacon", "Eggs", "Tomatoes", "Mushrooms", "Sausage", "Beans"), 30,
                "A hearty traditional British breakfast.", List.of("eggs", "pork"), """
                
                FULL ENGLISH
                """));
        recipes.add(new Recipe("Beans on Toast", List.of("Bread", "Baked Beans"), 10,
                "Simple and filling British classic.", List.of("gluten"), """
                
                Beans on Toast
                """));
        handleRecipes(recipes);
    }

    private static void mexican() {
        List<Recipe> recipes = new ArrayList<>();
        recipes.add(new Recipe("Chilaquiles", List.of("Tortilla Chips", "Salsa", "Eggs", "Cheese"), 20,
                "Tortillas simmered in salsa, topped with eggs.", List.of("dairy", "eggs"), """
                
                Chilaquiles
                """));
        recipes.add(new Recipe("Huevos Rancheros", List.of("Eggs", "Tortilla", "Salsa"), 15,
                "Eggs served on tortilla with salsa.", List.of("eggs"), """
                
                Huevos Rancheros
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
