public static int productDigits(int n) {
    if(n<10){
        return n;
    }
    return (n % 10) * productDigits(n/10);
}

public static double[][] make2DArray(int row, int column) {
    double[][] grid = new grid[column][row];
    for(int i = 0; i < column; i++){
        for(int o = 0; o < row; o++){
            grid[i][o] = i + o;
        }
        
    }
    return grid;

}

public static int leastCommonMultiple(int a, int b) {
    for(int i = Math.max(a, b); ; i++) {
        if(i % a + i % b == 0) {
            return i;
        }
    }
}

public class Polynomial {
    double a, b, c;
    Polynomial(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public double getA() {
        return this.a;
    }
    public double getB() {
        return this.b;
    }
    public double getC() {
        return this.c;
    }
    public void add(Polynomial p) {
        this.a += p.a;
        this.b += p.b;
        this.c += p.c;
    }
    public double evaluate(double x) {
        return this.a * (x * x) + this.b * x + this.c;
    }
}