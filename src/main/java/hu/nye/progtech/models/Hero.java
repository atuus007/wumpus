package hu.nye.progtech.models;

import hu.nye.progtech.enums.Direction;

/**
 * Let's call this as the first sentence,
 * here the second one.
 */
public class Hero extends FieldObject {
    private  int id;
    private char startColumn;
    private int startRow;
    private Direction direction;
    private int arrowCount;
    private String name;

    public Hero(
            int id,
            char column,
            int row,
            Direction direction,
            int arrowCount,
            String name,
            int step,
            char startColumn,
            int  startRow,
            boolean hasGold,
            int matrixLength
    ) {
        super('H', column, row, id, matrixLength);
        this.id = id;
        this.direction = direction;
        this.arrowCount = arrowCount;
        this.name = name;
        this.step = step;
        this.startColumn = startColumn;
        this.startRow = startRow;
        this.hasGold = hasGold;
    }

    public Hero() {
        super('H', '0', 0, 0, 0);
        this.direction = Direction.East;
        this.arrowCount = 0;
        this.name = "";
    }

    public int getId() {
        return id;
    }

    public void setStartColumn(char startColumn) {
        this.startColumn = startColumn;
    }

    public void setStartRow(int startRow) {
        this.startRow = startRow;
    }

    public char getStartColumn() {
        return startColumn;
    }

    public int getStartRow() {
        return startRow;
    }

    public boolean isWinner() {
        return getRow() == getStartRow() && getColumn() == getStartColumn() && hasGold();
    }

    public void setStep(int step) {
        this.step = step;
    }

    public int getStep() {
        return step;
    }

    private int step;

    private boolean hasGold = false;

    public boolean hasGold() {
        return hasGold;
    }

    public void setThereIsGold(boolean hasGold) {
        this.hasGold = hasGold;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getArrowCount() {
        return arrowCount;
    }

    public void setArrowCount(int arrowCount) {
        this.arrowCount = arrowCount;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    /**
     * Let's call this as the first sentence,
     * here the second one.
     */
    public String getDirectionAsCharacter() {
        return switch (direction) {
            case East -> "→";
            case South -> "↓";
            case West -> "←";
            default -> "↑";
        };
    }

    /**
     * Let's call this as the first sentence,
     * here the second one.
     */
    public Direction turnRight() {
        if (this.getDirection().ordinal() != 3) {
             this.setDirection(Direction.values()[this.getDirection().ordinal() + 1]);
        } else {
            this.setDirection(Direction.values()[0]);
        }
        return this.getDirection();
    }

    /**
     * Let's call this as the first sentence,
     * here the second one.
     */
    public Direction turnLeft() {
        if (this.getDirection().ordinal() != 0) {
            this.setDirection(Direction.values()[this.getDirection().ordinal() - 1]);
        } else {
            this.setDirection(Direction.values()[3]);
        }
        return this.getDirection();
    }

    /**
     * Let's call this as the first sentence,
     * here the second one.
     */
    public int lostAnArrow() {
        if (getArrowCount() != 0) {
            setArrowCount(getArrowCount() - 1);
        }
        return getArrowCount();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Hero{");
        sb.append("name=").append(name);
        sb.append(", direction=").append(direction);
        sb.append(", arrowCount=").append(arrowCount);
        sb.append(", shortCut=").append(this.getShortCut());
        sb.append(", column=").append(this.getColumn());
        sb.append(", row=").append(this.getRow());
        sb.append(", hasGold=").append(this.hasGold);
        sb.append('}');
        return sb.toString();
    }
}
