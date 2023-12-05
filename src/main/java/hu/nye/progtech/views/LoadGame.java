package hu.nye.progtech.views;

import java.util.List;
import java.util.Scanner;

import hu.nye.progtech.gamelogic.db.DatabaseLoader;
import hu.nye.progtech.models.ConsoleColor;
import hu.nye.progtech.models.Hero;
import hu.nye.progtech.models.MenuCallback;



/**
 * Let's call this as the first sentence,
 * here the second one.
 */
public class LoadGame {

    public static boolean viewLoop = true;

    static int userIndex = -1;

    /**
     * Let's call this as the first sentence,
     * here the second one.
     */
    public static void show(DatabaseLoader dbLoader, MenuCallback callback) {
        viewLoop = true;
        while (viewLoop) {
            System.out.println(ConsoleColor.BLUE + "-----------------Darabban maradt játékok--------------------" + ConsoleColor.RESET);
            List<Hero> heroes = dbLoader.getHeroes();
            if (!heroes.isEmpty()) {
                for (int i = 0; i < heroes.stream().count(); i++) {
                    System.out.println(ConsoleColor.GREEN + (i + 1)
                            + ConsoleColor.RESET + ". " + heroes.get(i).getName()
                            + ", lépésszám (" + heroes.get(i).getStep() + ")");
                }
            } else {
                System.out.println("Nincs darabban maradt játékod");
            }


            System.out.println(ConsoleColor.GREEN + ((long) heroes.size() + 1)  + ConsoleColor.RESET + ". Vissza");
            Scanner scanner = new Scanner(System.in);
            System.out.print("Menü: ");
            if (scanner.hasNext()) {
                userIndex = Integer.parseInt(scanner.nextLine());
            }
            callback.call(userIndex - 1);
        }
    }

    public static boolean close() {
        return viewLoop = false;
    }


}
