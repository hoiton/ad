package ch.hslu.sw02.exercise3;

@SuppressWarnings("unchecked")
public class CustomStack<T> implements ICustomStack<T> {
    private final int capacity;
    private final Object[] elements;

    private int currentIndex = 0;

    public CustomStack(int capacity) {
        this.capacity = capacity;
        elements = new Object[capacity];
    }


    @Override
    public void push(T element) {
        if (isFull()) {
            throw new IllegalStateException("Stack is full");
        }

        this.elements[currentIndex] = element;
        currentIndex++;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }

        currentIndex--;
        return (T) this.elements[currentIndex];
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }

        return (T) this.elements[currentIndex - 1];
    }

    @Override
    public boolean isEmpty() {
        return currentIndex == 0;
    }

    @Override
    public boolean isFull() {
        return currentIndex == capacity;
    }

    @Override
    public int size() {
        return currentIndex;
    }

    @Override
    public int capacity() {
        return capacity;
    }
}
