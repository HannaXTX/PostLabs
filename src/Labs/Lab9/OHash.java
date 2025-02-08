package Labs.Lab9;

import java.security.spec.RSAOtherPrimeInfo;

public class OHash<T extends Comparable<T>> {   // OPEN ADDRESSING

    HNode<T>[] table;
    int index;
    int size;


    public OHash(int size) {
        initialization(size);

    }


    public void initialization(int size) {
        int m = size * 2;
        table = new HNode[m];
        for (int i = 0; i < table.length; i++) {
            table[i] = new HNode<>();
        }
    }


    public void addLinear(T data) {
        index = Math.abs(data.hashCode()) % table.length;
        for (int i = 0; i < table.length; i++) {
            int newIndex = linearHashFunction(index, i);
            if (table[newIndex].getKey() == 'E' || table[newIndex].getKey() == 'D') {
                table[newIndex].setData(data);
                table[newIndex].setKey('F');
                return;
            }

        }
        System.out.println("Table is Full");
    }


    public void addQuadratic(T data) {
        index = Math.abs(data.hashCode()) % table.length;
        for (int i = 0; i < table.length; i++) {
            int newIndex = quadraticHashFunction(index, i);
            if (table[newIndex].getKey() == 'E' || table[newIndex].getKey() == 'D') {
                table[newIndex].setData(data);
                table[newIndex].setKey('F');
                return;
            }
            //  System.out.println(index);

        }
        System.out.println("Table is Full");
    }


    public void addDoubleHash(T data) {
        int h1 = Math.abs(data.hashCode()), h2 = 19 - Math.abs((data.hashCode())%19);
        for (int i = 0; i < table.length; i++) {
            int newIndex = doubleHashFunction(h1, h2, i);
            if (table[newIndex].getKey() == 'E' || table[newIndex].getKey() == 'D') {
                table[newIndex].setData(data);
                table[newIndex].setKey('F');
                return;
            }
            //  System.out.println(index);

        }
        System.out.println("Table is Full");
    }


    public void delete(T data) {
        index = Math.abs(data.hashCode()) % table.length;
        for (int i = index; i < table.length; i++) {
            if (table[index].getData() == data) {
                table[index].setKey('D');
                return;
            }
        }
    }

    public T find(T data) {
        index = Math.abs(data.hashCode()) % table.length;
        for (int i = index; i < table.length; i++) {
            if (table[index].getData() == data) {
                return table[index].getData();
            }
        }
        return null;
    }

    public int linearHashFunction(int index, int i) {
        return i == 0 ? index : (index + i) % table.length;
    }


    public int doubleHashFunction(int h1, int h2, int i) {

        return i == 0 ? h1 % table.length : (h1 + i * h2) % table.length;
    }

    public int quadraticHashFunction(int index, int i) {
        return i == 0 ? index : (int) (index + Math.pow(i, 2)) % table.length;
    }

    public void traverse() {
        for (int i = 0; i < table.length; i++) {
            System.out.println(i + "  " + table[i].getData());
        }

    }
}
