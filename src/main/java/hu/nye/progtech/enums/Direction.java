package hu.nye.progtech.enums;

/**
 * Let's call this as the first sentence,
 * here the second one.
 */
public enum Direction {
    North('N'),
    East('E'),
    South('S'),
    West('W');
    private final char displayDirection;
    Direction(char displayDirection) {
        this.displayDirection = displayDirection;
    }
    public char getDisplayDirection(){
        return this.displayDirection;
    }
    public static Direction getDirectionFromChar(char directionLetter) {
        for (Direction b : Direction.values()) {
            if (b.displayDirection==directionLetter) {
                return b;
            }
        }
        return null;
    }
}
