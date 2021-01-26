package java_practice.practice;

abstract class Shape {
    abstract void draw();
}

interface CalcArea {
    double getArea();
}

class Rectangle extends Shape implements CalcArea {
    double width;
    double height;

    Rectangle() {
        this.width = this.height = 1;
    }

    void draw() {
        System.out.println("■");
    }

    public double getArea() {
        return this.width = this.height;
    }
}

class Circle extends Shape implements CalcArea {
    double r;

    Circle() {
        this.r = 1;
    }

    void draw() {
        System.out.println("■");
    }

    public double getArea() {
        return this.r * this.r * Math.PI;
    }
}

class Polyline extends Shape {
    void draw() {
        System.out.println("w");
    }
}

public class Practice3 {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Rectangle();
        shapes[1] = new Circle();
        shapes[2] = new Polyline();

        for (int i = 0; i < shapes.length; i++) {
            shapes[i].draw();
            if (shapes[i] instanceof CalcArea) {
                CalcArea a = (CalcArea) shapes[i];
                System.out.println(a.getArea());
            } else {
                System.out.println("面積求められません");
            }
        }
    }
}