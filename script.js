// Recipe Data
const recipes = [
    // --- Breakfast ---
    {
        id: 1,
        name: "Fluffy Pancakes",
        meal: "breakfast",
        cuisine: "american",
        ingredients: ["Flour", "Milk", "Eggs", "Butter", "Syrup"],
        cookTime: 20,
        description: "Classic fluffy American pancakes served with syrup.",
        allergies: ["gluten", "dairy", "eggs"],
        asciiArt: `
   (  )   (   )  )
    ) (   )  (  (
    ( )  (    ) )
   _____________
  |  PANCAKES   |
  |_____________|
        `
    },
    {
        id: 2,
        name: "Bacon and Eggs",
        meal: "breakfast",
        cuisine: "american",
        ingredients: ["Bacon", "Eggs", "Toast", "Butter"],
        cookTime: 15,
        description: "A hearty breakfast staple with crispy bacon.",
        allergies: ["eggs", "gluten", "dairy", "meat"],
        asciiArt: `
    __  ______
   /  |/  /   |
  / /|_/ / /| |
 /_/  /_/ ___ |
        `
    },
    {
        id: 3,
        name: "Full English",
        meal: "breakfast",
        cuisine: "british",
        ingredients: ["Eggs", "Sausage", "Bacon", "Beans", "Toast"],
        cookTime: 25,
        description: "The complete traditional British breakfast experience.",
        allergies: ["eggs", "gluten", "meat"],
        asciiArt: `
   __________
  |   FULL   |
  | ENGLISH  |
  |__________|
        `
    },
    {
        id: 4,
        name: "Beans on Toast",
        meal: "breakfast",
        cuisine: "british",
        ingredients: ["Baked Beans", "Toast", "Butter"],
        cookTime: 10,
        description: "Simple, comforting, and quintessentially British.",
        allergies: ["gluten", "dairy"],
        asciiArt: `
    ______
   (______)
   |BEANS |
   |______|
        `
    },
    {
        id: 5,
        name: "Huevos Rancheros",
        meal: "breakfast",
        cuisine: "mexican",
        ingredients: ["Tortilla", "Eggs", "Salsa", "Beans"],
        cookTime: 20,
        description: "Fried eggs served on hot corn tortillas with salsa.",
        allergies: ["eggs"],
        asciiArt: `
     /\\
    /  \\
   /____\\
  (______)
        `
    },
    {
        id: 6,
        name: "Chilaquiles",
        meal: "breakfast",
        cuisine: "mexican",
        ingredients: ["Tortilla Chips", "Salsa", "Cheese", "Cream"],
        cookTime: 25,
        description: "Fried tortilla chips simmered in green or red salsa.",
        allergies: ["dairy"],
        asciiArt: `
    \\  /
     \\/
     /\\
    /__\\
        `
    },

    // --- Lunch ---
    {
        id: 7,
        name: "Grilled Cheese Sandwich",
        meal: "lunch",
        cuisine: "american",
        ingredients: ["Bread", "Cheddar Cheese", "Butter"],
        cookTime: 10,
        description: "Toasted bread with melted cheese in the middle.",
        allergies: ["gluten", "dairy"],
        asciiArt: `
  _________
 | GRILLED |
 | CHEESE  |
 |_________|
        `
    },
    {
        id: 8,
        name: "Chicken Caesar Wrap",
        meal: "lunch",
        cuisine: "american",
        ingredients: ["Tortilla", "Chicken", "Lettuce", "Caesar Dressing"],
        cookTime: 15,
        description: "Chicken Caesar salad wrapped in a tortilla.",
        allergies: ["gluten", "dairy", "meat"], // Added meat
        asciiArt: `
  _________
 | WRAP IT |
 |  UP!    |
 |_________|
        `
    },
    {
        id: 9,
        name: "Ploughman’s Lunch",
        meal: "lunch",
        cuisine: "british",
        ingredients: ["Cheese", "Bread", "Pickles", "Apple"],
        cookTime: 15,
        description: "A cold lunch with cheese, pickles, and bread.",
        allergies: ["dairy", "gluten"],
        asciiArt: `
  _________
 |PLOUGHMAN|
 | LUNCH  |
 |_________|
        `
    },
    {
        id: 10,
        name: "Cornish Pasty",
        meal: "lunch",
        cuisine: "british",
        ingredients: ["Pastry", "Beef", "Potatoes"],
        cookTime: 25,
        description: "A meat and vegetable filled pastry.",
        allergies: ["gluten", "meat"],
        asciiArt: `
  _________
 | PASTY  |
 | PLEASE |
 |_________|
        `
    },
    {
        id: 11,
        name: "Tacos",
        meal: "lunch",
        cuisine: "mexican",
        ingredients: ["Tortilla", "Ground Beef", "Cheese", "Lettuce", "Tomatoes"],
        cookTime: 20,
        description: "Classic Mexican tacos with toppings.",
        allergies: ["dairy", "meat"],
        asciiArt: `
  _________
 | TACOS  |
 | YUM!   |
 |_________|
        `
    },
    {
        id: 12,
        name: "Quesadilla",
        meal: "lunch",
        cuisine: "mexican",
        ingredients: ["Tortilla", "Cheese", "Chicken"],
        cookTime: 15,
        description: "Grilled tortilla with cheese and chicken.",
        allergies: ["dairy", "meat"],
        asciiArt: `
  _________
 |QUESADIL|
 |  LA!   |
 |_________|
        `
    },

    // --- Dinner ---
    {
        id: 13,
        name: "Meatloaf",
        meal: "dinner",
        cuisine: "american",
        ingredients: ["Ground Beef", "Breadcrumbs", "Onions", "Eggs"],
        cookTime: 60,
        description: "A classic American comfort dish of seasoned beef loaf.",
        allergies: ["gluten", "eggs", "meat"],
        asciiArt: `
  _________
 |MEATLOAF|
 | CLASSIC|
 |_________|
        `
    },
    {
        id: 14,
        name: "Mac and Cheese",
        meal: "dinner",
        cuisine: "american",
        ingredients: ["Macaroni", "Cheddar Cheese", "Milk", "Butter"],
        cookTime: 30,
        description: "Creamy baked macaroni and cheese.",
        allergies: ["dairy", "gluten"],
        asciiArt: `
  _________
 |  MAC & |
 | CHEESE |
 |_________|
        `
    },
    {
        id: 15,
        name: "Shepherd’s Pie",
        meal: "dinner",
        cuisine: "british",
        ingredients: ["Ground Lamb", "Potatoes", "Onions", "Carrots"],
        cookTime: 45,
        description: "Baked meat pie topped with mashed potatoes.",
        allergies: ["meat"],
        asciiArt: `
  _________
 |SHEPHERD|
 |  PIE   |
 |_________|
        `
    },
    {
        id: 16,
        name: "Bangers and Mash",
        meal: "dinner",
        cuisine: "british",
        ingredients: ["Sausages", "Mashed Potatoes", "Gravy"],
        cookTime: 35,
        description: "Sausages served with mashed potatoes and gravy.",
        allergies: ["dairy", "meat"],
        asciiArt: `
  _________
 |BANGERS |
 |  MASH  |
 |_________|
        `
    },
    {
        id: 17,
        name: "Enchiladas",
        meal: "dinner",
        cuisine: "mexican",
        ingredients: ["Tortillas", "Chicken", "Enchilada Sauce", "Cheese"],
        cookTime: 40,
        description: "Rolled tortillas with filling, covered in sauce.",
        allergies: ["dairy", "gluten", "meat"],
        asciiArt: `
  _________
 |ENCHILAD|
 |  AS!   |
 |_________|
        `
    },
    {
        id: 18,
        name: "Pozole",
        meal: "dinner",
        cuisine: "mexican",
        ingredients: ["Pork", "Hominy", "Chili Peppers", "Lettuce", "Radishes"],
        cookTime: 60,
        description: "A rich soup traditionally served with toppings.",
        allergies: ["meat"],
        asciiArt: `
  _________
 | POZOLE |
 |  SOUP  |
 |_________|
        `
    }
];

