import java.util.List;

class BinarySearchTree<T extends Comparable<T>> {
    Node<T> root;

    void insert(T value) {
        if (root == null) {
            this.root = new Node<>(value);
        } else {
            insertChild(root, value);
        }
    }

    private void insertChild(Node<T> node, T value) {
        if (node.getData().compareTo(value) >= 0) {
            node.left = new Node<>(value);
        }
        if (node.getData().compareTo(value) < 0) {
            node.right = new Node<>(value);
        }
    }

    List<T> getAsSortedList() {
        throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    }

    List<T> getAsLevelOrderList() {
        throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    }

    Node<T> getRoot() {
        return root;
    }

    static class Node<T extends Comparable<T>>{
        T value;
        Node<T> left;
        Node<T> right;

        Node(T value) {
            this.value = value;
            left = null;
            right = null;
        }

        Node<T> getLeft() {
            return left;
        }

        Node<T> getRight() {
            return right;
        }

        T getData() {
            return value;
        }

    }
}
