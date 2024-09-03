package tda.huffman;

import tda.heap.Heap;
import tda.heap.HeapElement;
import tda.heap.HeapMinImpl;

public class Huffman <T extends HeapElement> { //NO ANDA TODAVIA

    private HuffmanNode<T> root;

    public Huffman (Heap<T> heap) {
        buildTree(heap);
    }

    public void buildTree (Heap<T> heap) {
        if (heap.isEmpty()) {
            root = null;
            return;
        }
        Heap<HuffmanNode<T>> auxHeap = new HeapMinImpl<>();
        HuffmanNode<T> leftNode = null;
        HuffmanNode<T> rightNode = null;
        while (!heap.isEmpty() && !auxHeap.isEmpty()) { //TODO -> revisar como hacer la ponderacion entre heap inicial y el heapAuxiliar
            T leftNodeValue = heap.poll();
            T rightNodeValue = heap.poll();
            leftNode = new HuffmanNode<>(leftNodeValue.getPriority(), leftNodeValue, null, null);
            rightNode = new HuffmanNode<>(rightNodeValue.getPriority(), rightNodeValue, null, null);
            HuffmanNode<T> currentNode = new HuffmanNode<T>();
        }
        this.root = new HuffmanNode<T>(heap.peek().getPriority() ,heap.peek(), leftNode, rightNode);
        heap.poll();
    }
}