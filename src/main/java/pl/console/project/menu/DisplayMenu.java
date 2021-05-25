package pl.console.project.menu;

import pl.console.project.model.ListMeal;
import pl.console.project.model.Meal;

import java.util.List;
import java.util.Scanner;

public class DisplayMenu {
    public void displayMealsInMenu(ListMeal listMeal) {
        List<Meal> mealsList = listMeal.getListMeals();
        int pagesAmount = determinePagesAmount(mealsList);

        while (true) {
            int pageCurrent = 1;
            for (int i = 1; i <= 7; i++) {
                int nrOnList = (i + (7 * (pageCurrent - 1)));

                if (mealsList.get(nrOnList) != null) {
                    System.out.println(i + " - " + mealsList.get(nrOnList).getName());
                } else {
                    break;
                }
            }
            System.out.println("Press - 9 - to exit.");
            changePageOrExit(pageCurrent, pagesAmount);
        }
    }

    public int determinePagesAmount(List list) {
        int size = list.size();
        int pagesAmount;
        if (size <= 7) {
            pagesAmount = 1;
        } else if (size % 7 == 0) {
            pagesAmount = (size / 7);
        } else {
            pagesAmount = (int) (size / 7) + 1;
        }
        return pagesAmount;
    }

    public void changePageOrExit(int pageCurrent, int pagesAmount) {
        System.out.println("Press 'e' to check next meals, or 'q' to check previous.");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if (input.equals("e") && pageCurrent < pagesAmount) {
            pageCurrent++;
        } else if (input.equals("q") && pageCurrent > 1) {
            pageCurrent--;
        } else if (input.equals("9")) {
            exit();
        }
    }

    public void exit() {
        // TODO ????????
        System.out.println("Exit in progress");
    }
}
