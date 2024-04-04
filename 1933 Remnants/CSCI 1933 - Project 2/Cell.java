public class Cell {
    // sets variables for class Cell
    private int row, col;
    private char status;
    public int ID;
    Battleboat boat;

    // sets row, column, status
    public Cell(int row, int col, char status) {
        this.row = row;
        this.col = col;
        this.status = status;
    }
    // returns status character
    public char getStatus() {
        return status;
    }
    // sets status character
    public void setStatus(char c) {
        this.status = c;
    }
    // gets row
    public int getRow() {
        return row;
    }
    // gets column
    public int getCol() {
        return col;
    }
}