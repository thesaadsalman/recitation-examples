package datastructures.weekfourteen;

public class PriorityQueue {
  public static void main(String[] args) {
    Heap h = new Heap();
    h.add(new Monitor(1000, 40, 1920, 1080)); // 0
    h.add(new Monitor(900, 35, 2560, 1440)); // 1
    h.add(new Monitor(900, 35, 1920, 1080)); // 2
    h.add(new Monitor(100, 10, 100, 100)); // 3
    h.add(new Monitor(200, 20, 1400, 1400)); // 4
    System.out.println(h.toString()); // 3 4 2 0 1

    System.out.println(h.pop()); // 3
    System.out.println(h.toString()); // 4 1 2 0
  }
}
