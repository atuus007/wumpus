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
    private FieldDrawer fieldDrawer;
    public static WumpusLogic gameLogic = null;
    public Wumpus() {
        this.fieldDrawer = new FieldDrawer();
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
    public void show(MenuCallback callback) {
        viewLoop = true;
        while (viewLoop) {
            System.out.println(ConsoleColor.BLUE + "-----------------Wumpus--------------------" + ConsoleColor.RESET);
            // kezdő pálya betöltése
            //FieldDrawer.draw(gameLogic);
            //this.fieldDrawer(gameLogic);

            // hős adatai
            System.out.println("Hős adatai:");
            System.out.println("neve: " + ConsoleColor.GREEN + gameLogic.getHero().getName() + ConsoleColor.RESET);
            String extend = "," + gameLogic.getHero().getRow() + ConsoleColor.RESET;
            System.out.println("pozíciója: " + ConsoleColor.GREEN + gameLogic.getHero().getColumn() + extend);
            String startPoint = "," + gameLogic.getHero().getStartRow() + ConsoleColor.RESET;
            System.out.println("kezdő pozícízó: " + ConsoleColor.GREEN + gameLogic.getHero().getStartColumn() + startPoint);
            System.out.println("iránya: " + ConsoleColor.GREEN + gameLogic.getHero().getDirectionAsCharacter() + ConsoleColor.RESET);
            System.out.println("arany: " + ConsoleColor.GREEN + gameLogic.getHero().hasGold() + ConsoleColor.RESET);
            System.out.println("nyilak száma: " + ConsoleColor.GREEN + gameLogic.getHero().getArrowCount() + ConsoleColor.RESET);
            System.out.println("lépések száma: " + ConsoleColor.GREEN + gameLogic.getHero().getStep() + ConsoleColor.RESET);


            System.out.println(ConsoleColor.GREEN + "1. " + ConsoleColor.RESET + "Játék mentése");
            System.out.println(ConsoleColor.GREEN + "2. " + ConsoleColor.RESET + "Játék feladása (kilépés)");
            System.out.println(ConsoleColor.GREEN + "3. " + ConsoleColor.RESET + "Lépés");
            System.out.println(ConsoleColor.GREEN + "4. " + ConsoleColor.RESET + "Lövés");
            System.out.println(ConsoleColor.GREEN + "5. " + ConsoleColor.RESET + "Balra fordulás");
            System.out.println(ConsoleColor.GREEN + "6. " + ConsoleColor.RESET + "Jobbra fordulás");
            System.out.println(ConsoleColor.GREEN + "7. " + ConsoleColor.RESET + "Arany felvétele");
            System.out.print("menü: ");

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
