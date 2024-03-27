package Labs.Lab3;

import Labs.Lab2.Node;

public class MyDoublyLinkedList<T extends Comparable<T>> {
    private DNode<T> head;

    public void insert(T data) {
        DNode<T> newNode = new DNode<T>(data);

        if (head == null) { // Case 0 : Linked List is Empty
            System.out.println("List is Empty... adding..");
            head = newNode;
        } else {
            DNode<T> curr = head;

            while (curr.getNext() != null && curr.getData().compareTo(data) < 0) {
                curr = curr.getNext();

            }
            if (curr == head && curr.getData().compareTo(data) >= 0) { // Case 1 : Insert First
                System.out.println("Inserting " + newNode.getData() + " first");
                curr.setPrev(newNode);
                head = newNode;
                newNode.setNext(curr);

            } else if (curr.getData().compareTo(data) < 0 && curr.getNext() == null) { // Case 2 : Insert Last

                curr.setNext(newNode);
                newNode.setPrev(curr);

            } else { // Case 3: Insert Between
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
            if (curr == head) { // Case 1 : Delete First
                System.out.println("Delete First");
                head = head.getNext();
                curr.setNext(null);
                curr.setPrev(null);
                return true;

            } else if (curr.getNext() == null) { // Case 2 : Delete Last
                curr.getPrev().setNext(null);
                curr.setPrev(null);
                System.out.println("Delete Last");
                return true;

            } else { // Case 3: Delete Between
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

    public void rectraverse() {
        System.out.print("Head -> ");
        DNode<T> curr = head;
        rectraverse(curr);
    }

    private void rectraverse(DNode<T> curr) {
        if (curr == null)
            System.out.println("Null");
        else {
            System.out.print(curr.getData() + " <-> ");
            rectraverse(curr.getNext());
        }

    }

    public void traREverse() {
        DNode<T> curr = head;
        System.out.print("Head -> ");

        while (curr.getNext() != null) {
            curr = curr.getNext();
        }
        while (curr != null) {
            System.out.print(curr.getData() + " <-> ");
            curr = curr.getPrev();
        }
        System.out.println("Null");
    }

    public void rectraREverse() {
        System.out.print("Head -> ");
        DNode<T> curr = head;
        rectraREverse(curr);
        System.out.print("Null");
    }

    private void rectraREverse(DNode<T> curr) {
        if (curr != null) {
            rectraREverse(curr.getNext());
            System.out.print(curr.getData() + " <-> ");
        }
    }


    public int recsize() {
        return recsize(head, 0);
    }

    private int recsize(DNode<T> curr, int res) {
        if (curr == null)
            return res;

        else
            return recsize(curr.getNext(), res + 1);
    }

    public int size() {
        DNode<T> curr = head;
        int c = 0;
        while (curr != null) {
            c++;
            curr = curr.getNext();
        }
        return c;
    }

    public int getOccuranceRec(T data) {

        return getOccuranceRec(data, head);
    }

    private int getOccuranceRec(T data, DNode<T> curr) {
        if (curr == null)
            return 0;
        if (curr.getData() == data)
            return 1 + getOccuranceRec(data, curr.getNext());

        return getOccuranceRec(data, curr.getNext());
    }

    public int getOccurance(T data) {
        int count = 0;
        DNode<T> curr = head;
        while (curr != null && curr.getData().compareTo(data) > 0) {
            if (curr.getData().compareTo(data) == 0) {
                count++;

            }
            curr = curr.getNext();

        }
        return count;

    }

    public void RemoveDuplicates() {
        DNode<T> curr = head;
        DNode<T> next = curr.getNext();
        while (next.getNext() != null) {
            while (curr.getData().compareTo(next.getData()) == 0) {
                next = next.getNext();
            }
            curr.setNext(next);
            next.setPrev(curr);
            curr = curr.getNext();

        }
    }

    public void removeDuplicaterec() {
        removeDuplicaterec(head, head.getNext());

    }

    private void removeDuplicaterec(DNode<T> curr, DNode<T> next) {

        if (next != null) {
            if (curr.getData().compareTo(next.getData()) == 0) {
                removeDuplicaterec(curr, next.getNext());
            } else {
                removeDuplicaterec(curr.getNext(), next);
                curr.setNext(next);
                next.setPrev(curr);

            }

        } else {
            curr.setNext(null);
        }

    }

    public void recursiveReverse() {
        head = recursiveReverse(head);
    }

    private DNode<T> recursiveReverse(DNode<T> curr) {
        if (curr.getNext() == null) {
            return curr;
        }
        DNode<T> node = recursiveReverse(curr.getNext());
        curr.getNext().setPrev(curr.getNext().getNext());
        curr.getNext().setNext(curr);
        curr.setNext(null);
        curr.setPrev(node);

        return node;
    }



}