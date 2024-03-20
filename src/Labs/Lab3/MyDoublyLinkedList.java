package Labs.Lab3;

import Labs.Lab2.Node;

public class MyDoublyLinkedList<T extends Comparable<T>> {
    private DNode<T> head;

    public void insert(T data) {
        DNode<T> newNode = new DNode<T>(data);

        if (head == null) {      // Case 0 : Linked List is Empty
            System.out.println("List is Empty... adding..");
            head = newNode;
        } else {
            DNode<T> curr = head;

            while (curr != null && curr.getData().compareTo(data) < 0) {
                curr = curr.getNext();

            }
            if (curr == head) {   // Case 1 : Insert First

                System.out.println("Insert First");

                newNode.setNext(curr);
                curr.setPrev(newNode);
                head = newNode;
            } else if (curr == null) {        // Case 2 : Insert Last

                System.out.println("Insert Last");

                curr.getPrev().setNext(newNode);
                newNode.setPrev(curr.getPrev());
            } else {                              // Case 3: Insert Between
                newNode.setNext(curr);
                curr.getPrev().setNext(newNode);
                newNode.setPrev(curr.getPrev());
                curr.setPrev(newNode);



            }

        }
    }

    public boolean delete(T data) {
        DNode<T> curr = head;
        if (curr == null)
            throw new NullPointerException();

        while (curr != null && curr.getData().compareTo(data) != 0) {
            curr = curr.getNext();

        }
        if (curr.getData() == data) {
            if (curr == head) {   // Case 1 : Delete First
                System.out.println("Delete First");
                head = head.getNext();
                curr.setNext(null);
                curr.setPrev(null);
                return true;

            } else if (curr.getNext() == null) {        // Case 2 : Delete Last
                curr.getPrev().setNext(null);
                curr.setPrev(null);
                System.out.println("Delete Last");
                return true;


            } else {                              // Case 3: Delete Between
                curr.getNext().setPrev(curr.getPrev());
                curr.getPrev().setNext(curr.getNext());
                curr.setNext(null);

                return true;
            }
        }
        System.out.println("Not in List");
        return false;

    }

    public T find(T data) {
        DNode<T> curr = head;
        while (curr != null && curr.getData().compareTo(data) != 0) {
            curr = curr.getNext();
        }
        if (curr != null && curr.getData() == data) {
            System.out.println("Found");
            return data;
        }
        System.out.println("Not Found");
        return null;
    }


    public void traverse() {
        DNode<T> curr = head;
        System.out.print("Head -> ");

        while (curr != null) {
            System.out.print(curr.getData() + " <-> ");
            curr = curr.getNext();
        }
        System.out.println("Null");
    }

    public DNode<T> getTail(){
        DNode<T> curr = head;
        DNode tail;
        while (curr.getNext() != null)
            curr = curr.getNext();
        tail = curr;
        return tail;
    }
    public void reverse() {
        DNode curr = head, prev = null;
        DNode tail = getTail();
        while (head.getNext() != null) {
            while (curr.getNext() != null) {
                prev = curr;
                curr = curr.getNext();
            }
            curr.setNext(prev);
            prev.setNext(null);
            curr = head;
            prev = null;
        }
        head = tail;
    }

    public void reverseRecursive() {
        head = reverseRecursive(head, null);
    }
    private DNode<T> reverseRecursive(DNode<T> curr, DNode<T> prev) {
        if (curr == null) {
            return prev;
        }

        DNode<T> next = curr.getNext();
        curr.setNext(prev);
        return reverseRecursive(next, curr);
    }
}


