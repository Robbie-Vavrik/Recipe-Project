import java.util.List;

public class Recipe {
    private final String name;
    private final List<String> ingredients;
    private final int cookTimeMinutes;
    private final String description;
    private final List<String> allergies;
    private final String asciiArt;

    public Recipe(String name, List<String> ingredients, int cookTimeMinutes,
                  String description, List<String> allergies, String asciiArt) {
        this.name = name;
        this.ingredients = ingredients;
        this.cookTimeMinutes = cookTimeMinutes;
        this.description = description;
        this.allergies = allergies;
        this.asciiArt = asciiArt;
    }

    public void displayCard() {
        System.out.println("===================================");
        System.out.println("RECIPE: " + name);
        System.out.println("-----------------------------------");
        System.out.println("Description: " + description);
        System.out.println("Cook Time: " + cookTimeMinutes + " minutes");
        System.out.println("Ingredients:");
        for (String ingredient : ingredients) {
            System.out.println("   - " + ingredient);
        }
        if (!allergies.isEmpty()) {
            System.out.println("Allergens: " + String.join(", ", allergies));
        }
        System.out.println("-----------------------------------");
        System.out.println(asciiArt);
        System.out.println("===================================");
    }

    public List<String> getAllergies() {
        return allergies;
    }

    public String getName() {
        return name;
    }
}
