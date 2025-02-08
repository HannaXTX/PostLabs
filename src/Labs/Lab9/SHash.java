package Labs.Lab9;

public class SHash<T extends Comparable<T>> {

    SingleLinkedList<T>[] table;
    int index;


    public SHash(int size) {
        initialization(size);
    }


    public void initialization(int size) {
        table = new SingleLinkedList[size];
        for (int i = 0; i < table.length; i++) {
            table[i] = new SingleLinkedList<>();
        }
    }

    public void add(T data) {
        index = Math.abs(data.hashCode()) % table.length;
        if (table[index] != null) {
            table[index].insertFirst(data);
        }
    }

    public void delete(T data) {
        index = Math.abs(data.hashCode()) % table.length;
        if (table[index].findUnsorted(data) != null) {
            table[index].delete(data);
        }

    }

    public T find(T data) {
        index = Math.abs(data.hashCode()) % table.length;
        if (table[index] != null) {
            return table[index].findUnsorted(data);
        }
        return null;
    }

    public void traverse() {
        for (SingleLinkedList<T> list : table) {
            list.traverse();
        }

    }


}
