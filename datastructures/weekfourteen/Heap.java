package datastructures.weekfourteen;

import java.util.*;

public class Heap {

  /**
   * Motivating example: We are looking for a new monitor to buy. The
   * four features we are interested in is its price, diagonal length,
   * xPixels, and yPixels of the monitor.
   */

  /**
   * Basic Binary Heap class
   * @param heap Array where our values are stored
   */

  public List<Monitor> heap;

  /**
  * Constructor for a new Heap
  * @param heap a List of monitors, not necessarily a heap
  */
  public Heap () {
    this.heap = new ArrayList<>();
  }

  /**
  * Adds a new monitor to the heap, taking care of reheapification
  * @param monitor The monitor we are adding to our heap
  */
  public void add(Monitor monitor) {
    // Append a monitor to the end of the list
    monitor.addIndex(this.heap.size());
    this.heap.add(monitor);

    // New monitor has been added, need to bubble up the monitor
    this.bubbleUp(this.heap.size() - 1);
  }

  public Monitor pop() {
    Monitor root = this.heap.get(0);
    this.heap.set(0, this.heap.get(this.heap.size() - 1));
    this.heap.remove(this.heap.size() - 1);

    this.bubbleDown(0);

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

    // Get the parent and current Monitors
    Monitor parentMonitor = this.heap.get(parentIndex);
    Monitor childMonitor = this.heap.get(index);

    // Compare the parent and current Monitors and if the
    // priority of the child is higher...
    if (childMonitor.compareTo(parentMonitor) > 0) {
      // ...swap the parent and the current!
      this.heap.set(index, parentMonitor);
      this.heap.set(parentIndex, childMonitor);

      // Reheapify on the *parentIndex* since we just swapped our
      // current Monitor to the parentIndex
      this.bubbleUp(parentIndex);
    }
  }

  public void bubbleDown(int index) {
    // Base Case: Our node ahs made it to the end of the heap, nowhere
    // to bubble down
    if (index == this.heap.size() - 1) {
      return;
    }

    // Get the indices of possible children
    int leftChildIndex = this.getChildIndex(index, 'L');
    int rightChildIndex = this.getChildIndex(index, 'R');

    // Get the Children Monitors, or null if their index is invalid
    Monitor parentMonitor = this.heap.get(index);
    Monitor leftChild = (leftChildIndex < this.heap.size()) ? this.heap.get(leftChildIndex) : null;
    Monitor rightChild = (rightChildIndex < this.heap.size()) ? this.heap.get(rightChildIndex) : null;

    // If both children are null, we are done
    if (leftChild == null && rightChild == null) {
      return;
    }
    // If left child is null, then swap with the right node
    if (leftChild == null) {
      if (rightChild.compareTo(parentMonitor) > 0) {
        this.heap.set(rightChildIndex, parentMonitor);
        this.heap.set(index, rightChild);
      }
      return;
    }
    // If right child is null, then swap with the left node
    if (rightChild == null) {
      if (leftChild.compareTo(parentMonitor) > 0) {
        this.heap.set(leftChildIndex, parentMonitor);
        this.heap.set(index, leftChild);
      }
      return;
    }
    // Otherwise, compare and swap with greater child
    if (leftChild.compareTo(rightChild) > 0) {
      if (leftChild.compareTo(parentMonitor) > 0) {
        this.heap.set(leftChildIndex, parentMonitor);
        this.heap.set(index, leftChild);
        this.bubbleDown(leftChildIndex);
      }
    } else {
      if (rightChild.compareTo(parentMonitor) > 0) {
        this.heap.set(rightChildIndex, parentMonitor);
        this.heap.set(index, rightChild);
        this.bubbleDown(rightChildIndex);
      }
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
