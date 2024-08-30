package tda;

import java.util.List;

public interface Heap <T> {

    void add (T element);

    void add (List<T> elementList);

    T poll ();

    T peek ();

    Boolean isEmpty();

    int size();

    void printHeap();
}