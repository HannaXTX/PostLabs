package Labs.Lab4;

public class MyMyCursorArray<T extends Comparable<T>> {

    private final int size;
    CNode<T>[] cursorArray;

    public MyMyCursorArray(int size) {
        this.size = size;
        cursorArray = new CNode[size];
        initialization();
    }

    public void initialization() {
        for (int i = 0; i < size; i++) {
            if (i != size - 1)
                cursorArray[i] = new CNode<>(null, i + 1);

            else cursorArray[i] = new CNode<>(null, 0);

        }
    }

    // To perform a malloc, the first element (after the header) is removed from the freelist:
    public int malloc() {
        int p = cursorArray[0].getNext();
        if (p == 0) System.out.println("List is Full!");
        cursorArray[0].setNext(cursorArray[p].getNext());
        return p;
    }

    // To perform a free, we place the cell at the front of the freelist

    public void free(int address) {
        cursorArray[address] = new CNode<>(null, cursorArray[0].getNext());
        cursorArray[0].setNext(address);
    }

    public boolean isNull(int l) {
        return cursorArray[l] == null;
    }

    public boolean isEmpty(int l) {
        return cursorArray[l].getNext() == 0;
    }

    public boolean isLast(int p) {
        return cursorArray[p].getNext() == 0;
    }

    // To create a new linked list, first you have to allocate one free node using malloc function, then
    //make the next of the new node to 0 as follows:

    public int createList() {
        int l = malloc();

        if (l == 0)
            System.out.println("Out of Space");
        else
            cursorArray[l] = (CNode<T>) new CNode<>("--", 0);
        return l;
    }

    public void insertatHead(T data, int l) {
        if (isNull(l))
            return;
        int p = malloc();
        cursorArray[p] = new CNode<>(data,cursorArray[l].getNext());
        cursorArray[l].setNext(p);
    }

    public void displayLIST() {
        System.out.println("DATA    NEXT    INDEX");
        for (int i = 0; i < size; i++) {
            System.out.println(cursorArray[i].getData() + "     " + cursorArray[i].getNext() + "        " + i);
        }
    }


}
