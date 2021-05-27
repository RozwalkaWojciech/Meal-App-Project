package pl.console.project.menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class DisplayMenu {
    public static void displayMealsInMenu(Set<String> mealsSet) {
        int pagesAmount = determinePagesAmount(mealsSet);
        get7MealsPerPage(pagesAmount, mealsSet);
    }

    private static void get7MealsPerPage(int pagesAmount, Set<String> mealsSet) {
        List<String> mealsList = new ArrayList<>(mealsSet);
        int pageCurrent = 1;

        while (true) {
            System.out.println("Page nr " + pageCurrent + "/" + pagesAmount);
            for (int i = 1; i <= 7; i++) {
                int nrOnList = (i + (7 * (pageCurrent - 1)));
                try {
                    System.out.println(i + " - " + mealsList.get(nrOnList));
                } catch (IndexOutOfBoundsException e) {
                    System.out.println();
                }
            }
            System.out.println("Press - 9 - to exit.");

            System.out.println("Press 'e' to check next meals, 'q' to check previous meals. Press 'w' to move to previous menu.");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();

            if (input.equals("e") && pageCurrent < pagesAmount) {
                pageCurrent++;
            } else if (input.equals("q") && pageCurrent > 1) {
                pageCurrent--;
            } else if (input.equals("w")) {
                SearchMenu.searchMenu();
            } else if (input.equals("9")) {
                System.exit(0);
            }
        }
    }

    private static int determinePagesAmount(Set<String> set) {
        int size = set.size();
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
}
