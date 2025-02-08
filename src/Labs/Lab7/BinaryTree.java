package Labs.Lab7;
import Labs.Lab6.LinkedQueue;



public class BinaryTree<T extends Comparable<T>> {
    TNode<T> root;

    public BinaryTree() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void insert(T data) {
        if (isEmpty())
            root = new TNode<>(data);
        else
            insert(data, root);
    }

    public void insert(T data, TNode<T> node) {
        if (data.compareTo(node.getData()) >= 0) {
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

    public void inOrderTraversal() {
        inOrderTraversal(root);
        System.out.println();
    }

    private void inOrderTraversal(TNode<T> node) {
        if (node != null) {
            inOrderTraversal(node.getLeft());
            System.out.print(node.getData() + " ");
            inOrderTraversal(node.getRight());
        }
    }

    public void preOrderTraversal() {
        preOrderTraversal(root);
        System.out.println();
    }

    private void preOrderTraversal(TNode<T> node) {
        if (node != null) {
            System.out.print(node.getData() + " ");
            preOrderTraversal(node.getLeft());
            preOrderTraversal(node.getRight());
        }
    }

    public void postOrderTraversal() {
        postOrderTraversal(root);
        System.out.println();
    }

    private void postOrderTraversal(TNode<T> node) {
        if (node != null) {
            postOrderTraversal(node.getRight());
            postOrderTraversal(node.getLeft());
            System.out.print(node.getData() + " ");
        }
    }

//    public void inLevelTraversal() {
//
//        inLevelTraversal(root);
//        System.out.println();
//    }
//
//    private void inLevelTraversal(TNode<T> node) {
//       LinkedQueue<T> queue = new LinkedQueue<>();
//
//        printGivenLevel(node.getLeft(),height());
//        printGivenLevel(node.getRight(),height());
//        queue.enqueue(node.getData());
//
//
//    }

    private void printGivenLevel(TNode<T> node, int level) {

        if (node == null || level == 0)
            return;
        if (level == 1)
            System.out.print(node.getData() + " ");

        else if (level > 1) {

            printGivenLevel(node.getLeft(), level - 1);
            printGivenLevel(node.getRight(), level - 1);

        }

    }

    public void inLevelTraversal_ITERATIVE() {
        int h = height(root);
        for (int i = 1; i <= h; i++) {
            printGivenLevel(root, i);
            System.out.print(" ");
        }
        System.out.println();
    }

    public int height() {
        return height(root);
    }


    private int height(TNode<T> node) {
        if (node == null)
            return 0;
        else {
            int lHeight = height(node.getLeft());
            int rHeight = height(node.getRight());

            if (lHeight > rHeight)
                return (lHeight + 1);
            else
                return (rHeight + 1);
        }
    }

    public int countParents() {
        return countParents(root);
    }

    private int countParents(TNode<T> node) {
        if (node == null || (node.getLeft() == null && node.getRight() == null)) {
            return 0;
        }
        return 1 + countParents(node.getLeft()) + countParents(node.getRight());
    }

    public int countChildren() {
        return countChildren(root);
    }

    private int countChildren(TNode<T> node) {
        if (node == null) {
            return 0;
        }
        return 1 + countChildren(node.getLeft()) + countChildren(node.getRight());
    }

    public int countLeaves() {
        return countLeaves(root);
    }

    private int countLeaves(TNode<T> node) {
        if (node == null) {
            return 0;
        }
        if (node.getLeft() == null && node.getRight() == null) {
            return 1;
        }
        return countLeaves(node.getLeft()) + countLeaves(node.getRight());
    }

    public int size() {
        return size(root);
    }

    private int size(TNode<T> node) {
        if (node == null) {
            return 0;
        }
        return 1 + size(node.getLeft()) + size(node.getRight());
    }

    public TNode<T> delete(T data) {
        TNode<T> current = root;
        TNode<T> parent = root;
        boolean isLeftChild = false;
        if (isEmpty())
            return null;
        while (current != null && !current.getData().equals(data)) {
            parent = current;
            if (data.compareTo((T) current.getData()) < 0) {
                current = current.getLeft();
                isLeftChild = true;
            } else {
                current = current.getRight();
                isLeftChild = false;
            }
        }
        if (current == null)
            return null;

        if (!current.hasLeft() && !current.hasRight()) {
            if (current == root)
                root = null;
            else {
                if (isLeftChild)
                    parent.setLeft(null);
                else
                    parent.setRight(null);
            }
        }
        return parent;
    }

//    void printTree() {
//        if (root == null) {
//            System.out.println("Tree is empty");
//            return;
//        }
//
//        Queue<TNode> queue = new LinkedList<>();
//        queue.add(root);
//
//        while (!queue.isEmpty()) {
//            int size = queue.size();
//            for (int i = 0; i < size; i++) {
//                TNode<T> current = queue.poll();
//                if (current == null) {
//                    System.out.print("  ");
//                    queue.add(null);
//                    queue.add(null);
//                } else {
//                    System.out.print(current.data + " ");
//                    queue.add(current.getLeft());
//                    queue.add(current.getRight());
//                }
//            }
//            System.out.println();
//        }
//    }
}
	