// State
let state = {
    meal: 'all',
    cuisine: 'all',
    allergies: []
};

// DOM Elements
const recipeGrid = document.getElementById('recipe-grid');
const noResults = document.getElementById('no-results');
const countBadge = document.getElementById('result-count');
const currentCategoryTitle = document.getElementById('current-category');
const modal = document.getElementById('recipe-modal');
const closeModal = document.querySelector('.close-modal');

// Init
document.addEventListener('DOMContentLoaded', () => {
    renderRecipes();
    setupEventListeners();
});

function setupEventListeners() {
    // Meal Tabs
    document.querySelectorAll('.tab-btn').forEach(btn => {
        btn.addEventListener('click', (e) => {
            document.querySelectorAll('.tab-btn').forEach(b => b.classList.remove('active'));
            e.target.classList.add('active');
            state.meal = e.target.dataset.value;
            renderRecipes();
        });
    });

    // Cuisine Chips
    document.querySelectorAll('.chip').forEach(btn => {
        btn.addEventListener('click', (e) => {
            document.querySelectorAll('.chip').forEach(b => b.classList.remove('active'));
            e.target.classList.add('active');
            state.cuisine = e.target.dataset.value;
            renderRecipes();
        });
    });

    // Allergy Checkboxes
    document.querySelectorAll('input[type="checkbox"]').forEach(checkbox => {
        checkbox.addEventListener('change', () => {
            const selected = Array.from(document.querySelectorAll('input[type="checkbox"]:checked'))
                .map(cb => cb.value);
            state.allergies = selected;
            renderRecipes();
        });
    });

    // Surprise Me
    document.getElementById('surprise-btn').addEventListener('click', () => {
        const filtered = getFilteredRecipes();
        if (filtered.length > 0) {
            const random = filtered[Math.floor(Math.random() * filtered.length)];
            openModal(random);
        } else {
            alert('No recipes to surprise you with based on current filters!');
        }
    });

    // Reset Filters
    document.getElementById('reset-filters').addEventListener('click', () => {
        // Reset state
        state = { meal: 'all', cuisine: 'all', allergies: [] };

        // Reset UI
        document.querySelectorAll('.tab-btn').forEach(b => b.classList.remove('active'));
        document.querySelector('.tab-btn[data-value="all"]').classList.add('active');

        document.querySelectorAll('.chip').forEach(b => b.classList.remove('active'));
        document.querySelector('.chip[data-value="all"]').classList.add('active');

        document.querySelectorAll('input[type="checkbox"]').forEach(cb => cb.checked = false);

        renderRecipes();
    });

    // Modal Close
    document.querySelector('.close-modal').addEventListener('click', () => {
        modal.classList.add('hidden');
    });

    window.addEventListener('click', (e) => {
        if (e.target === modal) {
            modal.classList.add('hidden');
        }
    });
}

