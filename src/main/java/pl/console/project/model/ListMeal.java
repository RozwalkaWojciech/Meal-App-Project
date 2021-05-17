package pl.console.project.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ListMeal {

    private final List<Meal> listMeals;

    public ListMeal(@JsonProperty("meals") List<Meal> listMeals) {
        this.listMeals = listMeals;
    }

    public List<Meal> getListMeals() {
        return listMeals;
    }

    public Optional<Meal> findMealByName(String name) {
        return listMeals.stream()
                .filter(element -> element.getName().equals(name))
                .findFirst();
    }

    public List<Meal> findMealByCategory(String category) {
        return listMeals.stream()
                .filter(meal -> meal.getCategory().equals(category))
                .collect(Collectors.toList());
    }

    public List<Meal> findMealByIngredient(String ingredient) {
        return listMeals.stream()
                .filter(meal -> meal.getIngredients().contains(ingredient))
                .collect(Collectors.toList());
    }

    public void addMealToList(Meal meal) {
        for (Meal existingMeal : listMeals) {
            if ((!existingMeal.getName().equals(meal.getName()))) {
                listMeals.add(meal);
            }
        }
    }

    public void removeMealFromList(Meal meal) {
        for (Meal existingMeal : listMeals) {
            if (existingMeal.getName().equals(meal.getName()))
                listMeals.remove(meal);
        }
    }

    @Override
    public String toString() {
        return "\n\u001b[101m>>>>>>>>>> List of Meals <<<<<<<<<<\u001b[0m\n\n" + listMeals + "\n";
    }

    public void displayMealsInMenu() throws InterruptedException {
        int nr = 1;
        int pageCurrent = 1;
        for (Meal meal : listMeals) {
            System.out.println(nr + " - " + listMeals.get(nr + (7 * (pageCurrent - 1))).getName());
            nr++;

            if (nr == 7 || nr == listMeals.size()) {
                if (shouldChangePage(pageCurrent, listMeals.size())) {
                    nr = 1;
                    Thread.currentThread().start();
                }
                System.out.println("Press - 9 - to exit.");
            }
        }
    }

    public boolean shouldChangePage(int page, int listSize) {
        System.out.println("Press 'e' to check next meals, or 'q' to check previous.");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if (input.equals("e") && page < listSize) {
            page++;
            Thread.currentThread().start();
            return true;
        } else if (input.equals("q") && page > 1) {
            page--;
            Thread.currentThread().start();
            return true;
        }
        return false;
    }

//    public boolean shouldDisplayNext() {
//        System.out.println("Press 'e' to check next meals.");
//        Scanner scanner = new Scanner(System.in);
//        String input = scanner.nextLine();
//        if (input.equals("e")) {
//            return true;
//        }
//        return false;
//    }
//
//    public boolean shouldDisplayPrevious() {
//        System.out.println("Press 'q' to check previous meals.");
//        Scanner scanner = new Scanner(System.in);
//        String input = scanner.nextLine();
//        if (input.equals("q")) {
//            return true;
//        }
//        return false;
//    }

//    public int determinePageAmount(List list) {
//        int size = list.size();
//        int pagesAmount;
//        if (size <= 7) {
//            pagesAmount = 1;
//        } else if (size % 7 == 0) {
//            pagesAmount = (size / 7);
//        } else {
//            pagesAmount = (int) (size / 7) + 1;
//        }
//        return pagesAmount;
//    }

    // 30 % 7 = 2

//    public void displayMealsInMenu() throws InterruptedException {
//        int i = 1;
//        int pagesAmount = determinePageAmount(listMeals);
//        int pageCurrent;
//        for (Meal meal : listMeals) {
//            System.out.println(i + " - " + meal.getName());
//            i++;
//            if (i == 7) {
//                i = 1;
//                Thread.currentThread().wait();
//                if (shouldDisplayNext()) {
//                    Thread.currentThread().run();
//                }
//            }
//        }
//    }
}