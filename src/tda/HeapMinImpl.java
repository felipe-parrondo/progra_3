package tda;

import java.util.ArrayList;
import java.util.List;

public class HeapMinImpl <T extends HeapElement> implements Heap<T> {

    private List<T> heapList;

    public HeapMinImpl () {
        this.heapList = new ArrayList<>();
    }

    public HeapMinImpl (List<T> startingValues) {
        this.heapList = new ArrayList<>();
        startingValues.forEach(this::add);
    }

    @Override
    public void add (T element) {
        heapList.add(element);
        heapifyUp();
    }

    @Override
    public void add(List<T> elementList) {
        elementList.forEach(this::add);
    }

    @Override
    public T peek () {
        if (heapList.isEmpty()) return null;
        return heapList.get(0);
    }

    @Override
    public T poll () {
        if (isEmpty())
            return null;
        T returnItem = heapList.get(0);
        heapList.set(0, heapList.get(lastIndex()));
        heapList.remove(lastIndex());
        if (!isEmpty())
            heapifyDown();
        return returnItem;
    }

    @Override
    public Boolean isEmpty() {
        return heapList.size() == 0;
    }

    @Override
    public int size() {
        return heapList.size();
    }

    public int lastIndex() {
        return heapList.size() - 1;
    }

    private void heapifyDown () {
        int index = 0;
        T currentNode = heapList.get(index);
        while (hasLeftChild(index)) {
            int smallerChildIndex = ( hasRightChild(index) && leftChild(index).getPriority() > rightChild(index).getPriority() )
                    ? getRightChildIndex(index)
                    : getLeftChildIndex(index);
            if (currentNode.getPriority() > heapList.get(smallerChildIndex).getPriority())
                swap(index, smallerChildIndex);
            else
                break;
            index = smallerChildIndex;
        }
    }

    private void heapifyUp () {
        int index = lastIndex();
        if (!hasParent(index))
            return;
        int parentIndex = getParentIndex(index);
        while (hasParent(index) && heapList.get(index).getPriority() <= heapList.get(parentIndex).getPriority()) {
            if (heapList.get(index).getPriority() == heapList.get(parentIndex).getPriority())
                break;
            swap(index, parentIndex);
            index = parentIndex;
            parentIndex = getParentIndex(index);
        }
    }

    //HEAP HELPER METHODS
    private void swap (int index1, int index2) {
        T temp = heapList.get(index1);
        heapList.set(index1, heapList.get(index2));
        heapList.set(index2, temp);
    }

    private T parent (int index) {
        return this.heapList.get(getParentIndex(index));
    }

    private T leftChild (int index) {
        return this.heapList.get(getLeftChildIndex(index));
    }

    private T rightChild (int index) {
        return this.heapList.get(getRightChildIndex(index));
    }

    private boolean hasParent (int index) {
        return getParentIndex(index) >= 0;
    }

    private boolean hasLeftChild (int index) {
        return getLeftChildIndex(index) <= lastIndex();
    }

    private boolean hasRightChild (int index) {
        return getRightChildIndex(index) <= lastIndex();
    }

    private int getParentIndex (int index) {
        return (index - 1) / 2;
    }

    private int getLeftChildIndex (int index) {
        return (index * 2) + 1;
    }

    private int getRightChildIndex (int index) {
        return (index * 2) + 2;
    }

    //TESTING METHODS
    @Override
    public void printHeap () {
        System.out.println(heapList);
    }
}

