/*
Maciej P.
Main class in project to select choose on with option user wanna choose
 */

package pl.console.project.menu;

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

    public static void main(String[] args) {
        System.out.println(ANSI_RED + "this text is red!" + ANSI_RESET);

        STDOUT.info(ANSI_GREEN + "this text is green!" + ANSI_RESET);

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                // Perform "original number" case.
                break;
            case 2:
                // Perform "encrypt number" case.
                break;
            case 3:
                // Perform "decrypt number" case.
                break;
            case 4:
                // Perform "quit" case.
                break;
            default:
                // The user input an unexpected choice.
        }
    }
}
