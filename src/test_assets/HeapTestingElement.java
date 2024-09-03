package test_assets;

import tda.heap.HeapElement;

public class HeapTestingElement implements HeapElement {

    private int priority;

    public HeapTestingElement(int priority) {
        this.priority = priority;
    }

    @Override
    public int getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        return Integer.toString(this.priority);
    }
}
