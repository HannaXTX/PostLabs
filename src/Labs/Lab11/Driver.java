package Labs.Lab11;

import java.util.Arrays;
import java.util.Random;


public class Driver {

    public static void main(String[] args) {

        Random r = new Random();

        int[] array = new int[1000000];
        for (int i = 0; i < array.length; i++) {
            array[i] = r.nextInt(500);
        }

        int[] array2 = new int[1000000];
        for (int i = 0; i < array2.length; i++) {
            array2[i] = r.nextInt(500);
        }

        long tempH = System.currentTimeMillis();

        System.out.println("Insertion Sort took " + (System.currentTimeMillis() - tempH) + "ms");


        System.out.println("Shell Sort took " + (System.currentTimeMillis() - tempH) + "ms");


        long tempM = System.currentTimeMillis();
        mergeSort(array, 0, array.length);
        System.out.println("Merge Sort took " + (System.currentTimeMillis() - tempM) + "ms");

        long tempQ = System.currentTimeMillis();
        Arrays.sort(array2);
        System.out.println("Arrays Sort took " + (System.currentTimeMillis() - tempM) + "ms");
    }

    static void mergeSort(int[] array, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(array, start, mid);
            mergeSort(array, mid + 1, end);
            merge(array, start, mid, end - 1);
        }
    }

    static void merge(int[] array, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];
        int i = start, j = mid + 1, k = 0;

        while (i <= mid && j <= end) {
            if (array[i] <= array[j]) {
                temp[k] = array[i];
                k += 1;
                i += 1;
            } else {
                temp[k] = array[j];
                k += 1;
                j += 1;
            }
        }

        while (i <= mid) {
            temp[k] = array[i];
            k += 1;
            i += 1;
        }

        while (j <= end) {
            temp[k] = array[j];
            k += 1;
            j += 1;
        }

        for (i = start; i <= end; i += 1) {
            array[i] = temp[i - start];
        }
    }

    public static void shellSort(Comparable[] a) {
        int N = a.length;
        int h = 1;
        while (h < N / 3) {
            h = 3 * h + 1;
            while (h >= 1) {
                for (int i = h; i < N; i++) {
                    for (int j = i; j >= h && a[j].compareTo(a[j - h]) < 0; j -= h) {
                        Comparable temp = a[j];
                        a[j] = a[j - h];
                        a[j - h] = temp;

                    }
                }
            }
        }
    }


}