package ch.hslu.sw04;

import java.util.Arrays;
import java.util.Objects;

public class ListHashset<T> implements ICustomHashset<T> {
    private final Object[] values;
    private final int size;

    public ListHashset(int size) {
        this.size = size;
        this.values = new Object[size];
    }

    public ListHashset() {
        this(16);
    }

    @Override
    public void add(T value) {
        int index = value.hashCode() % size;
        if (values[index] == null) {
            values[index] = new Node<>(value);
        }
        else {
            @SuppressWarnings("unchecked") Node<T> node = (Node<T>) values[index];
            do {
                if (node.value.equals(value))
                    throw new IllegalArgumentException("Value already exists in hashset");
                if (node.next != null) {
                    node = node.next;
                }
            } while (node.next != null);
            if (node.value.equals(value))
                throw new IllegalArgumentException("Value already exists in hashset");

            node.next = new Node<>(value);
        }
    }

    @Override
    public boolean contains(T value) {
        var index = value.hashCode() % size;
        if (values[index] == null)
            return false;

        @SuppressWarnings("unchecked") var node = (Node<T>) values[index];
        while (node != null) {
            if (node.value.equals(value))
                return true;
            node = node.next;
        }

        return false;
    }

    @Override
    public void remove(T value) {
        var index = value.hashCode() % size;
        if (values[index] == null)
            throw new IllegalArgumentException("Value does not exist in hashset");

        @SuppressWarnings("unchecked") var node = (Node<T>) values[index];

        if (node.value.equals(value)) {
            values[index] = node.next;
            return;
        }

        while (node.next != null) {
            if (node.next.value.equals(value)) {
                node.next = node.next.next;
                return;
            }
            node = node.next;
        }

        throw new IllegalArgumentException("Value does not exist in hashset");
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isFull() {
        return Arrays.stream(values).allMatch(Objects::nonNull);
    }

    @Override
    public String toString() {
        return "CustomHashset{" +
                "values=" + Arrays.toString(values) +
                ", size=" + size +
                "}";
    }

    private static class Node<T> {
        private final T value;
        private Node<T> next;

        public Node(T value) {
            this.value = value;
        }

        @Override
        public String toString() {
            if (next == null)
                return value.toString();
            return value.toString() + ',' + next.toString();
        }
    }
}
