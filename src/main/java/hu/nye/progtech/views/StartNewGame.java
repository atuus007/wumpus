package hu.nye.progtech.views;

import java.util.Scanner;

import hu.nye.progtech.enums.ConsoleColor;
import hu.nye.progtech.models.MenuCallback;

/**
 * Let's call this as the first sentence,
 * here the second one.
 */
public class StartNewGame {

    public static boolean viewLoop = true;
    static int viewMenu = -1;

    /**
     * Let's call this as the first sentence,
     * here the second one.
     */
    public static void show(MenuCallback callback) {
        viewLoop = true;
        while (viewLoop) {
            System.out.println(ConsoleColor.BLUE.getColor() + "-----------------Új játék indítása--------------------" + ConsoleColor.RESET.getColor());

            System.out.println(ConsoleColor.GREEN.getColor() + "1." + ConsoleColor.RESET.getColor() + " Név megadása");
            System.out.println(ConsoleColor.GREEN.getColor() + "2." + ConsoleColor.RESET.getColor() + " Vissza");
            System.out.print("menü: ");
            Scanner scanner = new Scanner(System.in);
            if (scanner.hasNextInt()) {
                viewMenu = scanner.nextInt();
            }
            callback.call(viewMenu);
        }
    }

    public static boolean close() {
        return viewLoop = false;
    }

}
