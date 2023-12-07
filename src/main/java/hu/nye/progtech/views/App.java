package hu.nye.progtech.views;

import java.util.Scanner;

import hu.nye.progtech.enums.ConsoleColor;
import hu.nye.progtech.models.MenuCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Let's call this as the first sentence,
 * here the second one.
 */
public class App {
    private static final Logger logger = LoggerFactory.getLogger(App.class);

    public static boolean viewLoop = true;
    static int viewMenu = -1;

    /**
     * Let's call this as the first sentence,
     * here the second one.
     */
    public static void show(MenuCallback callback) {
        logger.info("Játék elindítva");
        viewLoop = true;
        while (viewLoop) {
            System.out.println(ConsoleColor.BLUE.getColor() + "-----------------APP--------------------" + ConsoleColor.RESET.getColor());

            System.out.println(ConsoleColor.GREEN.getColor() + "1." + ConsoleColor.RESET.getColor() + " Játék indítása");
            System.out.println(ConsoleColor.GREEN.getColor() + "2." + ConsoleColor.RESET.getColor() + " Kilépés");
            System.out.print("menü: ");
            Scanner scanner = new Scanner(System.in);
            if (scanner.hasNextInt()) {
                viewMenu = scanner.nextInt();
            }
            callback.call(viewMenu);
        }
        logger.info("Játék bezárva");
    }

    public static void close() {
        viewLoop = false;
    }

}
