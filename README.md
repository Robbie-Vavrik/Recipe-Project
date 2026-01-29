# Tabletop Recipe System

Top-tier recipe management, evolved. Originally a Java console application for **IS 221**, this project has been modernized into a responsive **Web Dashboard**.

---

## 🌐 Web Dashboard (New!)
The **Tabletop Recipe Dashboard** is a single-page application (SPA) that brings the recipe experience to the browser with a premium, glassmorphism-inspired design.

### Web Features
- **Dynamic Filtering**: Instantly filter recipes by **Meal Type** (Breakfast, Lunch, Dinner) and **Cuisine** (American, British, Mexican).
- **Smart Allergy Handling**: Exclude recipes containing allergens (Dairy, Gluten, Nuts, Eggs, Meat) with real-time updates.
- **"Surprise Me" Mode**: Can't decide? Let the app pick a random recipe for you based on your current filters.
- **Premium UI**: 
    - Responsive Grid Layout.
    - Hover effects and smooth transitions.
    - Modal views for detailed recipe cards (Ingredients, ASCII Art, Cook Time).

### Web Tech Stack
- **HTML5**: Semantic structure.
- **CSS3**: Variables, Flexbox, Grid, and Glassmorphism styling.
- **JavaScript (ES6+)**: State management, DOM manipulation, and dynamic data rendering.

### Project Structure (Web)
- `index.html`: Main entry point.
- `style.css`: All styling and responsive design rules.
- `script.js`: Contains logic and the reconstructed recipe database.

---

## ☕ Java Console Version (Legacy)
The original **Java Tabletop Recipe System** is a simple, interactive command-line application designed to explore and showcase a variety of recipes.

### Legacy Features
- **Interactive Recipe Selection**: Console-based menu system.
- **OOP Principles**: Utilizes encapsulation and class abstraction.
- **Clear Screen**: Custom implementations for Windows/Unix terminals.

### Project Structure (Java)
- `Main.java`: Entry point.
- `BreakfastRecipes.java`, `LunchRecipes.java`, `DinnerRecipes.java`: Logic for specific meal categories.
- `Recipe.java`: Data model class.

---

## Credits & Authors

**Robert Vavrik**  
*Original Creator & Java Developer*  
Cybersecurity student | Java & Python developer  
Email: rvavrik@millikin.edu  
GitHub: [Robbie-Vavrik](https://github.com/Robbie-Vavrik)

**Antigravity**  
*AI Collaborator & Frontend Engineer*  
Responsible for porting the legacy Java logic to the Web, strictly adhering to modern UI/UX principles, and generating missing data assets.

## License

This project is licensed under the MIT License.  
You are free to use, modify, and distribute this project for educational purposes.
