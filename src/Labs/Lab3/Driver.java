package Labs.Lab3;

public class Driver {
    public static void main(String[] args) {
        MyDoublyLinkedList<Integer> Dlist = new MyDoublyLinkedList<>();
        Dlist.insert(50);
        Dlist.insert(30);
        Dlist.insert(30);
        Dlist.insert(30);
        Dlist.insert(30);
        Dlist.insert(30);
        Dlist.insert(30);
        Dlist.insert(20);
        Dlist.insert(15);
        Dlist.insert(35);
        Dlist.insert(100);
        //     Dlist.delete(30);
        System.out.println(Dlist.size());
        //  Dlist.RemoveDuplicates();
        Dlist.removeDuplicaterec();
        Dlist.traverse();
        Dlist.traREverse();
        Dlist.rectraverse();
        Dlist.rectraREverse();
    }
}
