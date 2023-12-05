package hu.nye.progtech.models;

/**
 * Let's call this as the first sentence,
 * here the second one.
 */
public class FieldObject {
    private int userID;
    private char shortCut;
    private char column;
    private int row;
    private  int matrixLength;

    public int getUserID() {
        return userID;
    }

    public FieldObject(char shortCut, char column, int row, int userID, int matrixLength) {
        this.shortCut = shortCut;
        this.column = column;
        this.row = row;
        this.userID = userID;
        this.matrixLength = matrixLength;
    }

    public int getMatrixLength() {
        return matrixLength;
    }

    public char getShortCut() {
        return shortCut;
    }

    public void setShortCut(char shortCut) {
        this.shortCut = shortCut;
    }

    public char getColumn() {
        return column;
    }

    public void setColumn(char column) {
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("FieldObject{");
        sb.append("shortCut=").append(shortCut);
        sb.append(", column=").append(column);
        sb.append(", row=").append(row);
        sb.append('}');
        return sb.toString();
    }
}
