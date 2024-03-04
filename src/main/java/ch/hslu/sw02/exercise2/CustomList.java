package ch.hslu.sw02.exercise2;

import java.util.Iterator;
import java.util.Objects;

public class CustomList<T> {
    private Node<T> start;
    private Node<T> end;

    public void add(T item) {
        var node = new Node<T>(item);

        if (this.start == null) {
            this.start = node;
            this.end = node;
            return;
        }


        this.end.next = node;
        node.prev = this.end;
        this.end = node;
    }

    public int size() {
        if (this.start == null)
            return 0;

        var size = 0;
        var pointer = this.start;
        do {
            size++;
            pointer = pointer.next;
        } while (pointer != null);

        return size;
    }

    public boolean contains(T value) {
        if (this.start == null)
            return false;

        var pointer = this.start;
        do {
            if (pointer.value.equals(value))
                return true;

            pointer = pointer.next;
        } while (pointer != null);

        return false;
    }

    public T pop() {
        if (this.start == null)
            return null;

        var value = this.start.value;
        this.start = this.start.next;
        this.start.prev = null;
        return value;
    }

    public void remove(T value) {
        if (this.start == null)
            return;

        var pointer = this.start;
        do {
            if (pointer.value.equals(value)) {
                if (pointer.prev != null) {
                    pointer.prev.next = pointer.next;
                }
                else {
                    this.start = pointer.next;
                }

                if (pointer.next != null) {
                    pointer.next.prev = pointer.prev;
                }
                else {
                    this.end = pointer.prev;
                }
            }

            pointer = pointer.next;
        } while (pointer != null);
    }

    public T getLast() {
        return this.end.value;
    }

    public T getStart() {
        return this.start.value;
    }

    public Iterator<T> iterator() {
        return new CustomListIterator(this);
    }

    private static class Node<T> {
        private Node<T> prev;
        private Node<T> next;

        private final T value;

        private Node(T value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node<?> node = (Node<?>) o;
            return Objects.equals(value, node.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(value);
        }
    }

    public class CustomListIterator implements Iterator<T> {
        private final CustomList<T> customList;
        private Node<T> pointer;

        public CustomListIterator(CustomList<T> customList) {
            this.customList = customList;
            this.pointer = customList.start;
        }

        @Override
        public boolean hasNext() {
            return this.pointer != null && this.pointer.next != null;
        }

        @Override
        public T next() {
            var value = this.pointer.value;
            this.pointer = this.pointer.next;
            return value;
        }
    }
}
