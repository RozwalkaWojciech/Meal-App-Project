package pl.console.project.utils;

import pl.console.project.model.ListMeal;
import pl.console.project.model.Meal;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Utils {

    private Utils() {
    }

    public static Set<String> getUniqueCategory(ListMeal listMeal) {
        return listMeal.getListMeals()
                .stream()
                .map(Meal::getCategory)
                .collect(Collectors.toSet());
    }

    public static Set<String> getUniqueNames(ListMeal listMeal) {
        return listMeal.getListMeals()
                .stream()
                .map(Meal::getName)
                .collect(Collectors.toSet());
    }

    public static Set<String> getUniqueIngredients(ListMeal listMeal) {
        return listMeal.getListMeals()
                .stream()
                .flatMap(meal -> meal.getIngredients().stream())
                .collect(Collectors.toSet());
    }
}
