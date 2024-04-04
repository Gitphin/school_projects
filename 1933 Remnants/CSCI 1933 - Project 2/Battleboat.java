public class Battleboat {
    // sets variables for class Battleboat
    private int size;
    private boolean orientation;
    private Cell[] spaces;

    // sets length of boat
    public Battleboat(int length) {
        this.size = length;
    }
    // gets size of boat
    public int getSize() {
        return this.size;
    }
    // sets direction of boat
    public void setOrientation(boolean orientation) {
        this.orientation = orientation;
    }
    // gets direction of boat
    public boolean getOrientation() {
        return this.orientation;
    }
    // sets Cell spaces
    public void setSpaces(Cell[] cells) {
        this.spaces = cells;
    }
    // gets Cell spaces
    public Cell[] getSpaces() {
        return this.spaces;
    }
}
