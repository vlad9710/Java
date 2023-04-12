package ru.stqa.pft.sandbox;

public class MyFirstProgram {

  public static void main(String[] args) {
    hello("user");

    Square s = new Square(5);
    System.out.println("Площадь квадрата со стороной " + s.l + " = " + s.area());

    Rectangle r = new Rectangle(4, 6);
    System.out.println("Площадь прямоугольника со сторонами  " + r.a + " и " + r.a + " = " + r.area());

    Point p = new Point (3,5,6,2);
    System.out.println("Расстояние между точками = " + p.distance());
  }

  public static void hello(String somebody) {
    System.out.println("Hello, " + somebody + "!");
  }

}