import tda.Heap;
import tda.HeapMinImpl;
import test_assets.HeapTestingElement;


public class Main {
    public static void main(String[] args) {

        Heap<HeapTestingElement> heap = new HeapMinImpl<>();

        heap.add(new HeapTestingElement(1));
        heap.add(new HeapTestingElement(1));
        heap.add(new HeapTestingElement(1));
        heap.add(new HeapTestingElement(1));
        heap.add(new HeapTestingElement(1));
        heap.add(new HeapTestingElement(8));
        heap.add(new HeapTestingElement(456));
        heap.add(new HeapTestingElement(12));
        heap.add(new HeapTestingElement(67));
        heap.add(new HeapTestingElement(85));
        heap.add(new HeapTestingElement(4654));
        heap.add(new HeapTestingElement(11));
        heap.add(new HeapTestingElement(1));
        heap.add(new HeapTestingElement(1));
        heap.add(new HeapTestingElement(1));
        heap.add(new HeapTestingElement(1));
        heap.add(new HeapTestingElement(1));
        heap.add(new HeapTestingElement(1));
        heap.add(new HeapTestingElement(1));
        heap.add(new HeapTestingElement(1));
        heap.add(new HeapTestingElement(1));

        while (!heap.isEmpty()) {
            heap.poll();
        }
    }
}