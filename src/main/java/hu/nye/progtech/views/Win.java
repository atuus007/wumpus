package hu.nye.progtech.views;

import hu.nye.progtech.gamelogic.WumpusLogic;
import hu.nye.progtech.models.ConsoleColor;
import hu.nye.progtech.models.MenuCallback;

/**
 * Let's call this as the first sentence,
 * here the second one.
 */
public class Win {

    public static boolean viewLoop = true;

    static int viewMenu = -1;

    /**
     * Let's call this as the first sentence,
     * here the second one.
     */
    public static void show(WumpusLogic wumpusLogic, MenuCallback callback) {
        viewLoop = true;
        while (viewLoop) {
            System.out.println(ConsoleColor.BLUE + "-----------------Nyertél--------------------" + ConsoleColor.RESET);
            String extend = " lépés számmal visszatérned az arannyal a kezdőpontra!";
            System.out.println("Gratulálok! Sikerült " + wumpusLogic.getHero().getStep() + extend);
            callback.call(viewMenu);
        }
    }

    public static boolean close() {
        return viewLoop = false;
    }

}
