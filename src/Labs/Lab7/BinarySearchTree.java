package Labs.Lab7;

public class BinarySearchTree<T extends Comparable<T>> {

    private TNode<T> root;

    public BinarySearchTree() {
        root = null;
    }

    public BinarySearchTree(T data) {
        root = new TNode<>(data);
    }

    public void insert(T data) {
        if (isEmpty())
            root = new TNode<T>(data);
        else
            insert(data, root);
    }

    private void insert(T data, TNode<T> node) {
        if (data.compareTo(node.getData()) >= 0) { // insert into right subtree
            if (!node.hasRight())
                node.setRight(new TNode<>(data));
            else
                insert(data, node.getRight());
        } else { // insert into left subtree
            if (!node.hasLeft())
                node.setLeft(new TNode<>(data));
            else
                insert(data, node.getLeft());
        }
    }

    public TNode<T> delete(T data) {
        TNode<T> current = root;
        TNode<T> parent = root;
        boolean isLeftChild = false;

        if (isEmpty())
            return null; // tree is empty

        while (current != null && !current.getData().equals(data)) {
            parent = current;
            if (data.compareTo(current.getData()) < 0) {
                current = current.getLeft();
                isLeftChild = true;
            } else {
                current = current.getRight();
                isLeftChild = false;
            }
        }
        if (current == null)
            return null; // not found
        // case 1: node is a leaf
        if (!current.hasLeft() && !current.hasRight()) {
            if (current == root)
                root = null;
            else {
                if (isLeftChild)
                    parent.setLeft(null);
                else
                    parent.setRight(null);
            }
        } // Case 2 broken down further into 2 separate cases
        else if (current.hasLeft()) { // current has left child only
            if (current == root) {
                root = current.getLeft();
            } else if (isLeftChild) {
                parent.setLeft(current.getLeft());
            } else {
                parent.setRight(current.getLeft());
            }
        } else if (current.hasRight()) { // current has right child only
            if (current == root) {
                root = current.getRight();
            } else if (isLeftChild) {
                parent.setLeft(current.getRight());
            } else {
                parent.setRight(current.getRight());
            }
        } // case 3: node to be deleted has 2 children
        else {
            TNode<T> successor = getSuccessor(current);
            if (current == root)
                root = successor;
            else if (isLeftChild) {
                parent.setLeft(successor);
            } else {
                parent.setRight(successor);
            }
            successor.setLeft(current.getLeft());
        }

        return current;
    }

    private TNode<T> getSuccessor(TNode<T> node) {
        TNode<T> parentOfSuccessor = node;
        TNode<T> successor = node;
        TNode<T> current = node.getRight();
        while (current != null) {
            parentOfSuccessor = successor;
            successor = current;
            current = current.getLeft();
        }
        if (successor != node.getRight()) { // fix successor connections
            parentOfSuccessor.setLeft(successor.getRight());
            successor.setRight(node.getRight());
        }
        return successor;
    }

    public TNode<T> find(T data) {
        return find(data, root);
    }

    private TNode<T> find(T data, TNode<T> node) {
        if (node != null) {
            int comp = node.getData().compareTo(data);
            if (comp == 0)
                return node;
            else if (comp > 0 && node.hasLeft())
                return find(data, node.getLeft());
            else if (comp < 0 && node.hasRight())
                return find(data, node.getRight());
        }
        return null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public TNode<T> largest() {
        return largest(root);
    }

    private TNode<T> largest(TNode<T> node) {
        if (node != null) {
            if (!node.hasRight())
                return node;
            return largest(node.getRight());
        }
        return null;
    }

    public TNode<T> smallest() {
        return smallest(root);
    }

    private TNode<T> smallest(TNode<T> node) {
        if (node != null) {
            if (!node.hasLeft())
                return node;
            return smallest(node.getLeft());
        }
        return null;
    }

    public int height() {
        return height(root);
    }

    private int height(TNode<T> node) {
        if (node == null)
            return 0;
        if (node.isLeaf())
            return 1;
        int left = 0;
        int right = 0;
        if (node.hasLeft())
            left = height(node.getLeft());
        if (node.hasRight())
            right = height(node.getRight());
        return (left > right) ? (left + 1) : (right + 1);
    }

    public void traverseInOrder() {
        traverseInOrder(root);
    }

    private void traverseInOrder(TNode<T> node) {
        if (node != null) {
            if (node.getLeft() != null)
                traverseInOrder(node.getLeft());
            System.out.print(node + " ");
            if (node.getRight() != null)
                traverseInOrder(node.getRight());
        }
    }

    public void traversePreOrder() {
        traversePreOrder(root);
    }

    private void traversePreOrder(TNode<T> node) {
        if (node != null) {
            System.out.print(node + " ");
            if (node.getLeft() != null)
                traversePreOrder(node.getLeft());
            if (node.getRight() != null)
                traversePreOrder(node.getRight());
        }
    }

    public void traversePostOrder() {
        traversePostOrder(root);
    }

    private void traversePostOrder(TNode<T> node) {
        if (node != null) {
            if (node.getLeft() != null)
                traversePostOrder(node.getLeft());
            if (node.getRight() != null)
                traversePostOrder(node.getRight());
            System.out.print(node + " ");
        }
    }

    public TNode<T> search(T data) {
        return search(data, root);
    }

    private TNode<T> search(T data, TNode<T> node) {
        if (node != null) {
            int comp = node.getData().compareTo(data);
            if (comp == 0)
                return node;
            else if (comp > 0)
                return search(data, node.getLeft());
            else
                return search(data, node.getRight());
        }
        return null;
    }

    public int countLeaves(TNode<T> node) {
        if (node == null)
            return 0;
        if (node.isLeaf())
            return 1;
        return countLeaves(node.getLeft()) + countLeaves(node.getRight());
    }

    public int countParents(TNode<T> node) {
        if (node == null)
            return 0;
        if (node.isLeaf())
            return 0;
        return 1 + countParents(node.getLeft()) + countParents(node.getRight());
    }
}
