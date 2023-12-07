package hu.nye.progtech.enums;

/**
 * Let's call this as the first sentence,
 * here the second one.
 */
public enum ConsoleColor {
    RESET("\033[0m"),
    ANSI_GREEN_BACKGROUND("\u001B[42m"),
    GREEN("\033[0;32m"),
    BLUE("\033[0;34m");

    private final String consoleColorCode;
    ConsoleColor(String consoleColorCode){
        this.consoleColorCode = consoleColorCode;
    }
    public String getColor() {
        return this.consoleColorCode;
    }
}
