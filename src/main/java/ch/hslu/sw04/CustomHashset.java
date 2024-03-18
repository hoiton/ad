package ch.hslu.sw04;

import java.util.Arrays;
import java.util.Objects;

public class CustomHashset<T> implements ICustomHashset<T> {
    private final Object[] values;
    private final int size;

    public CustomHashset(int size) {
        this.size = size;
        this.values = new Object[size];
    }

    public CustomHashset() {
        this(16);
    }

    @Override
    public void add(T value) {
        int index = value.hashCode() % size;
        if (values[index] != null){
            if (values[index].equals(value)) {
                throw new IllegalArgumentException("Value already exists in hashset");
            }

            if (this.isFull())
                throw new IllegalStateException("Hashset is full");

            do {
                index = (index + 1) % size;
            } while (values[index] != null);
        }
        values[index] = value;
    }

    @Override
    public boolean contains(T value) {
        Integer index = getIndex(value);
        return index != null;
    }

    @Override
    public void remove(T value) {
        var index = getIndex(value);
        if (index == null)
            throw new IllegalArgumentException("Value does not exist in hashset");
        values[index] = null;
    }

    private Integer getIndex(T value) {
        int index = value.hashCode() % size;
        if (values[index] != null && values[index].equals(value))
            return index;

        Integer foundIndex = null;
        do {
            index = (index + 1) % size;
            if (values[index] != null && values[index].equals(value)) {
                foundIndex = index;
                break;
            }
        } while (values[index] != null && index != value.hashCode() % size);

        return foundIndex;
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
}
