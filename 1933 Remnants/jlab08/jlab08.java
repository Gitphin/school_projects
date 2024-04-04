import java.io.File;

public class jlab08 {
    public static void main(String[] args) {
        AList<Double> somelist = new AList(0);
        somelist.add(4.2);
        somelist.add(5.2);
        somelist.add(3.2);
        somelist.add(2.2);
        somelist.add(78.2);
        somelist.add(7.2);
        somelist.add(4.2);
        System.out.println(somelist);
        somelist.sort(true);
        System.out.println(somelist);
        System.out.println(somelist.slice(1, 7, 3));
        
        System.out.println(AList.fileToAList(new File("C:/Users/Alek/Downloads/input.txt")));
    }
}