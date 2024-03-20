package Labs.Lab2;

public class MyLinkedList<T extends Comparable<T>> {

    private Node<T> head;

    public void insert(T data) {
        Node<T> newNode = new Node<>(data);

        if (head == null) {      // Case 0 : Linked List is Empty
            System.out.println("List is Empty... adding..");
            head = newNode;
        } else {
            Node<T> curr = head, prev = null;

            while (curr != null && curr.getData().compareTo(data) < 0) {
                prev = curr;
                curr = curr.getNext();

            }
            if (prev == null) {   // Case 1 : Insert First

                System.out.println("Insert First");

                newNode.setNext(curr);
                head = newNode;
            } else if (curr == null) {        // Case 2 : Insert Last

                System.out.println("Insert Last");

                prev.setNext(newNode);
            } else {                              // Case 3: Insert Between
                newNode.setNext(curr);
                prev.setNext(newNode);
            }

        }
    }

    public boolean delete(T data) {
        Node<T> curr = head, prev = null;
        if (curr == null)
            throw new NullPointerException();

        while (curr != null && curr.getData().compareTo(data) != 0) {
            prev = curr;
            curr = curr.getNext();

        }
        if (curr.getData() == data) {
            if (prev == null) {   // Case 1 : Delete First
                System.out.println("Delete First");
                head = head.getNext();
                curr.setNext(null);
                return true;

            } else if (curr == null) {        // Case 2 : Delete Last
                prev.setNext(null);
                System.out.println("Delete Last");
                return true;


            } else {                              // Case 3: Delete Between
                prev.setNext(curr.getNext());
                return true;
            }
        }
        System.out.println("Not in List");
        return false;

    }

    public T find(T data) {
        Node<T> curr = head;
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
        Node<T> curr = head;
        System.out.print("Head -> ");

        while (curr != null) {
            System.out.print(curr.getData() + " -> ");
            curr = curr.getNext();
        }
        System.out.println("Null");
    }

    public Node<T> getTail(){
        Node<T> curr = head;
        Node<T> tail;
        while (curr.getNext() != null)
            curr = curr.getNext();
        tail = curr;
        return tail;
    }
    public void reverse() {
        Node<T> curr = head, prev = null;
        Node<T> tail = getTail();
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
    private Node<T> reverseRecursive(Node<T> curr, Node<T> prev) {
        if (curr == null) {
            return prev;
        }

        Node<T> next = curr.getNext();
        curr.setNext(prev);
        return reverseRecursive(next, curr);
    }
}
