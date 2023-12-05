package hu.nye.progtech.views;

import hu.nye.progtech.gamelogic.WumpusLogic;
import hu.nye.progtech.models.ConsoleColor;
import hu.nye.progtech.models.MenuCallback;

/**
 * Let's call this as the first sentence,
 * here the second one.
 */
public class Move {

    public static boolean viewLoop = true;

    /**
     * Let's call this as the first sentence,
     * here the second one.
     */
    public static void show(WumpusLogic gameLogic, MenuCallback callback) {
        viewLoop = true;
        while (viewLoop) {
            System.out.println(ConsoleColor.BLUE + "-----------------Lépés--------------------" + ConsoleColor.RESET);
            System.out.println(gameLogic.goStraightAhead());
            callback.call(-1);
        }
    }

    public static boolean close() {
        return viewLoop = false;
    }

}
