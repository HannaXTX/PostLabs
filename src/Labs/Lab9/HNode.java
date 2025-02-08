package Labs.Lab9;

public class HNode<T extends Comparable<T>> {

    private T data;
    private char key;

    public HNode() {
        setData(null);
        setKey('E');
    }

    public HNode(T data, char key) {
        setData(data);
        setKey(key);
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


    public char getKey() {   // (E)Empty (F)Full (D)Deleted
        return key;
    }

    public void setKey(char key) {
        this.key = key;
    }
}
