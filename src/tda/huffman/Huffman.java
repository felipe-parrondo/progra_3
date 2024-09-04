package tda.huffman;

import tda.heap.Heap;
import tda.heap.HeapElement;
import tda.heap.HeapMinImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Huffman <T extends HeapElement> { //NO ANDA TODAVIA

    private HuffmanNode<T> root;
    private Heap<T> heap;
    private Heap<HuffmanNode<T>> auxHeap;

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
        do {
            this.heap = heap;
            this.auxHeap = auxHeap;
            leftNode = evaluateElements(heap, auxHeap);
            rightNode = evaluateElements(heap, auxHeap);
            auxHeap.add(new HuffmanNode<>(leftNode.getNodeValuePriority() + rightNode.getNodeValuePriority(), null, leftNode, rightNode));
            if (auxHeap.size() == 1 && heap.isEmpty()) {
                root = auxHeap.poll();
            }
        } while (!auxHeap.isEmpty());
        System.out.println(root);
    }

    public Map<T, Integer> getCodes () {
        Map<T, Integer> returnMap = new HashMap<>();
        getCodesImpl(returnMap, root, "");
        return returnMap;
    }

    private HuffmanNode<T> evaluateElements (Heap<T> heap, Heap<HuffmanNode<T>> auxHeap) {
        //los nodos que salen de heap tienen los 2 hijos en null porque nunca van a tener nodos hijo con el fin de respetar la regla del prefijo
        //a su vez, los nodos que salen de auxHeap tienen si o si los 2 hijos seteados
        if (heap.isEmpty())
            return auxHeap.poll();
        if (auxHeap.isEmpty() || heap.peek().getPriority() < auxHeap.peek().getPriority()) {
            T element = heap.poll();
            return new HuffmanNode<>(element.getPriority(), element, null, null);
        }
        return auxHeap.poll();
    }

    private void getCodesImpl (Map<T, Integer> map, HuffmanNode<T> currentNode, String code) {
        if (currentNode.isLeaf()) {
            map.put(currentNode.getNodeValue(), Integer.valueOf(code));
            return;
        }
        getCodesImpl(map, currentNode.getLeftNode(), code.concat("0"));
        getCodesImpl(map, currentNode.getRightNode(), code.concat("1"));
    }

    @Override
    public String toString() {
        return heap.toString() + auxHeap.toString();
    }
}