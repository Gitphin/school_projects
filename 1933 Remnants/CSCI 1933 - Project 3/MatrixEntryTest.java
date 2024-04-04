import java.io.FileNotFoundException;
import java.io.IOException;

public class MatrixEntryTest {
    public static void main(String[] args) throws IOException {
        MatrixEntry a = new MatrixEntry(400, 200, 3);
        MatrixEntry b = new MatrixEntry(500, 400, 10);
        MatrixEntry c = new MatrixEntry(500, 600, 12);
        
        a.setColumn(150);
        a.setRow(200);
        a.setData(5);
        a.setNextRow(b);
        a.setNextCol(c);
        b.setData(9);
        c.setData(-1);
        System.out.println(a);
    }
}
