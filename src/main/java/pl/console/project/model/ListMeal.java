package pl.console.project.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

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

//        meal.ifPresentOrElse(element -> element.toString(), () -> System.out.println("The meal was not found");


    //        for (Meal meal : listMeals) {
//            if (meal.getName().equals(name)) {
//                return meal;
//            }
//        }
//        return null;

    public List<Meal> findMealByCategory(String category) {
        List<Meal> mealsCategoryList = new LinkedList<>();
        for (Meal meal : listMeals) {
            if (meal.getCategory().equals(category)) {
                mealsCategoryList.add(meal);
            }
        }
        return mealsCategoryList;
    }

    public List<Meal> findMealByIngredient(String ingredient) {
        List<Meal> mealsIngredientList = new LinkedList<>();
        for (Meal meal : listMeals) {
            if (meal.getIngredients().contains(ingredient)) {
                mealsIngredientList.add(meal);
            }
        }
        return mealsIngredientList;
    }

    public void addMealToList(Meal meal) {
        for (Meal existingMeal : listMeals) {
            if ((!existingMeal.getName().equals(meal.getName())) && (!existingMeal.getId().equals(meal.getId()))) {
                listMeals.add(meal);
            }
        }
    }

    public void removeMealFromList(Meal meal) {
        for (Meal existingMeal : listMeals) {
            if (existingMeal.getName().equals(meal.getName())) {
                listMeals.remove(meal);
            }
        }
    }

    @Override
    public String toString() {
        return "\n\u001b[101m>>>>>>>>>> List of Meals <<<<<<<<<<\u001b[0m\n\n" + listMeals + "\n";
    }
}