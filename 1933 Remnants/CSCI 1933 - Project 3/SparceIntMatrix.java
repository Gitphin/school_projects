import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.HashMap;

public class SparceIntMatrix {
    // stores num of rows and columns
    private int nrows, ncols;
    public SparceIntMatrix(int numRows, int numCols) {
        this.nrows = numRows;
        this.ncols = numCols;
    }
    // using hashmap(col) of hashmap(row) to map out matrix
    HashMap<Integer, HashMap<Integer, MatrixEntry>> map;
    public SparceIntMatrix(int numRows, int numCols, String inputFile) throws FileNotFoundException {
        this.nrows = numRows;
        this.ncols = numCols;
        // scanner reads file    
        Scanner s = new Scanner(new File(inputFile));       
        map = new HashMap<Integer, HashMap<Integer, MatrixEntry>>();
        // MatrixEntry pre = null;
        while(s.hasNextLine()) {
            // splits 3 times into array, then passes into MatrixEntry
            String[] chrs = s.nextLine().split(",", 3);      
            int col = Integer.parseInt(chrs[1]);
            int row = Integer.parseInt(chrs[0]);
            int dat = Integer.parseInt(chrs[2]);
            this.setElement(row,col,dat);
            // MatrixEntry cur = new MatrixEntry(col, row, dat);          
            // if map doesnt have column, places into hashmap
            // if(!map.containsKey(col)) {
            //     map.put(col, new HashMap<Integer, MatrixEntry>());
            // }
            // // puts cur in the col/row
            // map.get(col).put(row, cur);
            
            // if(pre != null) {
            //     // updates neighbours of its arrival
            //     if(pre.getRow() == cur.getRow() - 1) {
            //         pre.setNextCol(cur);
            //     }
            //     if(map.containsKey(col)) {
            //         // gets col from map
            //         HashMap<Integer, MatrixEntry> nm = map.get(col);
            //         if(nm.containsKey(row - 1)) {
            //             nm.get(row).setNextRow(cur);
            //         }
            //     }
            // }
            // pre = cur;
        }
    }
    // helper function, returns entry at location if exists, else returns null
    public MatrixEntry getEntry(int row, int col) {
        return (map.containsKey(col) && map.get(col).containsKey(row)) ? map.get(col).get(row) : null;
    }
    public void setElement(int row, int col, int data) {
        // if no col exists, gives map col
        if(!map.containsKey(col)) {
            map.put(col, new HashMap<Integer, MatrixEntry>());
        }
        HashMap<Integer, MatrixEntry> nm = map.get(col);
        // checks if has row, sets data from row
        if(nm.containsKey(row)) {
            nm.get(row).setData(data);
        } else {
            // if not, places new MatrixEntry
            nm.put(row, new MatrixEntry(row, col, data));
        }
        
        // creates null MatrixEntry
        MatrixEntry cur = nm.get(row), e;
        int off;
        
        // all of this updates neighbours of arrival
        off = 0;
        while(row - (++off) > -1) {
            if((e = getEntry(row - off, col)) != null) {
                e.setNextRow(cur);
                break;
            }
        }
        off = 0;
        while(row + (++off) < nrows) {
            if((e = getEntry(row + off, col)) != null) {
                cur.setNextRow(e);
                break;
            }
        }
        off = 0;
        while(col - (++off) > -1) {
            if((e = getEntry(row, col - off)) != null) {
                e.setNextCol(cur);
                break;
            }
        }
        off = 0;
        while(col + (++off) < ncols) {
            if((e = getEntry(row, col + off)) != null) {
                cur.setNextCol(e);
                break;
            }
        }
    }
    public boolean removeElement(int row, int col) {
        // checks if col exists, if no returns false 
        if(!map.containsKey(col)) {
            return false;
        }
        HashMap<Integer, MatrixEntry> nm = map.get(col);
        // checks if row exists, if no returns false
        if(!nm.containsKey(row)) {
            return false;
        }
        // removes row 
        nm.remove(row);
        
        // null MatrixEntry
        MatrixEntry e;
        int off;
        
        // updates neighbours of arrival, returns true
        off = 0;
        while(row - (++off) > -1) {
            if((e = getEntry(row - off, col)) != null) {
                e.setNextRow(null);
                break;
            }
        }
        off = 0;
        while(col - (++off) > -1) {
            if((e = getEntry(row, col - off)) != null) {
                e.setNextCol(null);
                break;
            }
        }
        return true;
    }
    public int getElement(int row, int col) {
        // returns element if not null, else returns 0 (uses helper function)
        MatrixEntry e = getEntry(row, col);
        return e == null ? 0 : e.getData();
    }
    // returns num of cols
    public int getNumCols() {
        return this.ncols;
    }
    // returns num of rows
    public int getNumRows() {
        return this.nrows;
    }
    // iterates and adds two SparceIntMatrices together
    public boolean plus(SparceIntMatrix otherMat) {
        for(int i = 0; i < ncols; i++) {
            for(int o = 0; o < ncols; o++) {
                this.setElement(i, o, this.getElement(i, o) + otherMat.getElement(i, o));
            }
        }
        return true;
    }
    // iterates and subtracts two SparceIntMatrices together
    public boolean minus(SparceIntMatrix otherMat) {
        for(int i = 0; i < ncols; i++) {
            for(int o = 0; o < ncols; o++) {
                this.setElement(i, o, this.getElement(i, o) - otherMat.getElement(i, o));
            }
        }
        return true;
    }
}
