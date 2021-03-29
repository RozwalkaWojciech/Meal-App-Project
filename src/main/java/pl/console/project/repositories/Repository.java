package pl.console.project.repositories;

import com.fasterxml.jackson.databind.ObjectMapper;
import pl.console.project.model.ListMeal;

import java.io.File;
import java.io.IOException;

public class Repository {

    private final ListMeal listMeal;
    private final ListMeal favoriteListMeal;
    private static Repository INSTANCE;
    private static final String DATA_BASE_PATH = "src/main/resources/meal list.json";
    private static final String FAVORITE_MEAL_LIST_PATH = "src/main/resources/favorite meal list.json";

    private Repository() {
        listMeal = readFile(DATA_BASE_PATH);
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

    public ListMeal getFavoriteListMeal() {
        return favoriteListMeal;
    }

    static ListMeal readFile(String path) {

        ObjectMapper objectMapper = new ObjectMapper();
        ListMeal listMeal = null;

        try {
            listMeal = objectMapper.readValue(new File(path), ListMeal.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listMeal;
    }

    static ListMeal writeFile(String path) {
        ObjectMapper objectMapper = new ObjectMapper();
        ListMeal favoriteListMeal = null;

        try {
            objectMapper.writeValue(new File("src/main/resources/favorite meal list.json"), favoriteListMeal);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return favoriteListMeal;
    }
}
