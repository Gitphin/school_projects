import java.lang.Math;
import java.util.HashMap;
import java.util.ArrayList;

public class HeatGrid {
    HashMap<Integer, ArrayList<Integer>> points;
    int[][] grid;
    HeatGrid(int w, int h) {
        this.points = new HashMap<Integer, ArrayList<Integer>>();
        this.grid = new int[h][w];
    }
    
    int decayHeat(double decay, int heat, int distance) {
        return (int) (heat * Math.exp(-1 * decay * distance));
    }
    public boolean placeSource(int x, int y, String type) {
        if(y < 0 || x < 0 || y >= this.grid.length || x >= this.grid[y].length){
            return false;
        }
        
        if(this.points.containsKey(x)) {
            ArrayList<Integer> col = this.points.get(x);
            if(col.contains(y)) {
                return false;
            }
        }else{
            this.points.put(x, new ArrayList<Integer>());
        }
        this.points.get(x).add(y);
        
        int heat = 0, range = 0;
        double decay = 0.0;

        switch (type) {
            case "l": {   
                heat = 1;
                range = 0;
                decay = 0.0;
            } break;
            case "c": {   
                heat = 4;
                range = 2;
                decay = 0.5;
            } break;
            case "f": {   
                heat = 10;
                range = 4;
                decay = 0.35;
            } break;
            case "i": {   
                heat = -2;
                range = 1;
                decay = 0.5;
            } break;
            case "r": {   
                heat = -8;
                range = 3;
                decay = 0.2;
            } break;
            case "g": {
                heat = -20;
                range = 5;
                decay = 0.15;
            } break;
        }
 
        for(int i = 0; i < grid.length; i++) {
            for(int o = 0; o < grid[i].length; o++) {
                int spot = Math.max(Math.abs(x - o), Math.abs(y - i));
                if(spot > range) {
                    continue;
                }
                grid[i][o] += decayHeat(decay, heat, spot);
            }
        }
        return true;
    }
    
    public String toString() {
        String r = "";
        for(int[] row : this.grid) {
            for(int i : row) {
                r += String.format("%3d ", i);
            }
            r += '\n';
        }
        return r;
    }
    public int[][] getHeats() {
        return this.grid;
    }
    public int getHeat(int x, int y) {
        return this.grid[y][x];
    }
    public int getNetHeat() {
        int h = 0;
        for(int[] row : this.grid) {
            for(int i : row) {
                h += i;
            }
        }
        return h;
    }
}
