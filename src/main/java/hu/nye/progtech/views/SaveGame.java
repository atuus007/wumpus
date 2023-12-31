package hu.nye.progtech.views;

import hu.nye.progtech.enums.ConsoleColor;
import hu.nye.progtech.models.MenuCallback;

/**
 * Let's call this as the first sentence,
 * here the second one.
 */
public class SaveGame {

    public static boolean viewLoop = true;
    static int viewMenu = -1;

    /**
     * Let's call this as the first sentence,
     * here the second one.
     */
    public static void show(MenuCallback callback) {
        viewLoop = true;
        while (viewLoop) {
            System.out.println(ConsoleColor.BLUE.getColor() + "-----------------Játék mentése--------------------" + ConsoleColor.RESET.getColor());
            System.out.println("játék mentve");
            callback.call(viewMenu);
        }
    }

    public static boolean close() {
        return viewLoop = false;
    }

}
