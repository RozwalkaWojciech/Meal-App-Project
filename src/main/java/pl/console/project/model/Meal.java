package pl.console.project.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Meal {

    private final String id;
    private final String name;
    private final String category;
    private final String instruction;

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

    @Override
    public String toString() {
        return "Meal{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", instruction='" + instruction + '\'' +
                '}';
    }
}
//
//        @JsonProperty("idMeal")
//        public String getIdMeal() {
//            return this.idMeal; }
//        public void setIdMeal(String idMeal) {
//            this.idMeal = idMeal; }
//        String idMeal;
//        @JsonProperty("strMeal")
//        public String getStrMeal() {
//            return this.strMeal; }
//        public void setStrMeal(String strMeal) {
//            this.strMeal = strMeal; }
//        String strMeal;
//        @JsonProperty("strDrinkAlternate")
//        public Object getStrDrinkAlternate() {
//            return this.strDrinkAlternate; }
//        public void setStrDrinkAlternate(Object strDrinkAlternate) {
//            this.strDrinkAlternate = strDrinkAlternate; }
//        Object strDrinkAlternate;
//        @JsonProperty("strCategory")
//        public String getStrCategory() {
//            return this.strCategory; }
//        public void setStrCategory(String strCategory) {
//            this.strCategory = strCategory; }
//        String strCategory;
//        @JsonProperty("strArea")
//        public String getStrArea() {
//            return this.strArea; }
//        public void setStrArea(String strArea) {
//            this.strArea = strArea; }
//        String strArea;
//        @JsonProperty("strInstructions")
//        public String getStrInstructions() {
//            return this.strInstructions; }
//        public void setStrInstructions(String strInstructions) {
//            this.strInstructions = strInstructions; }
//        String strInstructions;
//        @JsonProperty("strMealThumb")
//        public String getStrMealThumb() {
//            return this.strMealThumb; }
//        public void setStrMealThumb(String strMealThumb) {
//            this.strMealThumb = strMealThumb; }
//        String strMealThumb;
//        @JsonProperty("strTags")
//        public String getStrTags() {
//            return this.strTags; }
//        public void setStrTags(String strTags) {
//            this.strTags = strTags; }
//        String strTags;
//        @JsonProperty("strYoutube")
//        public String getStrYoutube() {
//            return this.strYoutube; }
//        public void setStrYoutube(String strYoutube) {
//            this.strYoutube = strYoutube; }
//        String strYoutube;
//        @JsonProperty("strIngredient1")
//        public String getStrIngredient1() {
//            return this.strIngredient1; }
//        public void setStrIngredient1(String strIngredient1) {
//            this.strIngredient1 = strIngredient1; }
//        String strIngredient1;
//        @JsonProperty("strIngredient2")
//        public String getStrIngredient2() {
//            return this.strIngredient2; }
//        public void setStrIngredient2(String strIngredient2) {
//            this.strIngredient2 = strIngredient2; }
//        String strIngredient2;
//        @JsonProperty("strIngredient3")
//        public String getStrIngredient3() {
//            return this.strIngredient3; }
//        public void setStrIngredient3(String strIngredient3) {
//            this.strIngredient3 = strIngredient3; }
//        String strIngredient3;
//        @JsonProperty("strIngredient4")
//        public String getStrIngredient4() {
//            return this.strIngredient4; }
//        public void setStrIngredient4(String strIngredient4) {
//            this.strIngredient4 = strIngredient4; }
//        String strIngredient4;
//        @JsonProperty("strIngredient5")
//        public String getStrIngredient5() {
//            return this.strIngredient5; }
//        public void setStrIngredient5(String strIngredient5) {
//            this.strIngredient5 = strIngredient5; }
//        String strIngredient5;
//        @JsonProperty("strIngredient6")
//        public String getStrIngredient6() {
//            return this.strIngredient6; }
//        public void setStrIngredient6(String strIngredient6) {
//            this.strIngredient6 = strIngredient6; }
//        String strIngredient6;
//        @JsonProperty("strIngredient7")
//        public String getStrIngredient7() {
//            return this.strIngredient7; }
//        public void setStrIngredient7(String strIngredient7) {
//            this.strIngredient7 = strIngredient7; }
//        String strIngredient7;
//        @JsonProperty("strIngredient8")
//        public String getStrIngredient8() {
//            return this.strIngredient8; }
//        public void setStrIngredient8(String strIngredient8) {
//            this.strIngredient8 = strIngredient8; }
//        String strIngredient8;
//        @JsonProperty("strIngredient9")
//        public String getStrIngredient9() {
//            return this.strIngredient9; }
//        public void setStrIngredient9(String strIngredient9) {
//            this.strIngredient9 = strIngredient9; }
//        String strIngredient9;
//        @JsonProperty("strIngredient10")
//        public String getStrIngredient10() {
//            return this.strIngredient10; }
//        public void setStrIngredient10(String strIngredient10) {
//            this.strIngredient10 = strIngredient10; }
//        String strIngredient10;
//        @JsonProperty("strIngredient11")
//        public String getStrIngredient11() {
//            return this.strIngredient11; }
//        public void setStrIngredient11(String strIngredient11) {
//            this.strIngredient11 = strIngredient11; }
//        String strIngredient11;
//        @JsonProperty("strIngredient12")
//        public String getStrIngredient12() {
//            return this.strIngredient12; }
//        public void setStrIngredient12(String strIngredient12) {
//            this.strIngredient12 = strIngredient12; }
//        String strIngredient12;
//        @JsonProperty("strIngredient13")
//        public String getStrIngredient13() {
//            return this.strIngredient13; }
//        public void setStrIngredient13(String strIngredient13) {
//            this.strIngredient13 = strIngredient13; }
//        String strIngredient13;
//        @JsonProperty("strIngredient14")
//        public String getStrIngredient14() {
//            return this.strIngredient14; }
//        public void setStrIngredient14(String strIngredient14) {
//            this.strIngredient14 = strIngredient14; }
//        String strIngredient14;
//        @JsonProperty("strIngredient15")
//        public String getStrIngredient15() {
//            return this.strIngredient15; }
//        public void setStrIngredient15(String strIngredient15) {
//            this.strIngredient15 = strIngredient15; }
//        String strIngredient15;
//        @JsonProperty("strIngredient16")
//        public String getStrIngredient16() {
//            return this.strIngredient16; }
//        public void setStrIngredient16(String strIngredient16) {
//            this.strIngredient16 = strIngredient16; }
//        String strIngredient16;
//        @JsonProperty("strIngredient17")
//        public String getStrIngredient17() {
//            return this.strIngredient17; }
//        public void setStrIngredient17(String strIngredient17) {
//            this.strIngredient17 = strIngredient17; }
//        String strIngredient17;
//        @JsonProperty("strIngredient18")
//        public String getStrIngredient18() {
//            return this.strIngredient18; }
//        public void setStrIngredient18(String strIngredient18) {
//            this.strIngredient18 = strIngredient18; }
//        String strIngredient18;
//        @JsonProperty("strIngredient19")
//        public String getStrIngredient19() {
//            return this.strIngredient19; }
//        public void setStrIngredient19(String strIngredient19) {
//            this.strIngredient19 = strIngredient19; }
//        String strIngredient19;
//        @JsonProperty("strIngredient20")
//        public String getStrIngredient20() {
//            return this.strIngredient20; }
//        public void setStrIngredient20(String strIngredient20) {
//            this.strIngredient20 = strIngredient20; }
//        String strIngredient20;
//        @JsonProperty("strMeasure1")
//        public String getStrMeasure1() {
//            return this.strMeasure1; }
//        public void setStrMeasure1(String strMeasure1) {
//            this.strMeasure1 = strMeasure1; }
//        String strMeasure1;
//        @JsonProperty("strMeasure2")
//        public String getStrMeasure2() {
//            return this.strMeasure2; }
//        public void setStrMeasure2(String strMeasure2) {
//            this.strMeasure2 = strMeasure2; }
//        String strMeasure2;
//        @JsonProperty("strMeasure3")
//        public String getStrMeasure3() {
//            return this.strMeasure3; }
//        public void setStrMeasure3(String strMeasure3) {
//            this.strMeasure3 = strMeasure3; }
//        String strMeasure3;
//        @JsonProperty("strMeasure4")
//        public String getStrMeasure4() {
//            return this.strMeasure4; }
//        public void setStrMeasure4(String strMeasure4) {
//            this.strMeasure4 = strMeasure4; }
//        String strMeasure4;
//        @JsonProperty("strMeasure5")
//        public String getStrMeasure5() {
//            return this.strMeasure5; }
//        public void setStrMeasure5(String strMeasure5) {
//            this.strMeasure5 = strMeasure5; }
//        String strMeasure5;
//        @JsonProperty("strMeasure6")
//        public String getStrMeasure6() {
//            return this.strMeasure6; }
//        public void setStrMeasure6(String strMeasure6) {
//            this.strMeasure6 = strMeasure6; }
//        String strMeasure6;
//        @JsonProperty("strMeasure7")
//        public String getStrMeasure7() {
//            return this.strMeasure7; }
//        public void setStrMeasure7(String strMeasure7) {
//            this.strMeasure7 = strMeasure7; }
//        String strMeasure7;
//        @JsonProperty("strMeasure8")
//        public String getStrMeasure8() {
//            return this.strMeasure8; }
//        public void setStrMeasure8(String strMeasure8) {
//            this.strMeasure8 = strMeasure8; }
//        String strMeasure8;
//        @JsonProperty("strMeasure9")
//        public String getStrMeasure9() {
//            return this.strMeasure9; }
//        public void setStrMeasure9(String strMeasure9) {
//            this.strMeasure9 = strMeasure9; }
//        String strMeasure9;
//        @JsonProperty("strMeasure10")
//        public String getStrMeasure10() {
//            return this.strMeasure10; }
//        public void setStrMeasure10(String strMeasure10) {
//            this.strMeasure10 = strMeasure10; }
//        String strMeasure10;
//        @JsonProperty("strMeasure11")
//        public String getStrMeasure11() {
//            return this.strMeasure11; }
//        public void setStrMeasure11(String strMeasure11) {
//            this.strMeasure11 = strMeasure11; }
//        String strMeasure11;
//        @JsonProperty("strMeasure12")
//        public String getStrMeasure12() {
//            return this.strMeasure12; }
//        public void setStrMeasure12(String strMeasure12) {
//            this.strMeasure12 = strMeasure12; }
//        String strMeasure12;
//        @JsonProperty("strMeasure13")
//        public String getStrMeasure13() {
//            return this.strMeasure13; }
//        public void setStrMeasure13(String strMeasure13) {
//            this.strMeasure13 = strMeasure13; }
//        String strMeasure13;
//        @JsonProperty("strMeasure14")
//        public String getStrMeasure14() {
//            return this.strMeasure14; }
//        public void setStrMeasure14(String strMeasure14) {
//            this.strMeasure14 = strMeasure14; }
//        String strMeasure14;
//        @JsonProperty("strMeasure15")
//        public String getStrMeasure15() {
//            return this.strMeasure15; }
//        public void setStrMeasure15(String strMeasure15) {
//            this.strMeasure15 = strMeasure15; }
//        String strMeasure15;
//        @JsonProperty("strMeasure16")
//        public String getStrMeasure16() {
//            return this.strMeasure16; }
//        public void setStrMeasure16(String strMeasure16) {
//            this.strMeasure16 = strMeasure16; }
//        String strMeasure16;
//        @JsonProperty("strMeasure17")
//        public String getStrMeasure17() {
//            return this.strMeasure17; }
//        public void setStrMeasure17(String strMeasure17) {
//            this.strMeasure17 = strMeasure17; }
//        String strMeasure17;
//        @JsonProperty("strMeasure18")
//        public String getStrMeasure18() {
//            return this.strMeasure18; }
//        public void setStrMeasure18(String strMeasure18) {
//            this.strMeasure18 = strMeasure18; }
//        String strMeasure18;
//        @JsonProperty("strMeasure19")
//        public String getStrMeasure19() {
//            return this.strMeasure19; }
//        public void setStrMeasure19(String strMeasure19) {
//            this.strMeasure19 = strMeasure19; }
//        String strMeasure19;
//        @JsonProperty("strMeasure20")
//        public String getStrMeasure20() {
//            return this.strMeasure20; }
//        public void setStrMeasure20(String strMeasure20) {
//            this.strMeasure20 = strMeasure20; }
//        String strMeasure20;
//        @JsonProperty("strSource")
//        public String getStrSource() {
//            return this.strSource; }
//        public void setStrSource(String strSource) {
//            this.strSource = strSource; }
//        String strSource;
//        @JsonProperty("strImageSource")
//        public Object getStrImageSource() {
//            return this.strImageSource; }
//        public void setStrImageSource(Object strImageSource) {
//            this.strImageSource = strImageSource; }
//        Object strImageSource;
//        @JsonProperty("strCreativeCommonsConfirmed")
//        public Object getStrCreativeCommonsConfirmed() {
//            return this.strCreativeCommonsConfirmed; }
//        public void setStrCreativeCommonsConfirmed(Object strCreativeCommonsConfirmed) {
//            this.strCreativeCommonsConfirmed = strCreativeCommonsConfirmed; }
//        Object strCreativeCommonsConfirmed;
//        @JsonProperty("dateModified")
//        public Object getDateModified() {
//            return this.dateModified; }
//        public void setDateModified(Object dateModified) {
//            this.dateModified = dateModified; }
//        Object dateModified;
//    }
