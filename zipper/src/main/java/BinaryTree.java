import java.util.Objects;

public class BinaryTree {
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
