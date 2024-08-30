package tda;

public abstract class HeapElement {
    private int priority;

    public HeapElement (int priority) {
        this.priority = priority;
    }

    public int getPriority() {
        return this.priority;
    }

    public abstract HeapElement deepCopy();
}
