package ch.hslu.sw10;

public class FixedSizeHeap implements IIntegerHeap {

    private final int size;
    private int pointer = 0;
    private int[] heap;

    public FixedSizeHeap(int size) {
        this.size = size;
        this.heap = new int[size];
    }

    @Override
    public void insert(int element) {
        if (this.pointer == this.size) {
            throw new IllegalStateException("Heap is full");
        }

        this.heap[this.pointer] = element;
        sortUp(this.pointer);

        this.pointer++;
    }

    private void sortUp(int current) {
        var parent = parent(current);

        if (get(parent) < get(current))
        {
            exchange(parent, current);
            sortUp(parent);
        }
    }

    @Override
    public int getMax() {
        if (this.isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }

        return this.heap[0];
    }

    @Override
    public int popMax() {
        if (this.isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }

        var current = this.heap[0];

        // Move last element to the root
        this.heap[0] = this.heap[this.pointer - 1];

        sortDown(0);

        return current;
    }

    private void sortDown(int current) {
        var childRight = childRight(current);
        var childLeft = childLeft(current);

        if (get(childLeft) < get(current) && get(childRight) < get(current))
            return;

        var swap = get(childLeft) > get(childRight)
                ? childLeft
                : childRight;

        exchange(current, swap);

        sortDown(swap);
    }

    private int parent(int indexChild) {
        return (indexChild - 1) / 2;
    }

    private int childLeft(int indexParent) {
        return (indexParent * 2) + 1;
    }

    private int childRight(int indexParent) {
        return (indexParent * 2) + 2;
    }

    private int get(int index) {
        if (index >= this.size)
            return -1;

        return this.heap[index];
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return pointer == 0;
    }


    /**
     * Vertauscht zwei bestimmte Zeichen im Array.
     *
     * @param firstIndex Index des ersten Zeichens
     * @param secondIndex Index des zweiten Zeichens
     */
    private void exchange(final int firstIndex, final int secondIndex) {
        int tmp;
        tmp = this.heap[firstIndex];
        this.heap[firstIndex] = this.heap[secondIndex];
        this.heap[secondIndex] = tmp;
    }
}
