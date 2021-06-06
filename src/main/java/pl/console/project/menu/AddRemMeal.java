package pl.console.project.menu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.InputMismatchException;
import java.util.Scanner;

import static pl.console.project.menu.Menu.mainMenu;
import static pl.console.project.menu.Menu.wrongChoice;

public class AddRemMeal {
    private static final Logger STDOUT = LoggerFactory.getLogger("CONSOLE_OUT");
    public static final String BLUE = Color.BLUE.get();
    public static final String RESET = Color.RESET.get();
    public static final String RED = Color.RED.get();
    public static final String CYAN = Color.CYAN.get();
    public static final String YELLOW = Color.YELLOW.get();


    Scanner scanner = new Scanner(System.in);
    String choice = "";
    String txt = "word";
   // System.out.println(txt.toUpperCase());
   //  while(!choice.equals("9"))



    {
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
       //scanner.close();

}


