package pl.console.project;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.console.project.menu.Menu;
import pl.console.project.repositories.Repository;
import pl.console.project.utils.Utils;

public class App {

    private static final Logger STDOUT = LoggerFactory.getLogger("CONSOLE_OUT");

    public static void main(String[] args) {

        Menu.intro();
        Menu.mainMenu(); //comment this line to check how the methods below work

        //Display users ListMeal
        STDOUT.info(Repository.getInstance().getListMeal().toString());

        //Display fav ListMeal
        STDOUT.info(Repository.getInstance().getFavoriteListMeal().toString());

        //Way to load the original database into the user list
        Repository.loadDataBase();

        //Display unique category names
        STDOUT.info(Utils.getUniqueCategory(Repository.getInstance().getListMeal()).toString() + "\n");

        //Display unique meal names
        STDOUT.info(Utils.getUniqueNames(Repository.getInstance().getListMeal()).toString());
    }
}
