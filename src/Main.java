import tda.heap.Heap;
import tda.heap.HeapMinImpl;
import tda.huffman.Huffman;
import test_assets.HeapTestingElement;

import java.util.Map;


public class Main {
    public static void main(String[] args) {

        Heap<HeapTestingElement> heap = new HeapMinImpl<>();

        heap.add(new HeapTestingElement(1));
        heap.add(new HeapTestingElement(2));
        heap.add(new HeapTestingElement(3));
        heap.add(new HeapTestingElement(5));
        heap.add(new HeapTestingElement(7));
        heap.add(new HeapTestingElement(8));

        Huffman<HeapTestingElement> huffman = new Huffman<>(heap);
        Map<HeapTestingElement, String> hufMap =  huffman.getCodes();
        System.out.println(huffman);
        System.out.println(hufMap);
    }
}