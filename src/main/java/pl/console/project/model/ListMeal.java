package pl.console.project.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ListMeal {

    private final List<Meal> listMeals;

    public ListMeal(@JsonProperty("meals") List<Meal> listMeals) {
        this.listMeals = listMeals;
    }

    public List<Meal> getListMeals() {
        return listMeals;
    }

    @Override
    public String toString() {
        return "ListMeal{" +
                "listMeals=" + listMeals +
                '}';
    }
}
