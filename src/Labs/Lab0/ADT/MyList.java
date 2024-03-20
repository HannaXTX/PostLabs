package ADT;

import Labs.Lab0.ADT.Listable;

public class MyList<T extends Comparable<T>> implements Listable<T> {

    int count;
    private T[] list;

    public MyList() {
        this.list = (T[]) new Comparable[0];
        count = 0;

    }


    public MyList(int size) {
        this.list = (T[]) new Comparable[size];
        count = 0;

    }

    public void add(T arr) {
        if (count >= list.length) {
            resize();

        }
        list[count] = arr;
        count++;

    }

    public boolean remove(T arr) {
        if (arr != null) {
            for (int i = 0; i < count; i++) {

                if (arr.compareTo(list[i]) == 0) {
                    for (int j = i + 1; j < count; j++) {
                        list[j - 1] = list[j];

                    }
                    System.out.println("Entry Deleted!");

                    count--;

                    return true;
                }
            }
        }
        return false;
    }

    public boolean find(T arr) {
        if (arr != null) {

            for (int i = 0; i < count; i++) {
                if (arr.compareTo(returnList()[i]) == 0) {
                    return true;
                }

            }
        }
        return false;
    }

    public void clear() {
        count = 0;

    }

    public boolean isEmpty() {

        return count == 0;
    }

    public int size() {

        return count;
    }

    public void traverse() {
        System.out.println("index\tdata");
        for (int i = 0; i < count; i++) {
            System.out.println(i + "       " + list[i].toString());
        }
    }


    public T get(int index) {

        return list[index];

    }

    public void set(int index,T type){
        list[index]=type;
    }

    public T[] returnList() {
        return list;
    }

    public void resize() {
        T[] newList = (T[]) new Comparable[list.length * 2];
        System.arraycopy(list, 0, newList, 0, count);
        list = newList;
        System.out.println("Resizing....from " + count + " to " + list.length);
    }




}