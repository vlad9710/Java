package ru.stqa.pft.sandbox;

public class MyFirstProgram {

  public static void main(String[] args) {
    hello("user");

    Square s = new Square(5);
    System.out.println("Площадь квадрата со стороной " + s.l + " = " + s.area());

    Rectangle r = new Rectangle(4, 6);
    System.out.println("Площадь прямоугольника со сторонами " + r.a + " и " + r.b + " = " + r.area());

    Point p = new Point(5, 10, 6, 8);
    System.out.println("Расстояние между точками = " + p.area());
  }

  public static void hello(String somebody) {
    System.out.println("Hello," + somebody + "!");
  }



}