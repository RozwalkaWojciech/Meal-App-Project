package pl.console.project.repositories;

import com.fasterxml.jackson.databind.ObjectMapper;
import pl.console.project.model.ListMeal;
import pl.console.project.model.Meal;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Repository {

    private final ListMeal listMeal;
    private final ListMeal favoriteListMeal;
    private static Repository INSTANCE;
    private static final String DATA_BASE_PATH = "src/main/resources/meal list.json";
    private static final String USER_MEAL_LIST_PATH = "src/main/resources/user meal list.json";
    private static final String FAVORITE_MEAL_LIST_PATH = "src/main/resources/favorite meal list.json";

    private Repository() {
        listMeal = readFile(USER_MEAL_LIST_PATH);
        favoriteListMeal = readFile(FAVORITE_MEAL_LIST_PATH);
    }

    public static Repository getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Repository();
        }
        return INSTANCE;
    }

    public ListMeal getListMeal() {
        return listMeal;
    }

    public Meal findMealByName(String name) {
        return listMeal.findMealByName(name);
    }

    public List<Meal> findMealByIngredient(String ingredient) {
        return listMeal.findMealByIngredient(ingredient);
    }

    public List<Meal> findMealByCategory(String category) {
        return listMeal.findMealByCategory(category);
    }

    public void addMealToMainList(Meal meal) {
        listMeal.addMealToList(meal);
        writeFile(USER_MEAL_LIST_PATH, listMeal);
    }

    public void removeMealFromMainList(Meal meal) {
        listMeal.removeMealFromList(meal);
        writeFile(USER_MEAL_LIST_PATH, listMeal);
    }

    public Meal findFavMealByName(String name) {
        return favoriteListMeal.findMealByName(name);
    }

    public List<Meal> findFavoriteMealByIngredient(String ingredient) {
        return favoriteListMeal.findMealByIngredient(ingredient);
    }

    public List<Meal> findFavoriteMealByCategory(String category) {
        return favoriteListMeal.findMealByCategory(category);
    }

    public ListMeal getFavoriteListMeal() {
        return favoriteListMeal;
    }

    public void addMealToFavorites(Meal meal) {
        favoriteListMeal.addMealToList(meal);
        writeFile(FAVORITE_MEAL_LIST_PATH, favoriteListMeal);
    }

    public void removeMealFromFavorites(Meal meal) {
        favoriteListMeal.removeMealFromList(meal);
        writeFile(FAVORITE_MEAL_LIST_PATH, favoriteListMeal);
    }

    public static ListMeal readFile(String path) {
        ObjectMapper objectMapper = new ObjectMapper();
        ListMeal listMeal = null;
        try {
            listMeal = objectMapper.readValue(new File(path), ListMeal.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listMeal;
    }

    public static void writeFile(String path, ListMeal list) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File(path), list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void loadDataBase() {
        ObjectMapper objectMapper = new ObjectMapper();
        ListMeal listMeal = readFile(DATA_BASE_PATH);
        try {
            objectMapper.writeValue(new File(USER_MEAL_LIST_PATH), listMeal);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
