package Labs.Lab3;

public class DNode<T extends Comparable<T>> {

    private T data;
    private DNode<T> next,prev;

    public DNode<T> getPrev() {
        return prev;
    }

    public void setPrev(DNode<T> prev) {
        this.prev = prev;
    }





    public DNode(T data) {
        setData(data);
        setNext(null);
        setPrev(null);

    }

    public void setData(T data) {
        this.data = data;
    }

    public void setNext(DNode<T> next) {
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public DNode<T> getNext() {
        return next;
    }


}
