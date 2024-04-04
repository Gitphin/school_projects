// Alexander Holiman
// holim004
import java.awt.*;
import java.lang.Math;

public class Triangle {
    // creates two variables for setting up process
    double x, y, width, height;
    Color color;
    // constructor for triangle
    Triangle(double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    // gets perimeter of triangles
    double calculatePerimeter() {
        return 2 * Math.sqrt(Math.pow(this.height, 2) + Math.pow(0.5 * this.width, 2)) + this.width;
    }
    // gets area of triangles
    double calculateArea() {
        return 0.5 * this.width * this.height;
    }
    // sets color of triangles
    void setColor(Color color) {
        this.color = color;
    }
    // gets color of triangles
    Color getColor() {
        return this.color;
    }
    // sets position of triangles
    void setPos(double x, double y) {
        this.x = x;
        this.y = y;
    }
    // sets width of triangles
    void setWidth(double width) {
        this.width = width;
    }
    // sets height of triangles
    void setHeight(double height) {
        this.height = height;
    }
    // gets x position of triangles
    double getXPos() {
        return this.x;
    }
    // gets y position of triangles
    double getYPos() {
        return this.y;
    }
    // gets the width of triangles
    double getWidth() {
        return this.width;
    }
    // gets the height of triangles
    double getHeight() {
        return this.height;
    }

}