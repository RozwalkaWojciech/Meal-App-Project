package pl.console.project.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Meal {

    private final String id;
    private final String name;
    private final String category;
    private final String instruction;
    private List<String> ingredients = new ArrayList<>();
    private List<String> measures = new ArrayList<>();


    @JsonAlias({"strIngredient1", "strIngredient2", "strIngredient3", "strIngredient4", "strIngredient5",
            "strIngredient6", "strIngredient7", "strIngredient8", "strIngredient9", "strIngredient10",
            "strIngredient11", "strIngredient12", "strIngredient13", "strIngredient14", "strIngredient15",
            "strIngredient16", "strIngredient17", "strIngredient18", "strIngredient19", "strIngredient20"})
    public String getFakeIngredient() {
        return null;
    }

    @JsonSetter()
    public void setFakeIngredient(String ingredient) {
        if (ingredient != null) {
            ingredients.add(ingredient);
        }
    }

    @JsonAlias({"strMeasure1", "strMeasure2", "strMeasure3", "strMeasure4", "strMeasure5",
            "strMeasure6", "strMeasure7", "strMeasure8", "strMeasure9", "strMeasure10",
            "strMeasure11", "strMeasure12", "strMeasure13", "strMeasure14", "strMeasure15",
            "strMeasure16", "strMeasure17", "strMeasure18", "strMeasure19", "strMeasure20",})
    public String getFakeMeasure() {
        return null;
    }

    @JsonSetter()
    public void setFakeMeasure(String measure) {
        if (measure != null) {
            measures.add(measure);
        }
    }

    public Meal(@JsonProperty("idMeal") String id,
                @JsonProperty("strMeal") String name,
                @JsonProperty("strCategory") String category,
                @JsonProperty("strInstructions") String instruction) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.instruction = instruction;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public String getInstruction() {
        return instruction;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public List<String> getMeasures() {
        return measures;
    }

    @Override
    public String toString() {
        return "Meal{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                +'\'' + ", ingredients=" + ingredients +
                ", measures=" + measures +
                '}' + ", instruction='" + instruction + "\n";
    }
}
