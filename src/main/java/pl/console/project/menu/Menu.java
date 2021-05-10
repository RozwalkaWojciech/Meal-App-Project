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
        STDOUT.info(Color.YELLOW.get() + "1 - Search Meal\n");
        STDOUT.info(Color.YELLOW.get() + "2 - Add/remove Meal\n");
        STDOUT.info("3 - Manage favourites Meal\n");
        STDOUT.info("4 - Configuration\n");
        STDOUT.info("9 - Quit\n" + Color.RESET.get());
        STDOUT.info("--------------------------\n");
        STDOUT.info(Color.CYAN.get() + "Please choose an interesting option and press 'enter'\n" + Color.RESET.get());

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
            } catch (InputMismatchException ignored) {
                STDOUT.info(Color.RED.get() + "wrong parameter\n" + Color.RESET.get());
                STDOUT.info(choice, " :parameter is ");
            }
        }
        scanner.close();
    }

    public static void intro() {
        STDOUT.info(Color.BLUE.get() + "\n+-----------------+------+\n");
        STDOUT.info("| WELCOME TO             |\n");
        STDOUT.info("| (®) Meal App Project   |\n");
        STDOUT.info("+-----------------+------+\n");
        STDOUT.info("| Authors:xyz            |\n");
        STDOUT.info("+-----------------+------+\n");
        STDOUT.info("+-----------------+------+\n\n" + Color.RESET.get());
    }

    static void wrongChoice() {
        STDOUT.info(Color.RED.get() + "\n****************************\n");
        STDOUT.info("Please choose correct option\n");
        STDOUT.info("****************************\n" + Color.RESET.get());
    }
}
