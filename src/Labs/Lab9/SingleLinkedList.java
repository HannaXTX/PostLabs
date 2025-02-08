package Labs.Lab9;

import Labs.Lab2.Node;


public class SingleLinkedList<T extends Comparable<T>> {

    private Node<T> head;
    private Node<T> dummy;

    public SingleLinkedList() {
        initializeDummy();
    }

    public void initializeDummy() {
        dummy = new Node<>(null);
        head = dummy;
    }

    public Node<T> getAfterHead() {
        return head.getNext();
    }

    public void insertFirst(T data) {
        Node<T> newNode = new Node<>(data);
        Node<T> curr = dummy, next = head.getNext();

        if (curr.getNext() == null)
            dummy.setNext(newNode);
        else {
            newNode.setNext(dummy.getNext());
            dummy.setNext(newNode);
        }
    }

    public void insert(T data) {
        Node<T> newNode = new Node<>(data);

        Node<T> curr = dummy, next = head.getNext();

        while (next != null && next.getData().compareTo(data) < 0) {

            curr = next;
            next = next.getNext();
        }
        if (curr == dummy) {   // Case 1 : Insert First
            newNode.setNext(dummy.getNext());
            dummy.setNext(newNode);
        } else if (next == null) {      // Case 2 : Insert Last
            curr.setNext(newNode);
        } else {                              // Case 3: Insert Between
            newNode.setNext(next);
            curr.setNext(newNode);
        }

    }


    public boolean delete(T data) {
        Node<T> next = head.getNext(), curr = dummy;
        if (next == null)
            throw new NullPointerException();
        while (next.getNext() != null && next.getData().compareTo(data) != 0) {
            curr = next;
            next = next.getNext();

        }
        if (next.getData() == data) {
            if (curr == null) {   // Case 1 : Delete First
                System.out.println("Delete First");
                head = head.getNext();
                next.setNext(null);
                return true;

            } else if (next.getNext() == null) {        // Case 2 : Delete Last
                curr.setNext(null);
                System.out.println("Delete Last");
                return true;


            } else {                              // Case 3: Delete Between
                curr.setNext(next.getNext());
                return true;
            }
        }
        System.out.println("Not in List");
        return false;

    }

    public int size() {
        Node<T> curr = getAfterHead();
        int c = 0;
        while (curr != null) {
            c++;
            curr = curr.getNext();
        }
        return c;
    }

    public T find(T data) {
        Node<T> curr = head.getNext();
        if (curr == null)
            return null;
        while (curr.getNext() != null && curr.getData().compareTo(data) != 0) {
            curr = curr.getNext();
        }
        if (curr.getData().compareTo(data) == 0) {
            return data;
        }

        return null;
    }

    public T findUnsorted(T data){
        Node<T> curr = getAfterHead();
        while (curr!=null){
            if (curr.getData().compareTo(data) == 0) {
                return  curr.getData();
            }
            curr =curr.getNext();
        }
        return null;
    }

    public void traverse() {
        Node<T> curr = head.getNext();
        System.out.print("Head -> ");

        while (curr != null) {
            System.out.print(curr.getData() + " -> ");
            curr = curr.getNext();
        }
        System.out.println("Null");
    }

    public Node<T> getTail() {
        Node<T> curr = head;
        Node<T> tail;
        while (curr.getNext() != null)
            curr = curr.getNext();
        tail = curr;
        return tail;
    }


}
