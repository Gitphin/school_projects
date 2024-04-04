import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        // sets turn counter and scanner
        int count = 1;
        Scanner s = new Scanner(System.in);

        // asks user what mode and difficulty
        System.out.print("Activate debug mode (Y/N): ");
        // checks if first character of input is 'y'
        Boolean debug_mode = Character.toLowerCase(s.nextLine().charAt(0)) == 'y';
        System.out.print("Enter difficulty (E/M/H): ");
        
        // determines dimension for board from user input
        int d = 0;
        switch(Character.toLowerCase(s.nextLine().charAt(0))) {
            case 'e':
                d = 3;
                break;
            case 'm':
                d = 6;
                break;
            case 'h':
                d = 9;
        }
        // creates board with user input dimensions
        Board board = new Board(d);
    
        // mainLoop label
        mainLoop: while(true) {
            // if user request debug mode displays board as debug mode, else prints as player mode
            if(debug_mode) { 
                board.display(); 
            } 
            else { 
                board.print(); 
            }
            // asks user to enter coordinates to hit
            System.out.print("\nTurn " + count + ": Enter a position (X Y): ");
            
            // takes first int as x and next as y
            int x = s.nextInt();
            int y = s.nextInt();
            // based on input, checks situations and prints
            switch(board.fire(x, y)) {
                case -1:
                    System.out.println("\nHit! Boat sunk!\n");
                    break;
                case 2:
                    System.out.println("\nHit!\n");
                    break;
                case 0:
                    System.out.println("\nMiss!\n");
                    break;
                case 1:
                    System.out.println("\nInvalid entry. Turn skipped!\n");
                    count++;
                    break;
                case 3:
                    System.out.println("\nHit! You sunk every boat!\n");
                    if(debug_mode) { 
                        board.display(); 
                    } 
                    else { 
                        board.print(); 
                    }
                    // prints turns and breaks the loop, ending the game
                    System.out.println("\nTurns: " + count);
                    break mainLoop;
            }
            // keeps track of turns
            count++;
        }
    }
}