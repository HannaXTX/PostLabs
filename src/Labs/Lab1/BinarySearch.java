package Labs.Lab1;

import java.util.Arrays;
import java.util.Random;

public class BinarySearch {

    public static void main(String[] args) {
        int[] array = new int[10];
        Random random = new Random();


        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(10);
        }
        Arrays.sort(array);
        for (int i = 0; i < array.length; i++) {

            System.out.println("Index " + i + " has number  " + array[i]);
        }

        System.out.println(binarySearch(array, 5, 0, array.length - 1));
    }

    public static int binarySearch(int[] array, int key, int i, int j) {
        int middle = (i + j) / 2;
        if (i <= j) {


            if (key < array[middle])
                return binarySearch(array, key, i, middle - 1);

             else if (key > array[middle])
                return binarySearch(array, key, middle + 1, j);

             else
                return middle;


        }

        return -1;
    }

}

