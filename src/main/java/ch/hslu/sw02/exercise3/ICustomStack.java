package ch.hslu.sw02.exercise3;

public interface ICustomStack<T> {
    void push(T element);
    T pop();
    T peek();
    boolean isEmpty();
    boolean isFull();
    int size();
    int capacity();
}
