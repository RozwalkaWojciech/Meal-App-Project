/*
Maciej P.
Main class in project to select choose on with option user wanna choose
 */

package pl.console.project.menu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.console.project.model.ListMeal;
import pl.console.project.model.Meal;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Menu {

    private static final Logger STDOUT = LoggerFactory.getLogger("CONSOLE_OUT");
    public static final String BLUE = Color.BLUE.get();
    public static final String RESET = Color.RESET.get();
    public static final String RED = Color.RED.get();
    public static final String CYAN = Color.CYAN.get();
    public static final String YELLOW = Color.YELLOW.get();

    private Menu() {
    }

    /**
     * You could reference those as necessary.
     * For example, using the above constants, you could make the following red text output on supported terminals:
     * System.out.println(ANSI_RED + "This text is red!" + ANSI_RESET);
     **/
    public static void mainMenu() {
        STDOUT.info("\n────────────────────────────\n");
        STDOUT.info("         MAIN MENU        \n");
        STDOUT.info("────────────────────────────\n");
        STDOUT.info("{}1 - Search Meal\n", YELLOW);
        STDOUT.info("{}2 - Add/remove Meal\n", YELLOW);
        STDOUT.info("3 - Manage favourites Meal\n");
        STDOUT.info("4 - Configuration\n");
        STDOUT.info("9 - Quit{}\n", RESET);
        STDOUT.info("--------------------------\n");
        STDOUT.info("{}Please choose an interesting option and press 'enter'{}\n", CYAN, RESET);

        Scanner scanner = new Scanner(System.in);
        String choice = "";
        while (!choice.equals("9")) {
            try {
                choice = scanner.nextLine();
                switch (choice) {
                    case "1" -> SearchMenu.searchMenu();
                    case "2" -> STDOUT.info("Manage favourites Meal\n");
                    case "3" -> STDOUT.info("3 - Configuration\n");
                    case "9" -> System.exit(0);
                    default -> {
                        wrongChoice();
                        mainMenu();
                    }
                }
            } catch (InputMismatchException e) {
                e.printStackTrace();
            }
        }
        scanner.close();
    }

    public static void intro() {
        STDOUT.info("\n{}+-----------------+------+\n", BLUE);
        STDOUT.info("| WELCOME TO             |\n");
        STDOUT.info("| (®) Meal App Project   |\n");
        STDOUT.info("+-----------------+------+\n");
        STDOUT.info("| Authors:xyz            |\n");
        STDOUT.info("+-----------------+------+\n");
        STDOUT.info("+-----------------+------+{}\n\n", RESET);
    }

    static void wrongChoice() {
        STDOUT.info("\n{}****************************\n", RED);
        STDOUT.info("Please choose correct option\n");
        STDOUT.info("****************************{}\n", RESET);
    }
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
        System.out.println("Exit in progess");
    }

}
