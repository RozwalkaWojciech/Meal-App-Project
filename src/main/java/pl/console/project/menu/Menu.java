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

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    private static final Logger STDOUT = LoggerFactory.getLogger("CONSOLE_OUT");

    /**
     * You could reference those as necessary.
     * For example, using the above constants, you could make the following red text output on supported terminals:
     * System.out.println(ANSI_RED + "This text is red!" + ANSI_RESET);
     **/

    public void menu() {
        System.out.println("-------------------------\n");
        System.out.println(ANSI_YELLOW + "1 - Manage data base Meal");
        System.out.println("2 - Manage favourites Meal");
        System.out.println("3 - Configuration");
        System.out.println("9 - Quit" + ANSI_RESET);
        System.out.println("-------------------------\n");
        System.out.println(ANSI_CYAN + "Please choose an interesting option and press 'enter'" + ANSI_RESET);
    }

    public void method() {
        //STDOUT.info(ANSI_GREEN + "this text is green!" + ANSI_RESET);
        // String leftAlignFormat = "| %-15s | %-4d |%n";

        System.out.format(ANSI_WHITE + "+-----------------+------+%n");
        System.out.format("| WELCOME TO             |%n");
        System.out.format("| (®) Meal App Project   |%n");
        System.out.format("+-----------------+------+%n");
        System.out.format("| Authors:xyz            |%n");
        System.out.format("+-----------------+------+%n");
        System.out.format("+-----------------+------+%n" + ANSI_RESET);
        //System.out.println(ANSI_GREEN + "Choose from below choices" + ANSI_RESET);
        System.out.println("-------------------------\n");
        System.out.println(ANSI_YELLOW + "1 - Manage data base Meal");
        System.out.println("2 - Manage favourites Meal");
        System.out.println("3 - Configuration");
        System.out.println("9 - Quit" + ANSI_RESET);
        System.out.println("-------------------------\n");
        System.out.println(ANSI_CYAN + "Please choose an interesting option and press 'enter'" + ANSI_RESET);

        Scanner scanner = new Scanner(System.in);
        String choice = "";
        while (!choice.equals("9")) {
            try {
                choice = scanner.nextLine();
                switch (choice) {
                    case "1" -> System.out.println("Manage data base Meal");
                    case "2" -> System.out.println("Manage favourites Meal");
                    case "3" -> System.out.println("3 - Configuration");
                    case "9" -> System.out.println("End of the program");
                    default -> {
                        menu();
                        System.out.println(ANSI_RED + "Please choose correct option" + ANSI_RESET);
                        //default -> System.out.println(ANSI_RED+"Please choose correct option"+ANSI_RESET);
                    }
                }
            } catch (InputMismatchException ignored) {
                System.out.println(ANSI_RED + "wrong parameter" + ANSI_RESET);
                STDOUT.info(choice, " :parameter is ");
            }
        }
        scanner.close();
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

    //    public void displayMealsInMenu(ListMeal listMeal) throws InterruptedException {
//        int nr = 1;
//        int pageCurrent = 1;
//        List<Meal> listMeals = listMeal.getListMeals();
//        for (Meal meal : listMeals) {
//            System.out.println(nr + " - " + listMeals.get(nr + (7 * (pageCurrent - 1))).getName());
//            nr++;
//
//            if (nr == 7 || nr == listMeals.size()) {
//                if (shouldChangePage(pageCurrent, listMeals.size())) {
//                    nr = 1;
//                    Thread.currentThread().start();
//                }
//                System.out.println("Press - 9 - to exit.");
//            }
//        }
//    }

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
