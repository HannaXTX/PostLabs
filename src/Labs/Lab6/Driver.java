package Labs.Lab6;

import java.util.Random;

public class Driver {
    static ArrayQueue arrayQueue = new ArrayQueue(120);
    static int size = 0;


    public static void main(String[] args) {


        Random random = new Random();
        int count = 0;
        double average = 0;
        int waiting;
        int process = 0;
        int processed = 0;

        System.out.println("| min | new Customer | process  | waiting time    |   total");

        for (; count < 60 && !arrayQueue.isFull(); count++) {

            if (arrayQueue.isEmpty()) {
                process = 0;
            }
            int chance = random.nextInt(4);
            if (chance == 1) {
                arrayQueue.enqueue(1);
                size++;

            } else if (chance == 2) {
                arrayQueue.enqueue(1);
                arrayQueue.enqueue(1);
                size += 2;
            } else {
                chance = 0;
            }

            if (process == 1) {
                arrayQueue.dequeue();
                size--;
                processed++;
            }
            if (size == 0) {
                waiting = 0;
            } else {
                waiting = size - 1;
                average = waiting + average;
            }
            System.out.printf("| %3d | %12d | %8d | %14dm |  %s%n", count, chance, process, waiting, arrayQueue);

            if (!arrayQueue.isEmpty()) {
                process = 1;
            }
        }
        System.out.printf("average waiting time : %2fm ", average / processed);
    }

    public static String CustomerRun() {

        Random random = new Random();
        int count = 0;
        double average = 0;
        int waiting;
        int process = 0;
        int processed = 0;
        StringBuilder str = new StringBuilder();
        str.append("| min | new Customer | process  | waiting time    |   total\n");

        for (; count < 60 && !arrayQueue.isFull(); count++) {


            if (arrayQueue.isEmpty()) {
                process = 0;
            }
            int chance = random.nextInt(4);
            if (chance == 1) {
                arrayQueue.enqueue(1);
                size++;

            } else if (chance == 2) {
                arrayQueue.enqueue(1);
                arrayQueue.enqueue(1);
                size += 2;
            } else {
                chance = 0;
            }

            if (process == 1) {
                arrayQueue.dequeue();
                size--;
                processed++;
            }
            if (size == 0) {
                waiting = 0;
            } else {
                waiting = size - 1;
                average = waiting + average;
            }
            str.append(String.format("| %5d | %22d | %12d | %18dm |  %s%n", count, chance, process, waiting, arrayQueue));


            if (!arrayQueue.isEmpty()) {
                process = 1;
            }
        }
        str.append(String.format("average waiting time : %2fm ", average / processed));

        return str.toString();

    }

}

