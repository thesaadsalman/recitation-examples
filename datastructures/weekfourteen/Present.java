package datastructures.weekfourteen;

import java.util.*;

  /**
  * Our Present class that implements Comparable
  * The Comparable interface allows this object to be compared to
  * other objects of the same class.
  * Using the Comparable interface means we must Override the compareTo
  * method
  * This leads to needing to Override the equals and hashCode methods.
  */
public class Present implements Comparable<Present> {
  /**
  * A small class for an example
  @param price Integer value of price of Present
  @param length Integer value of diagonal length of the Present
  @param xPixels Integer value of xPixels
  @param yPixels Integer value of yPixels
  */
  public int width, height, weight, index;

  public Present (int width, int height, int weight) {
    this.width = width;
    this.height = height;
    this.weight = weight;
    this.index = 0;
  }

  public void addIndex (int index) {
    this.index = index;
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.width * this.height * this.weight);
  }

  @Override
  public boolean equals (Object o) {
    Present other = (Present) o;
    if (other == null) {
      return false;
    }
    return (
      other.width == this.width &&
      other.height == this.height &&
      other.weight == this.weight);
  }

  /**
   * Compares this Present to another Present checking price first,
   * then pixel density, then aspect ratio
   * @param other
   * @return
   */
  @Override
  public int compareTo (Present other) {
    if (other.width * other.height == this.width * this.height) {
      return other.weight - this.weight;
    }
    return (other.width * other.height) - (this.width * this.height);
  }

  @Override
  public String toString() {
    return("[" + this.index + "]");
  }
}
