package tda;

public interface Heap <T> {

    void add (T element);

    T poll ();

    T peek ();
}