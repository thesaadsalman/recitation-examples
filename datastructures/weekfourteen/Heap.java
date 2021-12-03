package datastructures.weekfourteen;

import java.util.*;

public class Heap {

  /**
   * Motivating example: We are looking for a new Present to buy. The
   * four features we are interested in is its price, diagonal length,
   * xPixels, and yPixels of the Present.
   */

  /**
   * Basic Binary Heap class
   * @param heap Array where our values are stored
   */
  public List<Present> heap;

  /**
  * Constructor for a new Heap
  */
  public Heap () {
    this.heap = new ArrayList<>();
  }

  /**
  * Adds a new Present to the heap, taking care of reheapification
  * @param Present The Present we are adding to our heap
  */
  public void add(Present Present) {
    // Append a Present to the end of the list
    Present.addIndex(this.heap.size());
    this.heap.add(Present);

    // New Present has been added, need to bubble up the Present
    this.bubbleUp(this.heap.size() - 1);
  }

  /**
   * Retrieves and removes the root node from the heap, then reheapifies to get the next top node
   * @return The root (highest priority) node
   */
  public Present pop() {
    // Get the top node
    Present root = this.heap.get(0);

    // Swap the root node and the "last" node in the heap
    this.heap.set(0, this.heap.get(this.heap.size() - 1));

    // Removes the last node in the heap
    this.heap.remove(this.heap.size() - 1);

    // Bubble the new "root" down to its correct position in the heap, thus "reheapifying"
    this.bubbleDown(0);

    // Returns our highest priority node
    return root;
  }

  /**
  * Recursively bubbles up our last node to its appropriate index in our heap
  * @param index index of the node we are bubbling up
  */
  public void bubbleUp(int index) {
    // Base Case: Our node has made it to the root, nowhere to bubble up
    if (index == 0) {
      return;
    }

    // Get the parent index of this current child
    int parentIndex = this.getParentIndex(index);

    // Get the parent and current Presents
    Present parentPresent = this.heap.get(parentIndex);
    Present childPresent = this.heap.get(index);

    // Compare the parent and current Presents and if the
    // priority of the child is higher...
    if (childPresent.compareTo(parentPresent) < 0) {
      heap.set(index, parentPresent);
      heap.set(parentIndex, childPresent);
      // ...swap the parent and the current!
      this.bubbleUp(parentIndex);
    }
  }

  /**
   * Bubbles a node at a given index down to its correct position in the heap
   * @param index The index of the node we are bubbling down
   */
  public void bubbleDown(int index) {
    // Base Case: Our node ahs made it to the end of the heap, nowhere
    // to bubble down
    if (index == this.heap.size() - 1) {
      return;
    }

    // Get the indices of where potential children could be
    int leftChildIndex = this.getChildIndex(index, 'L');
    int rightChildIndex = this.getChildIndex(index, 'R');

    // Get the Children Presents, or null if their index is invalid
    Present parentPresent = this.heap.get(index);
    Present leftChild = (leftChildIndex < this.heap.size()) ? this.heap.get(leftChildIndex) : null;
    Present rightChild = (rightChildIndex < this.heap.size()) ? this.heap.get(rightChildIndex) : null;

    // If both children are null, we are done
    if (leftChild == null && rightChild == null) {
      return;
    }
    // If left child is null, then swap with the right node
    if (leftChild == null) {
      this.reheapifyDown(parentPresent, rightChild, index, rightChildIndex);
      return;
    }
    // If right child is null, then swap with the left node
    if (rightChild == null) {
      this.reheapifyDown(parentPresent, leftChild, index, leftChildIndex);
      return;
    }
    // Otherwise, compare and swap with greater child
    if (leftChild.compareTo(rightChild) < 0) {
      this.reheapifyDown(parentPresent, leftChild, index, leftChildIndex);
    } else {
      this.reheapifyDown(parentPresent, rightChild, index, rightChildIndex);
    }
  }

  private void reheapifyDown(Present parent, Present child, int parentIndex, int childIndex) {
    if (child.compareTo(parent) < 0) {
      this.heap.set(childIndex, parent);
      this.heap.set(parentIndex, child);
      this.bubbleDown(childIndex);
    }
  }

  /**
  * Returns the parent index of a given child using Integer Division
  * @param childIndex The index of a child
  * @return The index of a child's parents index
  */
  public int getParentIndex(int childIndex) {
    return (childIndex - 1) / 2;
  }

  private int getChildIndex (int parentIndex, char child) {
    int result = (parentIndex * 2) + 1; // Index of Left child
    if (child == 'R') { result++; }
    return result;
  }

  @Override
  public String toString() {
    return this.heap.toString();
  }
}
