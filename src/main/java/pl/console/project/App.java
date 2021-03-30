package pl.console.project;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.console.project.repositories.Repository;

public class App {

    private static final Logger STDOUT = LoggerFactory.getLogger("CONSOLE_OUT");

    public static void main(String[] args) {

        STDOUT.info(Repository.getInstance().getListMeal().toString());
        STDOUT.info(Repository.getInstance().getFavoriteListMeal().toString());
    }
}
