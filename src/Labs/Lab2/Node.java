package Labs.Lab2;

public class Node<T extends Comparable<T>> {

    private T data;
    private Node<T> next;

    public Node(T data) {
        setData(data);
        setNext(null);
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public Node<T> getNext() {
        return next;
    }


}
