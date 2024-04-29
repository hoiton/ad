package ch.hslu.sw10;

public interface IIntegerHeap {
    void insert(int element);
    int getMax();
    int popMax();
    int size();
    boolean isEmpty();
}
