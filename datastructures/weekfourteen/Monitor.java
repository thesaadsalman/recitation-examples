package datastructures.weekfourteen;

import java.util.*;

  /**
  * Our Monitor class that implements Comparable
  * The Comparable interface allows this object to be compared to
  * other objects of the same class.
  * Using the Comparable interface means we must Override the compareTo
  * method
  * This leads to needing to Override the equals and hashCode methods.
  */
public class Monitor implements Comparable<Monitor> {
  /**
  * A small class for an example
  @param price Integer value of price of Monitor
  @param length Integer value of diagonal length of the monitor
  @param xPixels Integer value of xPixels
  @param yPixels Integer value of yPixels
  */
  public int price, length, xPixels, yPixels, index;

  public Monitor (int price, int length, int xPixels, int yPixels) {
    this.price = price;
    this.length = length;
    this.xPixels = xPixels;
    this.yPixels = yPixels;
    this.index = 0;
  }

  public void addIndex (int index) {
    this.index = index;
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.price * this.length * this.xPixels * this.yPixels);
  }

  @Override
  public boolean equals (Object o) {
    Monitor other = (Monitor) o;
    if (other == null) {
      return false;
    }
    return (
      other.price == this.price &&
      other.length == this.length &&
      other.xPixels == this.xPixels &&
      other.yPixels == this.yPixels
    );
  }

  /**
   * Compares this Monitor to another monitor checking price first,
   * then pixel density, then aspect ratio
   * @param other
   * @return
   */
  @Override
  public int compareTo (Monitor other) {
    if (other.price == this.price) {
      if (other.length == this.length) {
        return (this.xPixels * this.yPixels) - (other.xPixels * other.yPixels);
      }
      return other.length - this.length;
    }
    return other.price - this.price;
  }

  @Override
  public String toString() {
    return("[" + this.index + "]");
    // return ("[" + this.price + ", " + this.length + "\", " + "(" + this.xPixels + " x " + this.yPixels + ")]");
  }
}
