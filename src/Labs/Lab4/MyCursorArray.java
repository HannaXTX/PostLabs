package Labs.Lab4;

public class MyCursorArray<T extends Comparable<T>> {
    CNode<T>[] cursorArray;

    private final int size;

    public MyCursorArray(int size) {
        this.size = size;
        this.cursorArray = new CNode[size];
        initialization();
    }

    public int initialization() {
        for (int i = 0; i < cursorArray.length - 1; i++)
            cursorArray[i] = new CNode<>(null, i + 1);
        cursorArray[cursorArray.length - 1] = new CNode<>(null, 0);
        return 0;
    }

    public int malloc() {
        int p = cursorArray[0].getNext();
        cursorArray[0].setNext(cursorArray[p].getNext());
        return p;
    }

    public void free(int p) {
        cursorArray[p] = new CNode<T>(null, cursorArray[0].getNext());
        cursorArray[0].setNext(p);
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

    public int createList() {
        int l = malloc();
        if (l == 0)
            System.out.println("Error: Out of space!!!");
        else
            cursorArray[l] = new CNode("-", 0);
        return l;
    }

    public int lengthItr(int l) {
        int count = 0;
        while (!isNull(l) && !isEmpty(l)) {
            l = cursorArray[l].getNext();
            count++;
        }
        return count;
    }

    public int lengthRec(int l) {
        return lengthRec(l, 0);
    }

    private int lengthRec(int l, int count) {
        if (cursorArray[l].getNext() == 0) {
            return count;
        }
        return 1 + lengthRec(cursorArray[l].getNext(), count++);
    }

    public void insert(T data, int l) {

        int p = malloc();

        if (isNull(l)) // list not created
            return;


        int move = 0;
        if (p != 0) {
            int begin;
            int next = cursorArray[l].getNext();
            begin = next;
            next = cursorArray[next].getNext();
            cursorArray[p] = new CNode<>(data, 0);
            if (isEmpty(l)) {
                System.out.println("empty list!.... adding");
                cursorArray[l].setNext(p);
                return;
            }

            while ((cursorArray[next].getData() != null) && (cursorArray[l].getNext() != 0) && (cursorArray[next].getData().compareTo(cursorArray[p].getData()) < 0)) {
                begin = next;
                next = cursorArray[next].getNext();

                move++;
            }
            if (move == 0 && cursorArray[p].getData().compareTo(cursorArray[begin].getData()) <= 0) {
                cursorArray[p] = new CNode<>(data, cursorArray[l].getNext());
                cursorArray[l].setNext(p);
            } else if ((cursorArray[next].getData() == null) && (cursorArray[p].getData().compareTo(cursorArray[begin].getData()) >= 0)) {
                cursorArray[begin].setNext(p);
                cursorArray[p] = new CNode<>(data, 0);
            } else {

                cursorArray[begin].setNext(p);
                cursorArray[p].setNext(next);
            }

        } else
            System.out.println("Error: Out of space!!!");
    }


    public void insertAtHead(T data, int l) {
        if (isNull(l)) // list not created
            return;
        int p = malloc();
        if (p != 0) {
            cursorArray[p] = new CNode(data, cursorArray[l].getNext());
            cursorArray[l].setNext(p);
        } else
            System.out.println("Error: Out of space!!!");
    }

    public void insertAtLast(T data, int l) {
        int p = malloc();
        if (p != 0) {
            while (cursorArray[l].getNext() != 0) {
                l = cursorArray[l].getNext();
            }
            cursorArray[l].setNext(p);
            cursorArray[p] = new CNode<T>(data, 0);
            System.out.println("INSERTING" + cursorArray[p] + " to " + cursorArray[l].getNext());
        } else
            System.out.println("Error: Out of space!!!");
    }

    public void insertLastRec(T data, int l) { // could be done differently
        // using isLast();
        int p = malloc();
        if (p != 0) {
            if (cursorArray[l].getNext() != 0) {
                insertLastRec(data, cursorArray[l].getNext());
            } else {
                cursorArray[l].setNext(p);
                cursorArray[p] = new CNode<T>(data, 0);
            }

        } else
            System.out.println("Error: Out of space!!!");
    }

    public void traversList(int l) {
        System.out.print("list " + (l) + "-->");
        while (!isNull(l) && !isEmpty(l)) {
            l = cursorArray[l].getNext();
            System.out.print(cursorArray[l] + "-->");
        }
        System.out.println("null");
    }

    public void traverseListRecursive(int l) {
        traverseListRecursive(l, 0);
    }

    private void traverseListRecursive(int l, int node) {
        System.out.print("list_" + l + "-->");
        if (isNull(l) && isEmpty(l)) {
            System.out.println("null");
        }
        traverseListRecursive(cursorArray[l].getNext(), cursorArray[node].getNext());
        System.out.print(cursorArray[l] + "-->");
    }

    public int find(T data, int l) {
        while (!isNull(l) && !isEmpty(l)) {
            l = cursorArray[l].getNext();
            if (cursorArray[l].getData().equals(data))
                return l;
        }
        return -1; // not found
    }

    public int findPrevious(T data, int l) {
        while (!isNull(l) && !isEmpty(l)) {
            if (cursorArray[cursorArray[l].getNext()].getData().equals(data))
                return l;
            l = cursorArray[l].getNext();
        }
        return -1; // not found
    }

    public CNode<T> delete(T data, int l) {
        int p = findPrevious(data, l);
        if (p != -1) {
            int c = cursorArray[p].getNext();
            CNode<T> temp = cursorArray[c];
            cursorArray[p].setNext(temp.getNext());
            free(c);
        }
        return null;
    }

    public CNode<T> deletefirst(int l) {
        int p = cursorArray[l].getNext();
        if (p != -1) {
            int c = cursorArray[p].getNext();
            CNode<T> temp = cursorArray[c];
            cursorArray[p].setNext(temp.getNext());
            free(c);
        }
        return null;
    }

    public CNode<T> deleteLast(int l) {
        int current = l;
        int previous = l;

        while (!isNull(l)) {
            if (cursorArray[current].getNext() == 0) {
                free(current);
                cursorArray[previous].setNext(0);

                return cursorArray[current];
            }

            previous = current;
            current = cursorArray[current].getNext();
        }

        return null;
    }

    public void clearlecturemethod(int l) {
        while (!isEmpty(l)) {
            int p = cursorArray[l].getNext();
            cursorArray[l].setNext(cursorArray[p].getNext());
            free(p);
        }
    }

    public void clearlecturemethodREC(int l) {
        while (!isEmpty(l)) {
            int p = cursorArray[l].getNext();
            cursorArray[l].setNext(cursorArray[p].getNext());
            free(p);
            clearlecturemethodREC(l);
        }
    }

    public void merge(int l1, int l2) {
        while (!isLast(l1)) {
            l1 = cursorArray[l1].getNext();
        }
        cursorArray[l1].setNext(cursorArray[l2].getNext());


    }

    public void mergeSorted(int l1, int l2) {
            merge(l1,l2);

    }
    public void sort(int l1){ // not working //////////////////////////
        int org = l1;
        CNode<T> min = cursorArray[cursorArray[l1].getNext()];
        int begin = cursorArray[l1].getNext();
        int next = cursorArray[begin].getNext();
        while (cursorArray[l1].getData() != null) {

            System.out.println((cursorArray[begin].getData().compareTo(cursorArray[next].getData()) > 0));
            System.out.println((cursorArray[begin].getData()+" "+cursorArray[next].getData()));
            if (cursorArray[begin].getData().compareTo(cursorArray[next].getData()) > 0) {
                min.setNext(next);
                cursorArray[next].setNext(begin);
                l1 = org;

            }
            else {
                System.out.println("smaller moving");
                begin=next;
                next=cursorArray[next].getNext();
                l1 = cursorArray[l1].getNext();
            }



        }
    }

    public void clear(int l) {
        while (!isEmpty(l)) {
            deletefirst(l);
        }
        cursorArray[l].setNext(0);

    }

    public void remove(int l) {
        clear(l);
        free(l);
    }

    public void displayLIST() {
        System.out.println("DATA    NEXT    INDEX");
        for (int i = 0; i < size; i++) {
            System.out.println(cursorArray[i].getData() + "     " + cursorArray[i].getNext() + "        " + i);
        }


    }
}

// Unused debugs

// System.out.println("ALLOCATING MEMORY "+p);

//                System.out.println(cursorArray[begin].getData() + "    " + cursorArray[next].getData());
//  System.out.println(" " + (cursorArray[next].getData() != null) + "  " + (cursorArray[l].getNext() != 0) + " ");
//         System.out.println("moving.... " + move+" "+cursorArray[begin].getNext()+" "+cursorArray[next].getNext());
//  System.out.println("INSERTED FIRST "+cursorArray[p].getData());
//   System.out.println("INSERT LAST "+cursorArray[p].getData()+"  to "+cursorArray[next].getData());

//     System.out.println((cursorArray[cursorArray[next].getNext()].getNext() == 0)+" "+(cursorArray[p].getData().compareTo(cursorArray[next].getData())>=0));
//  System.out.println("INSERT BETWEEN "+cursorArray[p].getData());
// System.out.println(" insert between "+cursorArray[begin]+" "+cursorArray[next]);
// System.out.println(" insert between "+cursorArray[p]+" "+cursorArray[p].getNext());
