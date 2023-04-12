package ru.stqa.pft.sandbox;

public class Point {

  public int x1;
  public int y1;
  public int x2;
  public int y2;


  public Point (int x1, int y1, int x2, int y2) {
    this.x1 = x1;
    this.y1 = y1;
    this.x2 = x2;
    this.y2 = y2;
  }

  public double distance () {
    return Math.sqrt((Math.pow(this.x2 - this.x1, 2) + (Math.pow(this.y2 - this.y1, 2))));
  }

}
