package pl.console.project;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.console.project.menu.Menu;

public class App {

    private static final Logger STDOUT = LoggerFactory.getLogger("CONSOLE_OUT");

    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.method();
            //menu.numberToString("słowo");
        //STDOUT.info("Hello!");

    }
}
