package pl.console.project.menu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.InputMismatchException;
import java.util.Scanner;

class SearchMenu {

    private static final Logger STDOUT = LoggerFactory.getLogger("CONSOLE_OUT");

    private SearchMenu() {
    }

    static void searchMenu() {
        STDOUT.info("\n────────────────────────────\n");
        STDOUT.info("        SEARCH MENU        \n");
        STDOUT.info("────────────────────────────\n");
        STDOUT.info(Color.YELLOW.get() + "1 - Search Meal by name\n");
        STDOUT.info(Color.YELLOW.get() + "2 - Search Meal by ingredient\n");
        STDOUT.info("3 - Search Meal by category\n");
        STDOUT.info("8 - BACK TO MAIN MENU\n" + Color.RESET.get());
        STDOUT.info("--------------------------\n");
        STDOUT.info(Color.CYAN.get() + "Please choose an interesting option and press 'enter'\n" + Color.RESET.get());

        Scanner scanner = new Scanner(System.in);
        String choice = "";
        while (!choice.equals("9")) {
            try {
                choice = scanner.nextLine();
                switch (choice) {
                    case "1" -> STDOUT.info(Color.GREEN.get() + "\nTODO: " + Color.RESET.get() + "Display meals name -> use utils class\n");
                    case "2" -> STDOUT.info(Color.GREEN.get() + "\nTODO: " + Color.RESET.get() + "Display unique ingredients -> use utils class\n");
                    case "3" -> STDOUT.info(Color.GREEN.get() + "\nTODO: " + Color.RESET.get() + "Display unique category -> use utils class\n");
                    case "8" -> Menu.mainMenu();
                    default -> {
                        Menu.wrongChoice();
                        searchMenu();
                    }
                }
            } catch (InputMismatchException ignored) {
                STDOUT.info(Color.RED.get() + "wrong parameter\n" + Color.RESET.get());
                STDOUT.info(choice, " :parameter is ");
            }
        }
        scanner.close();
    }
}
