import java.util.ArrayList;
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
            if (node.left == null) {
                node.left = new Node<>(value);
            } else {
                insertChild(node.left, value);
            }
        }
        if (node.getData().compareTo(value) < 0) {
            if (node.right == null) {
                node.right = new Node<>(value);
            } else {
                insertChild(node.right, value);
            }
        }
    }

    List<T> getAsSortedList() {
        throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    }

    List<T> getAsLevelOrderList() {
        List<T> tree = new ArrayList<>();
        tree.add(root.value);
        breathTraversal(root, tree);
        return tree;
    }

    private void breathTraversal(Node<T> node, List<T> countedNodes) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            countedNodes.add(node.left.value);
        }
        if (node.right != null) {
            countedNodes.add(node.right.value);
        }

        breathTraversal(node.left, countedNodes);
        breathTraversal(node.right, countedNodes);
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
