//package Labs.Lab8;
//
//public class AVLTree<T extends Comparable<T>> {
//    private TNode<T> root;
//
//    public AVLTree() {
//        root = null;
//    }
//
//    public void insert(T data) {
//        if(root==null) root = new TNode<>(data);
//        else {
//            TNode<T> rootNode = root;
//            addEntry(data, rootNode);
//            root = reBalance(rootNode);
//        }
//    }
//    public void addEntry(T data, TNode<T> rootNode){
//        assert rootNode != null;
//        if(data.compareTo((T)rootNode.data) < 0){ // right into left subtree
//            if(rootNode.hasLeft()){
//                TNode<T> leftChild = rootNode.getLeft();
//                addEntry(data, leftChild);
//                rootNode.setLeft(reBalance(leftChild));
//            }
//            else rootNode.setLeft(new TNode<>(data));
//        }
//        else { // right into right subtree
//            if(rootNode.hasRight()){
//                TNode<T> rightChild = rootNode.getRight();
//                addEntry(data, rightChild);
//                rootNode.setRight(reBalance(rightChild));
//            }
//            else rootNode.setRight(new TNode<>(data));
//        }
//    }
//
//    private int getHeight(TNode<T> node) {
//        if (node == null)
//            return 0;
//        return 1 + Math.max(getHeight(node.getLeft()), getHeight(node.getRight()));
//
//
//    }
//
//    private TNode<T> reBalance(TNode<T> nodeN){
//        int diff = getHeightDifference(nodeN);
//        if ( diff > 1) { // addition was in node's left subtree
//            if(getHeightDifference(nodeN.getLeft())>0)
//                nodeN = rotateRight(nodeN);
//            else
//                nodeN = rotateLeftRight(nodeN);
//        }
//        else if ( diff < -1){ // addition was in node's right subtree
//            if(getHeightDifference(nodeN.getRight())<0)
//                nodeN = rotateLeft(nodeN);
//            else
//                nodeN = rotateRightLeft(nodeN);
//        }
//        return nodeN;
//
//}
//
//    private TNode<T> rotateRight(TNode<T> node) {
//        TNode<T> leftChild = node.getLeft();
//
//        leftChild.setRight(node);
//        node.setLeft(leftChild.getRight());
//
//        return leftChild;
//    }
//
//    private TNode<T> rotateLeft(TNode<T> node) {
//        TNode<T> rightChild = node.getRight();
//
//        rightChild.setLeft(node);
//        node.setRight(rightChild.getLeft());
//
//        return rightChild;
//    }
//
//    private TNode<T> rotateLeftRight(TNode<T> nodeN) {
//       return rotateLeft(rotateRight(nodeN));
//    }
//
//    private TNode<T> rotateRightLeft(TNode<T> nodeN) {
//        return rotateRight(rotateLeft(nodeN));
//    }
//    public void inOrder() {
//        inOrderRec(root);
//    }
//    private void inOrderRec(TNode<T> node) {
//        if (node != null) {
//            inOrderRec(node.getLeft());
//            System.out.print(node.getData() + " ");
//            inOrderRec(node.getRight());
//        }
//    }
//    private int getHeightDifference(TNode<T> node) {
//        return getHeight(node.getLeft())-getHeight(node.getRight());
//    }
//
//}