function getFilteredRecipes() {
    return recipes.filter(recipe => {
        // Filter by Meal
        if (state.meal !== 'all' && recipe.meal !== state.meal) return false;

        // Filter by Cuisine
        if (state.cuisine !== 'all' && recipe.cuisine !== state.cuisine) return false;

        // Filter by Allergies (Exclusion)
        // If the recipe has any allergy that is in the excluded list, filter it out.
        const hasAllergy = recipe.allergies.some(allergy => state.allergies.includes(allergy));
        if (hasAllergy) return false;

        return true;
    });
}

function renderRecipes() {
    const filtered = getFilteredRecipes();

    // Update Header Text
    let title = "All Recipes";
    if (state.meal !== 'all') {
        title = state.meal.charAt(0).toUpperCase() + state.meal.slice(1) + " Recipes";
    }
    if (state.cuisine !== 'all') {
        const cuisineName = document.querySelector(`.chip[data-value="${state.cuisine}"]`).textContent;
        title = `${cuisineName} ${title === "All Recipes" ? "Recipes" : title}`;
    }
    currentCategoryTitle.textContent = title;
    countBadge.textContent = `${filtered.length} found`;

    recipeGrid.innerHTML = '';

    if (filtered.length === 0) {
        recipeGrid.classList.add('hidden');
        noResults.classList.remove('hidden');
    } else {
        recipeGrid.classList.remove('hidden');
        noResults.classList.add('hidden');

        filtered.forEach(recipe => {
            const card = document.createElement('div');
            card.className = 'recipe-card';
            card.innerHTML = `
                <div class="card-image-placeholder">
                    ${getImagePlaceholder(recipe.cuisine)}
                </div>
                <div class="card-content">
                    <div class="card-tags">
                        <span class="tag cuisine-tag">${getFlag(recipe.cuisine)} ${recipe.cuisine}</span>
                        <span class="tag meal-tag">${recipe.meal}</span>
                    </div>
                    <h3 class="card-title">${recipe.name}</h3>
                    <p class="card-desc">${recipe.description}</p>
                    <div class="card-footer">
                        <span><span class="time-icon">⏱</span> ${recipe.cookTime} mins</span>
                    </div>
                </div>
            `;
            card.addEventListener('click', () => openModal(recipe));
            recipeGrid.appendChild(card);
        });
    }
}

function openModal(recipe) {
    document.getElementById('modal-title').textContent = recipe.name;
    document.getElementById('modal-description').textContent = recipe.description;
    document.getElementById('modal-time').textContent = recipe.cookTime + " mins";

    // Format allergies
    const allergens = recipe.allergies.length > 0
        ? recipe.allergies.map(a => a.charAt(0).toUpperCase() + a.slice(1)).join(', ')
        : 'None';
    document.getElementById('modal-allergens').textContent = allergens;

    const list = document.getElementById('modal-ingredients');
    list.innerHTML = '';
    recipe.ingredients.forEach(ing => {
        const li = document.createElement('li');
        li.textContent = ing;
        list.appendChild(li);
    });

    document.getElementById('modal-ascii').textContent = recipe.asciiArt;
    document.getElementById('modal-cuisine').textContent = getFlag(recipe.cuisine) + " " + recipe.cuisine.charAt(0).toUpperCase() + recipe.cuisine.slice(1);
    document.getElementById('modal-meal').textContent = recipe.meal.charAt(0).toUpperCase() + recipe.meal.slice(1);

    modal.classList.remove('hidden');
}

function getFlag(cuisine) {
    if (cuisine === 'american') return '🇺🇸';
    if (cuisine === 'british') return '🇬🇧';
    if (cuisine === 'mexican') return '🇲🇽';
    return '🏳️';
}

function getImagePlaceholder(cuisine) {
    // Just a fun way to vary the placeholder icon
    if (cuisine === 'american') return '🍔';
    if (cuisine === 'british') return '☕';
    if (cuisine === 'mexican') return '🌮';
    return '🍽';
}
