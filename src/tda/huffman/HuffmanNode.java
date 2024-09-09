package tda.huffman;

import tda.heap.HeapElement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class HuffmanNode <T extends HeapElement> implements HeapElement {

    private int priority;
    private T nodeValue;
    private HuffmanNode<T> leftNode;
    private HuffmanNode<T> rightNode;

    public HuffmanNode() {
        //No-args constructor
    }

    public HuffmanNode (int priority, T nodeValue, HuffmanNode<T> leftNode, HuffmanNode<T> rightNode) {
        this.priority = priority;
        this.nodeValue = nodeValue;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

    public int getNodeValuePriority() {
        return priority;
    }

    public boolean isLeaf() {
        return Objects.nonNull(this.nodeValue);
    }

    public T getNodeValue() {
        return nodeValue;
    }

    public HuffmanNode<T> getLeftNode() {
        return leftNode;
    }

    public HuffmanNode<T> getRightNode() {
        return rightNode;
    }

    public void setNodeValue(T nodeValue) {
        this.nodeValue = nodeValue;
    }

    public void setLeftNode(HuffmanNode<T> leftNode) {
        this.leftNode = leftNode;
    }

    public void setRightNode(HuffmanNode<T> rightNode) {
        this.rightNode = rightNode;
    }

    @Override
    public int getPriority() {
        return this.priority;
    }

    @Override
    public String toString() {
        StringBuilder buffer = new StringBuilder(50);
        print(buffer, "", "");
        return buffer.toString();
    }

    private void print(StringBuilder buffer, String prefix, String childrenPrefix) {
        buffer.append(prefix);
        buffer.append(this.getNodeValuePriority());
        buffer.append('\n');
        List<HuffmanNode<T>> children = new ArrayList<>();
        children.add(rightNode);
        children.add(leftNode);
        for (Iterator<HuffmanNode<T>> it = children.iterator(); it.hasNext();) {
            HuffmanNode<T> next = it.next();
            if (Objects.isNull(next))
                continue;
            if (it.hasNext()) {
                next.print(buffer, childrenPrefix + "├── ", childrenPrefix + "│   ");
            } else {
                next.print(buffer, childrenPrefix + "└── ", childrenPrefix + "    ");
            }
        }
    }
}