package hu.nye.progtech.views;

import java.util.Scanner;

import hu.nye.progtech.gamelogic.FieldDrawer;
import hu.nye.progtech.gamelogic.LoadFrom;
import hu.nye.progtech.gamelogic.WumpusLogic;
import hu.nye.progtech.gamelogic.db.DatabaseLoader;
import hu.nye.progtech.enums.ConsoleColor;
import hu.nye.progtech.models.MenuCallback;


/**
 * Let's call this as the first sentence,
 * here the second one.
 */
public class Wumpus {


    public static boolean viewLoop = true;
    public static DatabaseLoader databaseLoader;
    static int viewMenu = -1;

    public static WumpusLogic gameLogic = null;
    public Wumpus() {

    }
    /**
     * Let's call this as the first sentence,
     * here the second one.
     */
    public static void loadDataFromDb(int id) {

        gameLogic = new WumpusLogic(LoadFrom.database, id, databaseLoader);

    }

    /**
     * Let's call this as the first sentence,
     * here the second one.
     */
    public static void loadDataFromFile(String name) {
        gameLogic = new WumpusLogic(LoadFrom.file, 0, databaseLoader);
        gameLogic.getHero().setName(name);
    }

    /**
     * Let's call this as the first sentence,
     * here the second one.
     */
    public static void show(MenuCallback callback) {
        //FieldDrawer fieldDrawer = new FieldDrawer();
        viewLoop = true;
        while (viewLoop) {
            System.out.println(ConsoleColor.BLUE.getColor() + "-----------------Wumpus--------------------" + ConsoleColor.RESET.getColor());
            // kezdő pálya betöltése
            //FieldDrawer.draw(gameLogic);
            //fieldDrawer.draw(gameLogic);
            //fieldDrawer.draw(gameLogic);
            new FieldDrawer().draw(gameLogic);

            // hős adatai
            System.out.println("Hős adatai:");
            System.out.println("neve: " + ConsoleColor.GREEN.getColor() + gameLogic.getHero().getName() + ConsoleColor.RESET.getColor());
            String extend = "," + gameLogic.getHero().getRow() + ConsoleColor.RESET.getColor();
            System.out.println("pozíciója: " + ConsoleColor.GREEN.getColor() + gameLogic.getHero().getColumn() + extend);
            String startPoint = "," + gameLogic.getHero().getStartRow() + ConsoleColor.RESET.getColor();
            System.out.println("kezdő pozícízó: " + ConsoleColor.GREEN.getColor() + gameLogic.getHero().getStartColumn() + startPoint);
            System.out.println("iránya: " + ConsoleColor.GREEN.getColor() + gameLogic.getHero().getDirectionAsCharacter() + ConsoleColor.RESET.getColor());
            System.out.println("arany: " + ConsoleColor.GREEN.getColor() + gameLogic.getHero().hasGold() + ConsoleColor.RESET.getColor());
            System.out.println("nyilak száma: " + ConsoleColor.GREEN.getColor() + gameLogic.getHero().getArrowCount() + ConsoleColor.RESET.getColor());
            System.out.println("lépések száma: " + ConsoleColor.GREEN.getColor() + gameLogic.getHero().getStep() + ConsoleColor.RESET.getColor());


            System.out.println(ConsoleColor.GREEN.getColor()  + "1. " + ConsoleColor.RESET.getColor()  + "Játék mentése");
            System.out.println(ConsoleColor.GREEN.getColor()  + "2. " + ConsoleColor.RESET.getColor()  + "Játék feladása (kilépés)");
            System.out.println(ConsoleColor.GREEN.getColor()  + "3. " + ConsoleColor.RESET.getColor()  + "Lépés");
            System.out.println(ConsoleColor.GREEN.getColor()  + "4. " + ConsoleColor.RESET.getColor()  + "Lövés");
            System.out.println(ConsoleColor.GREEN.getColor()  + "5. " + ConsoleColor.RESET.getColor()  + "Balra fordulás");
            System.out.println(ConsoleColor.GREEN.getColor()  + "6. " + ConsoleColor.RESET.getColor()  + "Jobbra fordulás");
            System.out.println(ConsoleColor.GREEN.getColor()  + "7. " + ConsoleColor.RESET.getColor()  + "Arany felvétele");
            System.out.print("Menü: ");

            Scanner scanner = new Scanner(System.in);
            if (scanner.hasNextInt()) {
                viewMenu = scanner.nextInt();
            }
            System.out.flush();
            callback.call(viewMenu);
        }
    }

    /**
     * Let's call this as the first sentence,
     * here the second one.
     */
    public static boolean isWin() {
        if (gameLogic.isWin()) {
            //FieldDrawer.draw(gameLogic);
        }
        return gameLogic.isWin();
    }

    /**
     * Let's call this as the first sentence,
     * here the second one.
     */
    public static boolean isGameOver() {
        return gameLogic.isGameOver();
    }


    /**
     * Let's call this as the first sentence,
     * here the second one.
     */
    public static boolean close() {
        return viewLoop = false;
    }

}
