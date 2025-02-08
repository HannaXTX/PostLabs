package Labs.Lab6;


public class LinkedQueue<T extends Comparable<T>> {
    private Node<T> front, back;


    public void enqueue(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty())
            front = newNode;
        else
            back.setNext(newNode);
        back = newNode;
    }


    public T dequeue() {
        T temp = getFront();
        if (!isEmpty())
            front = front.getNext();
        if (front == null)
            back = null;
        return temp;

    }


    public T getFront() {
        if (!isEmpty())
            return front.getData();
        return null;
    }


    public boolean isEmpty() {
        return (front == null) && (back == null);
    }


    public void clear() {
        front = null;
        back = null;
    }

}