package pl.console.project.menu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.console.project.model.ListMeal;
import pl.console.project.model.Meal;
import pl.console.project.repositories.Repository;

import java.util.*;

public class DisplayMenu {
    private static final Logger STDOUT = LoggerFactory.getLogger("CONSOLE_OUT");
    private static final Scanner scanner = new Scanner(System.in);
    private static int pagesAmount;
    private static int pageCurrent;
    private static int nrOnList;
    private static String messageSwitchPage;
    private static String input;
    private static List<String> mealsList;
    private static ListMeal listMeals;

    private DisplayMenu() {

    }

    public static void displayMealsInMenu(Set<String> mealsSet) {
        mealsList = new ArrayList<>(mealsSet);
        pagesAmount = determinePagesAmount(mealsSet);
        pageCurrent = 1;
        input = "";
        while (!input.equals("x")) {
            STDOUT.info("────────────────────────────\n");
            STDOUT.info("        DISPLAY MENU\n");
            STDOUT.info("────────────────────────────\n");
            get7MealsPerPage(mealsList);
            displayChangePageMessage(mealsList);
            changePageOrExit();
        }
    }

    private static void get7MealsPerPage(List<String> mealsList) {
        STDOUT.info("Page nr {}/{} \n", pageCurrent, pagesAmount);

        for (int i = 1; i <= 7; i++) {
            nrOnList = (i + (7 * (pageCurrent - 1)));
            try {
                STDOUT.info("{} - {} \n", nrOnList, mealsList.get(nrOnList));
            } catch (IndexOutOfBoundsException e) {
                STDOUT.info(".. - ....................\n");
            }
        }
    }

    private static void displayChangePageMessage(List<String> mealsList) {
        if (pagesAmount == 1) {
            messageSwitchPage = "Press 'x' to move to previous menu.";
        } else if (pageCurrent == 1 && pageCurrent < pagesAmount) {
            messageSwitchPage = "Press 'n' to check next meals. Press 'x' to move to previous menu.";
        } else if (pageCurrent == pagesAmount) {
            messageSwitchPage = "Press 'p' to check previous meals. Press 'x' to move to previous menu.";
        } else {
            messageSwitchPage = "Press 'n' to check next meals, 'p' to check previous meals. Press 'x' to move to previous menu.";
        }

        STDOUT.info("\n");
        STDOUT.info(messageSwitchPage);
        STDOUT.info("\n");
    }

    private static void changePageOrExit() {
        input = scanner.nextLine();
        int firstListNumber = 1 + ((pageCurrent - 1) * 7);
        int lastListNumber = 7 + ((pageCurrent - 1) * 7);

        if (isNumber(input)) {
            int inputNumber = Integer.parseInt(input);
            if (inputNumber >= firstListNumber && inputNumber <= lastListNumber) {
                if (listMeals != null) {
                    STDOUT.info(displayOneMeal(listMeals.getListMeals(), nrOnList));
                } else
                    STDOUT.info("The list is empty!");
            } else {
                Menu.wrongChoice();
                STDOUT.info("\n");
            }
        } else if (input.equals("n") && pageCurrent < pagesAmount) {
            pageCurrent++;
        } else if (input.equals("p") && pageCurrent > 1) {
            pageCurrent--;
        } else if (input.equals("x")) {
            SearchMenu.searchMenu();
        } else {
            Menu.wrongChoice();
            STDOUT.info("\n");
        }
    }

    private static String displayOneMeal(List<Meal> mealsList, int nrOnList) {
        return mealsList.get(nrOnList).toString();
    }

    public static boolean isNumber(String input) {
        if (input == null) {
            return false;
        }
        try {
            int number = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    private static int determinePagesAmount(Set<String> set) {
        int size = set.size();
        int pagesAmount;
        if (size <= 7) {
            pagesAmount = 1;
        } else if (size % 7 == 0) {
            pagesAmount = (size / 7);
        } else {
            pagesAmount = (size / 7) + 1;
        }
        return pagesAmount;
    }
}
