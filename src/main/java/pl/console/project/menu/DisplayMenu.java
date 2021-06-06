package pl.console.project.menu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class DisplayMenu {
    private static final Logger STDOUT = LoggerFactory.getLogger("CONSOLE_OUT");
    static int pagesAmount;
    static int pageCurrent;
    static String messageSwitchPage;
    static final Scanner scanner = new Scanner(System.in);
    static String input;

    private DisplayMenu() {

    }

    public static void displayMealsInMenu(Set<String> mealsSet) {
        pagesAmount = determinePagesAmount(mealsSet);
        pageCurrent = 1;
        input = "";
        while (!input.equals("x")) {
            STDOUT.info("────────────────────────────\n");
            STDOUT.info("        DISPLAY MENU\n");
            STDOUT.info("────────────────────────────\n");
            get7MealsPerPage(mealsSet);
            displayChangePageMessage();
            changePageOrExit();
        }
    }

    private static void get7MealsPerPage(Set<String> mealsSet) {
        List<String> mealsList = new ArrayList<>(mealsSet);
        STDOUT.info("Page nr " + pageCurrent + "/" + pagesAmount + "\n");

        for (int i = 1; i <= 7; i++) {
            int nrOnList = (i + (7 * (pageCurrent - 1)));
            try {
                STDOUT.info(nrOnList + " - " + mealsList.get(nrOnList) + "\n");
            } catch (IndexOutOfBoundsException e) {
                STDOUT.info(".. - ....................\n");
            }
        }
    }

    private static void displayChangePageMessage() {
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

        if (input.equals("n") && pageCurrent < pagesAmount) {
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
