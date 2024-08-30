package tda;

import java.util.ArrayList;
import java.util.List;

public class HeapMinImpl <T extends HeapElement> implements Heap<T> {

    private List<T> heapList;
    private int lastIndex;

    public HeapMinImpl () {
        this.heapList = new ArrayList<>();
        this.lastIndex = 0;
    }

    public HeapMinImpl (List<T> startingValues) {
        this.heapList = new ArrayList<>();
        this.lastIndex = 0;
        startingValues.forEach(value -> add(value));
    }

    @Override
    public void add (T element) {
        heapList.add(element);
        lastIndex++;
        heapifyUp();
    }

    @Override
    public T peek () {
        if (heapList.isEmpty()) return null;
        return heapList.get(0);
    }

    @Override
    public T poll () {
        if (heapList.isEmpty()) return null;
        T returnItem = heapList.get(0);
        heapList.set(0, heapList.get(lastIndex));
        lastIndex--;
        heapifyDown();
        return returnItem;
    }

    private void heapifyDown () {
        int index = 0;
        T currentNode = heapList.get(index);
        while (hasLeftChild(index)) {
            int smallerChild = ( hasRightChild(index) && leftChild(index).getPriority() > rightChild(index).getPriority() )
                    ? getRightChild(index)
                    : getLeftChild(index);
            if (currentNode.getPriority() > heapList.get(smallerChild).getPriority()) swap(index, getParent(index));
            else break;
            index = smallerChild;
        }
    }

    private void heapifyUp () {
        int index = lastIndex;
        T currentNode = heapList.get(index);
        T parentNode = parent(index);
        while (hasParent(index) && currentNode.getPriority() < parentNode.getPriority()) {
            index = getParent(index);
            currentNode = parentNode;
            parentNode = parent(getParent(index));
            swap(index, getParent(index));
        }
    }

    //HEAP HELPER METHODS
    private void swap (int index1, int index2) {
        T temp = heapList.get(index1);
        heapList.set(index1, heapList.get(index2));
        heapList.set(index2, temp);
    }

    private T parent (int index) {
        return this.heapList.get(getParent(index));
    }

    private T leftChild (int index) {
        return this.heapList.get(getLeftChild(index));
    }

    private T rightChild (int index) {
        return this.heapList.get(getRightChild(index));
    }

    private boolean hasParent (int index) {
        return getParent(index) >= 0;
    }

    private boolean hasLeftChild (int index) {
        return getLeftChild(index) <= lastIndex;
    }

    private boolean hasRightChild (int index) {
        return getRightChild(index) <= lastIndex;
    }

    private int getParent (int index) {
        return (index - 1) / 2;
    }

    private int getLeftChild (int index) {
        return (index * 2) + 1;
    }

    private int getRightChild (int index) {
        return (index * 2) + 2;
    }
}