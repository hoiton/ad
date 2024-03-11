package ch.hslu.sw03;

import java.util.List;

public interface IBinaryTree<T> {
    void insert(T value);

    boolean contains(T value);

    void remove(T value);

    List<T> traverseInOrder();
}
