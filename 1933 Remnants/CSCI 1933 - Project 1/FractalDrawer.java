// Alexander Holiman
// holim004
import java.awt.Color;
import java.util.Scanner;
// FractalDrawer class draws a fractal of a shape indicated by user input
public class FractalDrawer {
    // draws a triangle fractal and returns the total area of the fractal
    public static double drawTriangleFractal(double width, double height, double x, double y, Color c, Canvas can, int level){
        if(level <= 0) {
            return 0.0;
        }
        Triangle tr = new Triangle(x,y,width,height);
        tr.setColor(new Color((int)(x % 255),(int)(y % 255),(int)(255 - ((x + y)/2)%255)));
        can.drawShape(tr);
        double sum = tr.calculateArea();
        sum += drawTriangleFractal(width / 2, height / 2, x, y + width, c, can, level - 1);
        sum += drawTriangleFractal(width / 2, height / 2, x + width, y, c, can, level - 1);
        return sum;
    }
    // draws a circle fractal and returns the total area of the fractal
    public static double drawCircleFractal(double radius, double x, double y, Color c, Canvas can, int level) {
        if(level <= 0) {
            return 0.0;
        }
        Circle cr = new Circle(x,y,radius);
        cr.setColor(new Color((int)(x % 255),(int)(y % 255),(int)(255 - ((x + y)/2)%255)));
        can.drawShape(cr);
        double sum = cr.calculateArea();
        sum += drawCircleFractal(radius / 2, x + radius * 2, y, c, can, level-1);
        sum += drawCircleFractal(radius / 2, x, y + radius * 2, c, can, level-1);
        return sum;
    }
    // draws a rectangle fractal and returns the total area of the fractal
    public static double drawRectangleFractal(double width, double height, double x, double y, Color c, Canvas can, int level) {
        if(level <= 0) {
            return 0.0;
        }
        Rectangle rc = new Rectangle(x,y,width,height);
        rc.setColor(new Color((int)(x % 255),(int)(y % 255),(int)(255 - ((x + y)/2)%255)));
        can.drawShape(rc);
        double sum = rc.calculateArea();
        sum += drawRectangleFractal(width / 2, height / 2, x, y + width, c, can, level - 1);
        sum += drawRectangleFractal(width / 2, height / 2, x + width, y, c, can, level - 1);
        return sum;
    }
    // checks what user inputs and returns the area of the fractal
    public static double drawFractal(String type) {
        Canvas c = new Canvas();
        if(type.equals("circle")) {
            return drawCircleFractal(200, 200, 200, new Color(255, 200, 200), c, 10);
        }
        if(type.equals("triangle")) {
            return drawTriangleFractal(200, 200, 200, 200, new Color(200, 255, 200), c, 10);
            
        }
        if(type.equals("rectangle")) {
            return drawRectangleFractal(200, 200, 200, 200, new Color(200, 200, 255), c, 10);
        }
        return 0.0;
    } 
    // main method, asks user for input then draws and returns area of the requested fractal
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter shape type: ");
        String choice = scanner.nextLine();
        double area = drawFractal(choice);
        System.out.println("Fractal area: " + area);
        scanner.close();
        
        
    }
}
