package hu.nye.progtech.gamelogic;

import java.util.Comparator;
import java.util.stream.IntStream;

import hu.nye.progtech.enums.ConsoleColor;
import hu.nye.progtech.models.FieldObject;
import hu.nye.progtech.models.Hero;

/**
 * Let's call this as the first sentence,
 * here the second one.
 */
public class FieldDrawer {

    /**
     * Let's call this as the first sentence,
     * here the second one.
     */
    private boolean conditionForColoring(FieldObject fieldElement, Hero hero) {
        return fieldElement.getColumn() == hero.getColumn() && fieldElement.getRow() == hero.getRow();
    }

    /**
     * Let's call this as the first sentence,
     * here the second one.
     */
    public void draw(WumpusLogic wumpusLogic) {

        wumpusLogic.field.sort(Comparator
                .comparing(FieldObject::getRow)
                .thenComparing(FieldObject::getColumn));
        IntStream.range(0, wumpusLogic.getHero().getMatrixLength() + 1).forEach(column -> {
            if ((column == 0)) {
                System.out.printf("%c\t", ' ');
            } else {
                System.out.printf("%3c", (char) column + 64);
            }

        });
        System.out.print("\n\n");
        wumpusLogic.field.forEach((fieldElement) -> {
            if (fieldElement.getColumn() - 64 ==  wumpusLogic.getHero().getMatrixLength()) {
                if (fieldElement.getColumn() - 64 == 0) {
                    if (conditionForColoring(fieldElement, wumpusLogic.getHero())) {
                        System.out.printf(ConsoleColor.ANSI_GREEN_BACKGROUND.getColor() + "%3s\n" + ConsoleColor.RESET.getColor() , fieldElement.getShortCut());
                    } else {
                        System.out.printf("%3s\n", fieldElement.getShortCut());
                    }
                } else {
                    if (conditionForColoring(fieldElement, wumpusLogic.getHero())) {
                        System.out.printf(ConsoleColor.ANSI_GREEN_BACKGROUND.getColor()  + "%3s\n" + ConsoleColor.RESET.getColor() , fieldElement.getShortCut());
                    } else {
                        System.out.printf("%3s\n", fieldElement.getShortCut());
                    }
                }

            } else {
                if (fieldElement.getColumn() == 'A') {
                    if (conditionForColoring(fieldElement, wumpusLogic.getHero())) {
                        System.out.printf(ConsoleColor.ANSI_GREEN_BACKGROUND.getColor()  + "%d\t" + ConsoleColor.RESET.getColor() , fieldElement.getRow());
                    } else {
                        System.out.printf("%d\t", fieldElement.getRow());
                    }

                }
                if (conditionForColoring(fieldElement, wumpusLogic.getHero())) {
                    System.out.printf(ConsoleColor.ANSI_GREEN_BACKGROUND.getColor()  + "%3s" + ConsoleColor.RESET.getColor() , fieldElement.getShortCut());
                } else {
                    System.out.printf("%3s", fieldElement.getShortCut());
                }

            }
        });
    }
}
