package hu.nye.progtech.views;

import java.util.Scanner;

import hu.nye.progtech.enums.ConsoleColor;
import hu.nye.progtech.models.MenuCallback;
/**
 * Let's call this as the first sentence,
 * here the second one.
 */

public class GiveYourName {

    public static boolean viewLoop = true;
    static int viewMenu = -1;

    public static String name = "";

    /**
     * Let's call this as the first sentence,
     * here the second one.
     */
    public static void show(MenuCallback callback) {
        viewLoop = true;
        while (viewLoop) {
            System.out.println(ConsoleColor.BLUE.getColor() + "-----------------APP--------------------" + ConsoleColor.RESET.getColor());
            Scanner scanner = new Scanner(System.in);
            System.out.print("felhasználónév: ");
            if (scanner.hasNext()) {
                name = scanner.nextLine();
            }
            System.out.println(ConsoleColor.GREEN.getColor() + "1." + ConsoleColor.RESET.getColor() + " Wumpusz indítása");
            System.out.println(ConsoleColor.GREEN.getColor() + "2." + ConsoleColor.RESET.getColor() + " Név módosítása");
            System.out.println(ConsoleColor.GREEN.getColor() + "3." + ConsoleColor.RESET.getColor() + " Vissza");
            System.out.print("menü: ");
            if (scanner.hasNextInt()) {
                viewMenu = scanner.nextInt();
            }
            callback.call(viewMenu);
        }
    }

    public static void repeat() {
        viewLoop = true;
    }

    public static void close() {
        viewLoop = false;
    }


}
