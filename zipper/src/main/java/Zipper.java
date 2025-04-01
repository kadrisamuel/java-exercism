import java.util.Objects;

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

class BinaryTree {
    Zipper root;

    BinaryTree(int value) {
        this(new Zipper(value));
    }

    BinaryTree(Zipper root) {
        this.root = root;
    }

    Zipper getRoot() {
        return root;
    }

    String printTree(){
        return this.root.printTree();
    }
    

    // copied the overriden functions from other solutions to pass the isEqualTo check in tests
    @Override
    public boolean equals(Object obj) {
      if(this == obj) {
        return true;
      }
      if(obj == null || getClass() != obj.getClass()) {
        return false;
      }
      BinaryTree that = (BinaryTree) obj;
      return Objects.equals(root, that.root);
    }
    @Override
    public int hashCode() {
      return Objects.hash(root);
    }
}
