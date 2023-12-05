package hu.nye.progtech.views;

import hu.nye.progtech.gamelogic.WumpusLogic;
import hu.nye.progtech.models.ConsoleColor;
import hu.nye.progtech.models.MenuCallback;

/**
 * Let's call this as the first sentence,
 * here the second one.
 */
public class Shoot {

    public static boolean viewLoop = true;

    /**
     * Let's call this as the first sentence,
     * here the second one.
     */
    public static void show(WumpusLogic gameLogic, MenuCallback callback) {
        viewLoop = true;
        while (viewLoop) {
            System.out.println(ConsoleColor.BLUE + "-----------------Lövés--------------------" + ConsoleColor.RESET);
            if (gameLogic.getHero().getArrowCount() != 0) {
                // van lőszere
                if (gameLogic.shootWithArrow()) {
                    System.out.println("Megölted a Wumpust");
                } else {
                    System.out.println("Az íjjad falba ütközött");
                }
            } else {
                System.out.println("Nincs több íjjad");
            }
            callback.call(-1); // mivel nincs menüpont, a callback arra kell, hogy a loopot tötölje
        }
    }

    public static boolean close() {
        return viewLoop = false;
    }

}
