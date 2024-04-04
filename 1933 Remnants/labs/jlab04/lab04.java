public class lab04 {
    public static void main(String[] args) {
        HeatGrid thing = new HeatGrid(12, 12);
        thing.placeSource(5, 5, "c");
        System.out.println(thing);
    }
    
}
