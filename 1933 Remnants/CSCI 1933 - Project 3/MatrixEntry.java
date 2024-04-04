class MatrixEntry {
    private int row, col, data;
    private MatrixEntry nextrow, nextcol;
    // initializes MatrixEntry with a location row/column, and data associated with location.
    public MatrixEntry(int row, int col, int data) {
        this.row = row;
        this.col = col;
        this.data = data;
    }
    // gets column
    public int getColumn() {
        return this.col;
    }
    // sets column
    public void setColumn(int col) {
        this.col = col;
    }
    // gets row
    public int getRow() {
        return this.row;
    }
    // sets row
    public void setRow(int row) {
        this.row = row;
    }
    // gets data
    public int getData() {
        return this.data;
    }
    // sets data
    public void setData(int data) {
        this.data = data;
    }
    // gets next MatrixEntry in row
    public MatrixEntry getNextRow() {
        return this.nextrow;
    }
    // sets next MatrixEntry in row
    public void setNextRow(MatrixEntry el) {
        this.nextrow = el;
    }
    // gets next MatrixEntry in col
    public MatrixEntry getNextCol() {
        return this.nextcol;
    }
    // sets next MatrixEntry in col
    public void setNextCol(MatrixEntry el) {
        this.nextcol = el;
    }
    // toString used to test MatrixEntry functions
    public String toString(boolean i) {
        // allows for indenting when multiple MatrixEntry occur.
        String r = "", del = i ? "    " : r;
        // using string formatting to make it look better
        for(String s : String.format("Loc: (%s, %s)\nData: %s\nNext row:\n%sNext col:\n%s",
            row, col, data,
            nextrow == null ? (del + "None\n") : nextrow.toString(true),
            nextcol == null ? (del + "None\n") : nextcol.toString(true)
        ).split("\n")) r += del + s + '\n';
        return r;
    }
    public String toString() {
        return toString(false);
    }
}