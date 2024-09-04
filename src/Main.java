import tda.heap.Heap;
import tda.heap.HeapMinImpl;
import tda.huffman.Huffman;
import test_assets.HeapTestingElement;

import java.util.Map;


public class Main {
    public static void main(String[] args) {

        Heap<HeapTestingElement> heap = new HeapMinImpl<>();

        heap.add(new HeapTestingElement(1));
        heap.add(new HeapTestingElement(8));
        heap.add(new HeapTestingElement(456));
        heap.add(new HeapTestingElement(12));
        heap.add(new HeapTestingElement(67));
        heap.add(new HeapTestingElement(85));
        heap.add(new HeapTestingElement(4654));

        Huffman<HeapTestingElement> huffman = new Huffman<>(heap);
        Map<HeapTestingElement, Integer> hufMap =  huffman.getCodes();
        System.out.println(hufMap);
    }
}