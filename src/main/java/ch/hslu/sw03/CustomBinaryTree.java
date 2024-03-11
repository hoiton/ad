package ch.hslu.sw03;

import java.util.ArrayList;
import java.util.List;

public class CustomBinaryTree<T extends Comparable<T>> implements IBinaryTree<T> {
    private Node<T> root;

    @Override
    public void insert(T value) {
        if (root == null) {
            root = new Node<>(value);
            return;
        }
        else {
            insert(root, value);
        }
    }

    private void insert(Node<T> node, T value) {
        if (value.compareTo(node.value) == 0) {
            throw new IllegalArgumentException("Value already exists in tree");
        }

        if (value.compareTo(node.value) < 0) {
            if (node.left == null) {
                node.left = new Node<>(value);
            } else {
                insert(node.left, value);
            }
        } else {
            if (node.right == null) {
                node.right = new Node<>(value);
            } else {
                insert(node.right, value);
            }
        }
    }

    @Override
    public boolean contains(T value) {
        return contains(root, value);
    }

    private boolean contains(Node<T> node, T value) {
        if (node == null) {
            return false;
        }

        if (value.compareTo(node.value) == 0) {
            return true;
        }

        return value.compareTo(node.value) < 0
                ? contains(node.left, value)
                : contains(node.right, value);
    }

    @Override
    public void remove(T value) {
        remove(root, value);
    }

    private void remove(Node<T> node, T value) {
        if (node == null) {
            return;
        }

        if (value.compareTo(node.value) < 0) {
            remove(node.left, value);
        } else if (value.compareTo(node.value) > 0) {
            remove(node.right, value);
        } else {
            if (node.left == null && node.right == null) {
                node = null;
            } else if (node.left == null) {
                node = node.right;
            } else if (node.right == null) {
                node = node.left;
            } else {
                Node<T> minNode = findMin(node.right);
                node.value = minNode.value;
                remove(node.right, minNode.value);
            }
        }
    }

    private Node<T> findMin(Node<T> right) {
        if (right.left == null) {
            return right;
        }
        return findMin(right.left);
    }

    @Override
    public List<T> traverseInOrder() {
        var list = new ArrayList<T>();
        traverseInOrder(root, list);

        return list;
    }

    private void traverseInOrder(Node<T> node, List<T> list) {
        if (node == null) {
            return;
        }

        traverseInOrder(node.left, list);
        list.add(node.value);
        traverseInOrder(node.right, list);
    }

    private static class Node<T> {
        private T value;
        private Node<T> left;
        private Node<T> right;

        private Node(T value) {
            this.value = value;
        }
    }
}
