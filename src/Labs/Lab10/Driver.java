package Labs.Lab10;

import java.util.Scanner;
import java.util.Random;

public class Driver {

    public static void main(String[] args) {

        MaxHeap<Character> heap = new MaxHeap<>(12);


//        traverseArray(randomNumbers);
//
//        MaxHeap.maxHeapify(randomNumbers);
//        traverseArray(randomNumbers);
//
//
//        MaxHeap.heapSortAsc(randomNumbers);
//        traverseArray(randomNumbers);


                Integer[] a = new Integer[12];
        fillArrayWithRandomNumbers(a);

        for (int i = 1; i < a.length; i++)
            System.out.print(a[i] + " ");
        System.out.println();

        System.out.println("MaxHeap? " + MaxHeap.isMaxHeap(a));
        System.out.println("MinHeap? " + MinHeap.isMinHeap(a));

        MaxHeap.maxHeapify(a);
        System.out.println("AFTER RUNNING MAX HEAPIFY");
        for (int i = 1; i < a.length; i++)
            System.out.print(a[i] + " ");
        System.out.println();

        System.out.println("MaxHeap? " + MaxHeap.isMaxHeap(a));
        System.out.println("MinHeap? " + MinHeap.isMinHeap(a));

        MinHeap.minHeapify(a);
        System.out.println("AFTER RUNNING MIN HEAPIFY");
        for (int i = 1; i < a.length; i++)
            System.out.print(a[i] + " ");
        System.out.println();

        System.out.println("MaxHeap? " + MaxHeap.isMaxHeap(a));
        System.out.println("MinHeap? " + MinHeap.isMinHeap(a));

        MaxHeap.heapSortAsc(a);
        for (int i = 1; i < a.length; i++)
            System.out.print(a[i] + " ");
        System.out.println();

        MinHeap.heapSortDesc(a);
        for (int i = 1; i < a.length; i++)
            System.out.print(a[i] + " ");
        System.out.println();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter characters to add to the heap (enter 'Z' to end):");

        while (true) {
            System.out.print("Enter a character: ");
            String input = scanner.nextLine().toUpperCase(); // Convert input to uppercase

            if (input.length() != 1) {
                System.out.println("Please enter a single character.");
                continue;
            }

            char ch = input.charAt(0);

            if (ch == 'Z') {
                break;
            }

            heap.add(ch);
            heap.traverse();
        }

        scanner.close();
    }

    public static void fillArrayWithRandomNumbers(Integer[] array) {
        Random random = new Random(1);
        for (int i = 1; i < array.length; i++) {
            array[i] = 1+ random.nextInt(10); // Generates a random number between 0 and 99
        }
    }


    public static void traverseArray(Integer[] array) {
        System.out.println("Array elements: ");
        for (int i = 0; i< array.length ; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (Integer number : array) {
            System.out.print(number + " ");
        }
        System.out.println();
    }

}







