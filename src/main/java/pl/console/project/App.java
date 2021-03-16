package pl.console.project;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {

    private static final Logger STDOUT = LoggerFactory.getLogger("CONSOLE_OUT");

    public static void main(String[] args) {

        STDOUT.info("Hello!");

    }
}
