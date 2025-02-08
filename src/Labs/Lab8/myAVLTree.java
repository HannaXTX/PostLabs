package Labs.Lab8;

public class myAVLTree<T extends Comparable<T>>{
    private TNode<T> root;



    TNode<T> rotateRight(TNode<T> node){
        TNode<T> leftC=node.getLeft();
        node.setLeft(leftC.getRight());
        leftC.setRight(node);
        return leftC;
    }
    TNode<T> rotateLeft(TNode<T> node){
        TNode<T> rightC=node.getRight();
        node.setRight(rightC.getLeft());
        rightC.setLeft(node);
        return rightC;
    }
    TNode<T> rotateLeftRight(TNode<T> node){
        TNode<T> leftC=node.getLeft();
        node.setLeft(rotateLeft(leftC));
        return rotateRight(node);
    }

}
