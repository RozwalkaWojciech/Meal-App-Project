package pl.console.project.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ListMeal {

    private final List<Meal> listMeals;

    public ListMeal(@JsonProperty("meals") List<Meal> listMeals) {
        this.listMeals = listMeals;
    }

    public List<Meal> getListMeals() {
        return listMeals;
    }

    public Meal findMealByName(String name) {
        Optional<Meal> meal = listMeals.stream().filter(element -> element.getName().equals(name)).findFirst();
        return meal.orElseThrow(() -> new RuntimeException("Meal was not found"));
    }

    public List<Meal> findMealByCategory(String category) {
        return listMeals.stream().filter(meal -> meal.getCategory().equals(category))
                .collect(Collectors.toList());
    }

    public List<Meal> findMealByIngredient(String ingredient) {
        return listMeals.stream().filter(meal -> meal.getIngredients().contains(ingredient))
                .collect(Collectors.toList());
    }

    public void addMealToList(Meal meal) {
        for (Meal existingMeal : listMeals) {
            if ((!existingMeal.getName().equals(meal.getName()))) {
                listMeals.add(meal);
            }
        }
    }

    public void removeMealFromList(Meal meal) {
        for (Meal existingMeal : listMeals) {
            if (existingMeal.getName().equals(meal.getName()))
                listMeals.remove(meal);
        }
    }

    @Override
    public String toString() {
        return "\n\u001b[101m>>>>>>>>>> List of Meals <<<<<<<<<<\u001b[0m\n\n" + listMeals + "\n";
    }
}