class Zipper {
    Zipper up;
    Zipper left;
    Zipper right;
    int value; 

    Zipper(int val) {
        this.value = val;
    }

    BinaryTree toTree() {
        Zipper root = this;
        while (root.up != null) { 
            root = root.up;
        }
        return new BinaryTree(root);
    }

    int getValue() {
        return value;
    }

    void setLeft(Zipper leftChild) {
        if (leftChild != null) {
            leftChild.up = this;
        }
        this.left = leftChild;
    }

    void setRight(Zipper rightChild) {
        if (rightChild != null) {
            rightChild.up = this;
        }
        this.right = rightChild;
    }

    void setValue(int val) {
        this.value = val;
    }

    String printTree() {
        StringBuilder result = new StringBuilder();
        result.append("value: ").append(this.value).append(", ");

        if (this.left != null) {
            result.append("left: { ").append(this.left.printTree()).append(" }, ");
        } else {
            result.append("left: null, ");
        }

        if (this.right != null) {
            result.append("right: { ").append(this.right.printTree()).append(" }");
        } else {
            result.append("right: null");
        }
        
        return result.toString();
    }

}
