import java.io.FileNotFoundException;

public class SparceIntMatrixTest {
    public static void main(String[] args) throws FileNotFoundException {
        SparceIntMatrix matrix1 = new SparceIntMatrix(1000, 1000, "C:\\Users\\alekh\\OneDrive\\Desktop\\school stuff\\compsci\\java\\CSCI 1933 - Project 3\\matrix2_noise.txt");
        SparceIntMatrix matrix2 = new SparceIntMatrix(1000, 1000, "C:\\Users\\alekh\\OneDrive\\Desktop\\school stuff\\compsci\\java\\CSCI 1933 - Project 3\\matrix2_data.txt");
        // SparceIntMatrix matrix3 = new SparceIntMatrix(1000, 1000, "C:\\Users\\alekh\\OneDrive\\Desktop\\school stuff\\compsci\\java\\CSCI 1933 - Project 3\\matrix1_data.txt");           
        // matrix3.setElement(500,500,10);
        matrix2.minus(matrix1);
        matrix2.setElement(500, 500, 255);
        System.out.println(matrix2.getEntry(500, 500).getData());
        matrix2.removeElement(500, 500);
        MatrixViewer.show(matrix2);
    }
}
