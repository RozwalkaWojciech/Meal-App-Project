package pl.console.project;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.console.project.menu.Menu;
import pl.console.project.repositories.Repository;
import pl.console.project.utils.Utils;

public class App {

    private static final Logger STDOUT = LoggerFactory.getLogger("CONSOLE_OUT");

    public static void main(String[] args) {

        Menu menu = new Menu();
        menu.method();

//        STDOUT.info(Repository.getInstance().getListMeal().toString());
//        STDOUT.info(Repository.getInstance().getFavoriteListMeal().toString());
//        Repository.loadDataBase();
//        STDOUT.info(Repository.getInstance().getListMeal().toString());
        STDOUT.info(Utils.getUniqueCategory(Repository.getInstance().getListMeal()).toString());
    }
}
