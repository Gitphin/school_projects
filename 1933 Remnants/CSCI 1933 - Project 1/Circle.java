// Alexander Holiman
// holim004
import java.awt.*;
import java.lang.Math;

public class Circle {
    // creating two variables for use later
    double x, y, radius;
    Color color;
    // constructor for circle
    Circle(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }
    // calculates perimeter of circles
    double calculatePerimeter() {
        return 2 * Math.PI * this.radius;
    }
    // calculates area of circles
    double calculateArea() {
        return Math.PI * this.radius * this.radius;
    }
    // sets the color of circles
    void setColor(Color color) {
        this.color = color;
    }
    // gets the color of circles
    Color getColor() {
        return this.color;
    }
    // sets the position of circles
    void setPos(double x, double y) {
        this.x = x;
        this.y = y;
    }
    // sets the radius of circles
    void setRadius(double radius) {
        this.radius = radius;
    }
    // gets x position of circles
    double getXPos() {
        return this.x;
    }
    // gets y position of circles
    double getYPos() {
        return this.y;
    }
    // gets radius of circles
    double getRadius() {
        return this.radius;
    }

}