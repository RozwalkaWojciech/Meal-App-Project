package pl.console.project.repositories;

import com.fasterxml.jackson.databind.ObjectMapper;
import pl.console.project.model.ListMeal;

import java.io.File;
import java.io.IOException;

public class Repository {

    private final ListMeal listMeal;

    private static Repository INSTANCE;

    private Repository() {
        listMeal = readFile("src/main/resources/meal list.json");
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
