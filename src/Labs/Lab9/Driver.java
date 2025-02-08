package Labs.Lab9;

public class Driver {
    public static void main2(String[] args) {
        SHash<Integer> hashtable = new SHash<>(10);



        hashtable.add(0);
        hashtable.add(1);
        hashtable.add(2);
        hashtable.add(3);
        hashtable.add(4);
        hashtable.add(5);
        hashtable.add(6);
        hashtable.add(7);
        hashtable.add(8);
        hashtable.add(18);
        hashtable.add(28);
        hashtable.add(38);
        hashtable.traverse();


    }

    public static void main(String[] args) {
        OHash<Integer> hashtable = new OHash<>(5);

//        hashtable.addLinear(5);
//        hashtable.addLinear(5);
//        hashtable.addLinear(5);
//        hashtable.addLinear(5);
//        hashtable.addLinear(5);
//        hashtable.addLinear(5);
//        hashtable.addLinear(1);
//        hashtable.addLinear(1);



        hashtable.addQuadratic(5);
        hashtable.addQuadratic(5);
        hashtable.addQuadratic(5);
        hashtable.addQuadratic(5);






        hashtable.traverse();



    }


}
