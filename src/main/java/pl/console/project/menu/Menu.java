/*
Maciej P.
Main class in project to select choose on with option user wanna choose
 */

package pl.console.project.menu;

import java.io.IOException;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


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

    /*
    You could reference those as necessary.
    For example, using the above constants, you could make the following red text output on supported terminals:
    System.out.println(ANSI_RED + "This text is red!" + ANSI_RESET);
     */
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


        System.out.println(ANSI_GREEN+"Choose from below choices"+ ANSI_RESET);
        System.out.println("-------------------------\n");
        System.out.println(ANSI_YELLOW+"1 - Manage data base Meal");
        System.out.println("2 - Manage favourites Meal");
        System.out.println("3 - Configuration");
        System.out.println("9 - Quit"+ANSI_RESET);
        System.out.println("-------------------------\n");

        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        do {
            try {
                choice = scanner.nextInt();
                switch (choice) {
                    case 1 -> System.out.println("Manage data base Meal");
                    case 2 -> System.out.println("Manage favourites Meal");
                    case 3 -> System.out.println("3 - Configuration");
                    case 9 -> System.out.println("End of the program");
                    default -> System.out.println("please choose correct option");
                }
        } catch (Exception exc) {
            System.out.println(ANSI_RED+"Please choose correct option"+ANSI_RESET);
        }
        } while (choice != 9);
    }
}