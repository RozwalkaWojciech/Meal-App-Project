/*
Maciej P.
Main class in project to select choose on with option user wanna choose
 */

package pl.console.project.menu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.InputMismatchException;
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
        STDOUT.info("3 - Manage favourite Meals\n");
        STDOUT.info("4 - Configuration\n");
        STDOUT.info("9 - Exit{}\n", RESET);
        STDOUT.info("--------------------------\n");
        STDOUT.info("{}Please choose an interesting option and press 'enter'{}\n", CYAN, RESET);

        Scanner scanner = new Scanner(System.in);
        String choice = "";
        while (!choice.equals("9")) {
            try {
                choice = scanner.nextLine();
                switch (choice) {
                    case "1" -> SearchMenu.searchMenu();
                    case "2" -> STDOUT.info("Add/remove Meal\n");
                    case "3" -> STDOUT.info("Manage favourite Meals\n");
                    case "4" -> STDOUT.info("Configuration\n");
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
}
