package datastructures.weekfourteen;

public class PriorityQueue {
  public static void main(String[] args) {
    Heap h = new Heap();
    h.add(new Present(4, 10, 12)); // 0
    h.add(new Present(20, 12, 30)); // 1
    h.add(new Present(10, 10, 20)); // 2
    h.add(new Present(12, 20, 32)); // 3
    h.add(new Present(5, 5, 14)); // 4
    System.out.println(h.toString()); // 3 1 2 0 4

    System.out.println(h.pop()); // 3
    System.out.println(h.toString()); // 1 0 2 4
  }
}
