package pl.console.project.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.LinkedList;
import java.util.List;

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
        for (Meal meal : listMeals) {
            if (meal.getName().equals(name)) {
                return meal;
            }
        }
        return null;
    }

    public List<Meal> findMealByCategory(String category) {
        List<Meal> mealsCategoryList = new LinkedList<>();
        for (Meal meal : listMeals) {
            if (meal.getCategory().equals(category)) {
                mealsCategoryList.add(meal);
            }
        }
        return mealsCategoryList;
    }

    public List<Meal> findMealByIngredient(String ingredient) { // shift+f6
        List<Meal> mealsIngredientList = new LinkedList<>();
        for (Meal meal : listMeals) {
            if (meal.getIngredients().contains(ingredient)) {
                mealsIngredientList.add(meal);
            }
        }
        return mealsIngredientList;
    }

    public void addMealToList(Meal meal) {
        for (Meal existingMeal : listMeals){
            if ((!existingMeal.getName().equals(meal.getName())) && (!existingMeal.getId().equals(meal.getId()))){
                listMeals.add(meal);
            }
        }
    }

    public void removeMealFromList(Meal meal) {
        for (Meal existingMeal : listMeals){
            if (existingMeal.getName().equals(meal.getName())){
                listMeals.remove(meal);
            }
        }
    }

    @Override
    public String toString() {
        return "\n\u001b[101m>>>>>>>>>> List of Meals <<<<<<<<<<\u001b[0m\n\n" + listMeals + "\n";
    }
}