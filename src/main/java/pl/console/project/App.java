package pl.console.project;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.console.project.menu.Menu;

public class App {

    private static final Logger STDOUT = LoggerFactory.getLogger("CONSOLE_OUT");

    public static void main(String[] args) {




        //STDOUT.info(Repository.getInstance().getListMeal().toString());
//        Menu.intro();
//        DisplayMenu.displayMealsInMenu(Repository.getInstance().getListMeal());
//        DisplayMenu.displayMealsInMenu(Utils.getUniqueCategory(Repository.getInstance().getListMeal()));
        Menu.mainMenu();

//        Menu.mainMenu(); //comment this line to check how the methods below work

//        //Display users ListMeal
//        STDOUT.info(Repository.getInstance().getListMeal().toString());
//
//        //Display fav ListMeal
//        STDOUT.info(Repository.getInstance().getFavoriteListMeal().toString());
//
//        //Way to load the original database into the user list
//        Repository.loadDataBase();
//
//        //Display unique category names
//        STDOUT.info(Utils.getUniqueCategory(Repository.getInstance().getListMeal()).toString() + "\n");
//
//        //Display unique meal names
//        STDOUT.info(Utils.getUniqueNames(Repository.getInstance().getListMeal()).toString());
    }
}
