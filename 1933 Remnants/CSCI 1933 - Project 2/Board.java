import java.util.Random;

public class Board {
    // sets variables for class Board
    private int numBoats;
    private Battleboat[] boats;
    private Cell[][] board;
    private int[] boatSizes;

    // constructor for Board, sets size of board
    public Board(int size) {
        this.board = new Cell[size][size];
        // makes grid with status "-"
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                board[i][j] = new Cell(i, j, '-');
            }
        }
        // uses ternary (boolean if t/else f expressions) to set number of boats from size
        this.numBoats = size == 3 ? 1 
            : (size == 6 ? 3 
            : 5);
        this.boats = new Battleboat[numBoats];
        this.placeBoats();
    }
    
    // radomly places boats on the grid depending on numBoats
    public void placeBoats() {
        // calling on random class for this
        Random random = new Random();
        int c = 0, s = board.length;
        
        this.boatSizes = this.numBoats == 1 ? new int[]{
            2
        } : (this.numBoats == 3 ? new int[]{
            4, 3, 2
        } : new int[]{
            5, 4, 3, 3, 2
        });
        // for b in boatSizes
        for(int b : this.boatSizes) {
            // makes boat with length b
            this.boats[c] = new Battleboat(b);
            Cell[] thisBoat = new Cell[b];
            // main label (used to keep random generating)
            main: while(true) {
                // generates random x/y and direction
                int gy = random.nextInt(s);
                int gx = random.nextInt(s);
                boolean down = random.nextBoolean();
                
                // make sure boat is possible / inbounds
                if((down && gy + b >= s) || (!down && gx + b >= s)) {
                    continue;
                }
                // sets the status on grid for boats / checks if boat can be placed
                for(int set = 0; set < 2; set++, this.boats[c].setOrientation(down)) {
                    for(int i = 0; i < b; i++) {
                        // location on boat
                        int oy = gy + (down ? i : 0);
                        int ox = gx + (down ? 0 : i);
                        // sets status on grid to "B" if possible
                        if(set == 1) {
                            // fills in the boat status
                            board[oy][ox].setStatus('B');
                            board[oy][ox].ID = c + 1;
                            board[oy][ox].boat = this.boats[c];
                            thisBoat[i] = board[oy][ox];
                        // checks if location is occupied
                        }
                        else if(board[oy][ox].getStatus() != '-') {
                            // returns to main to generate a new ship
                            continue main;
                        }
                    }
                }
                break;
            }
            // places boat parts
            this.boats[c].setSpaces(thisBoat);
            // updates id for next ship
            c++;
        }
    }
    // "Fires" shot
    public int fire(int x, int y) {
        // checks if out of bounds
        if(x < 0 || y < 0 || x >= board.length || y >= board.length) {
             return 1;
        }
        char s = board[y][x].getStatus();
        // checks if miss
        if(s == '-') {
            board[y][x].setStatus('M');
            return 0;
        }
        // checks if hit
        if(s == 'B') {
            board[y][x].setStatus('H');
            for(Cell c : board[y][x].boat.getSpaces()) {
                if(c.getStatus() != 'H') {
                    return 2;
                }
            }
            for(Battleboat b : boats) {
                for(Cell c : b.getSpaces()) {
                    if(c.getStatus() == 'B') {
                        return -1;
                    }
                }
            }
            return 3;
        }
        // checks if already guessed
        if(s == 'H' || s == 'M') {
            return 1;
        }
        // returns 0 so it will work now
        return 0;
    }
    // displays the board with boats and empty space (debug view)
    public void display() {
        System.out.println("Debug View:");
        for(int i = 0; i < board.length; i++) {
            for(int o = 0; o < board[i].length; o++) {
                System.out.print(" " + (board[i][o].ID == 0 ? "*" : board[i][o].ID) + " ");

            }
            System.out.println();
        }
        System.out.println("\nPlayer View:");
        print();
    }
    // displays the board with empty space (player view)
    public void print() {
        // iterates and prints characters on board
        for(int i = 0; i < board.length; i++) {
            for(int o = 0; o < board[i].length; o++) {
                char c;
                switch(board[i][o].getStatus()) {
                    case 'M':
                       c = 'O';
                       break;
                    case 'H':
                        c = 'X';
                        break; 
                    default:
                        c = '#';
                }
                System.out.print(" "+c+" ");
            }
            System.out.println();
        }
    }
} 