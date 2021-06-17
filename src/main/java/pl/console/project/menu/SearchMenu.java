package pl.console.project.menu;

import jdk.jshell.execution.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.console.project.model.ListMeal;
import pl.console.project.model.Meal;
import pl.console.project.repositories.Repository;
import pl.console.project.utils.Utils;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

class SearchMenu {

    private static final Logger STDOUT = LoggerFactory.getLogger("CONSOLE_OUT");
    public static final String RESET = Color.RESET.get();
    public static final String CYAN = Color.CYAN.get();
    public static final String YELLOW = Color.YELLOW.get();
    public static final String GREEN = Color.GREEN.get();

    private SearchMenu() {
    }

    static String choice;

    static void searchMenu() {
        STDOUT.info("\n────────────────────────────\n");
        STDOUT.info("        SEARCH MENU        \n");
        STDOUT.info("────────────────────────────\n");
        STDOUT.info("{}1 - Search Meal by name\n", YELLOW);
        STDOUT.info("{}2 - Search Meal by ingredient\n", YELLOW);
        STDOUT.info("3 - Search Meal by category\n");
        STDOUT.info("8 - BACK TO MAIN MENU{}\n", RESET);
        STDOUT.info("--------------------------\n");
        STDOUT.info("{}Please choose an interesting option and press 'enter'{}\n", CYAN, RESET);

        Scanner scanner = new Scanner(System.in);
        choice = "";
        while (!choice.equals("9")) {
            try {
                choice = scanner.nextLine();
                switch (choice) {
                    case "1" -> {
                        STDOUT.info("{}\nTODO: {}Display meals name -> use utils class\n", GREEN, RESET);
                        DisplayMenu.displayMealsInMenu(Utils.getUniqueNames(Repository.getInstance().getListMeal()));
                    }
                    case "2" -> {
                        STDOUT.info("{}\nTODO: {}Display unique ingredients -> use utils class\n", GREEN, RESET);
                        DisplayMenu.displayMealsInMenu(Utils.getUniqueIngredients(Repository.getInstance().getListMeal()));
                    }
                    case "3" -> {
                        STDOUT.info("{}\nTODO: {}Display unique category -> use utils class\n", GREEN, RESET);
                        DisplayMenu.displayMealsInMenu(Utils.getUniqueCategory(Repository.getInstance().getListMeal()));
                    }
                    case "8" -> Menu.mainMenu();
                    default -> {
                        Menu.wrongChoice();
                        searchMenu();
                    }
                }
            } catch (InputMismatchException e) {
                e.printStackTrace();
            }
        }
        scanner.close();
    }
}
