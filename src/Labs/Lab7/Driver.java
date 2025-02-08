package Labs.Lab7;

public class Driver {

    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<Integer>();
        tree.insert(6);
        tree.insert(7);
        tree.insert(2);
        tree.insert(1);
        tree.insert(3);
        tree.insert(8);
        tree.insert(4);

        System.out.print("Pre Order Traversal  : ");  tree.preOrderTraversal();
        System.out.print("In Order Traversal   : ");  tree.inOrderTraversal();
        System.out.print("Post Order Traversal : ");  tree.postOrderTraversal();
        System.out.print("In Level Traversal   : ");  tree.inLevelTraversal_ITERATIVE();
         tree.inLevelTraversal_ITERATIVE();

        System.out.println(tree.height());



        //    tree.printTree();


    }

}
