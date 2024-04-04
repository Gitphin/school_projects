import java.lang.Math;

class beans {
    public static int leastCommonMultiple(int a, int b) {
        int i = 2 * (Math.max(a, b) / Math.min(a, b)) - 1;
        while(true) {
            int t = a * (1 - i % 2) + b * (i / 2);
            if(t % a + t % b == 0) {
                return t;
            }
            i++;
        }
    }
    public static void main(String[] args) {
        System.out.println(leastCommonMultiple(5, 7));
    }
}