// Alexander Holiman
// holim004
import java.awt.*;

public class Rectangle {
    // setting two variables to use in code 
    double x, y, width, height;
    Color color;
    // constructor for rectangle
    Rectangle(double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    // gets perimeter of rectangles
    double calculatePerimeter() {
        return 2 * (this.width + this.height);
    }
    // gets area of rectangles
    double calculateArea() {
        return this.width * this.height;
    }
    // sets color of rectangles
    void setColor(Color color) {
        this.color = color;
    }
    // gets color of rectangles
    Color getColor() {
        return this.color;
    }
    // sets position of rectangles
    void setPos(double x, double y) {
        this.x = x;
        this.y = y;
    }
    // sets width of rectangles
    void setWidth(double width) {
        this.width = width;
    }
    // sets height of rectangles
    void setHeight(double height) {
        this.height = height;
    }
    // gets x position of rectangles
    double getXPos() {
        return this.x;
    }
    // gets y position of rectangles
    double getYPos() {
        return this.y;
    }
    // gets width of rectangles
    double getWidth() {
        return this.width;
    }
    // gets height of rectangles
    double getHeight() {
        return this.height;
    }

}