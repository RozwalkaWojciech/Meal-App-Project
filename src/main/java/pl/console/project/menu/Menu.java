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

    private Menu() {
    }

    /**
     * You could reference those as necessary.
     * For example, using the above constants, you could make the following red text output on supported terminals:
     * System.out.println(ANSI_RED + "This text is red!" + ANSI_RESET);
     **/
    public static void mainMenu() {
        //STDOUT.info(ANSI_GREEN + "this text is green!" + ANSI_RESET);
        // String leftAlignFormat = "| %-15s | %-4d |%n";
        //System.out.println(ANSI_GREEN + "Choose from below choices" + ANSI_RESET);
        System.out.println("--------------------------");
        System.out.println(ANSI_YELLOW + "1 - Manage data base Meal");
        System.out.println("2 - Manage favourites Meal");
        System.out.println("3 - Configuration");
        System.out.println("9 - Quit" + ANSI_RESET);
        System.out.println("--------------------------\n");
        System.out.println(ANSI_CYAN + "Please choose an interesting option and press 'enter'" + ANSI_RESET);

        Scanner scanner = new Scanner(System.in);
        String choice = "";
        while (!choice.equals("9")) {
            try {
                choice = scanner.nextLine();
                switch (choice) {
                    case "1" -> STDOUT.info("Manage data base Meal\n");
                    case "2" -> STDOUT.info("Manage favourites Meal\n");
                    case "3" -> STDOUT.info("3 - Configuration\n");
                    case "9" -> System.exit(0);
                    default -> {
                        STDOUT.info(ANSI_RED + "Please choose correct option\n" + ANSI_RESET);
                        mainMenu();
                    }
                }
            } catch (InputMismatchException ignored) {
                STDOUT.info(ANSI_RED + "wrong parameter\n" + ANSI_RESET);
                STDOUT.info(choice, " :parameter is ");
            }
        }
        scanner.close();
    }

    public static void intro() {
        STDOUT.info(ANSI_BLUE + "\n+-----------------+------+\n");
        STDOUT.info("| WELCOME TO             |\n");
        STDOUT.info("| (®) Meal App Project   |\n");
        STDOUT.info("+-----------------+------+\n");
        STDOUT.info("| Authors:xyz            |\n");
        STDOUT.info("+-----------------+------+\n");
        STDOUT.info("+-----------------+------+\n\n" + ANSI_RESET);
    }
}
