package pl.console.project.repositories;

import com.fasterxml.jackson.databind.ObjectMapper;
import pl.console.project.model.ListMeal;

import java.io.File;
import java.io.IOException;

public class Repository {

    private final ListMeal listMeal;
    private static Repository INSTANCE;
    private static final String DATA_BASE_PATH = "src/main/resources/meal list.json";

    private Repository() {
        listMeal = readFile(DATA_BASE_PATH);
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
}
