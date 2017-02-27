package benchmark;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Benchmark {

    public static final int TEN_THOUSAND = 10000;
    public static final int MILLION = 1000000;
    public static final int TEN_MILLIONS = 10000000;


    public long arrayListTest(int numberOfElements, int numberOfRepeats) {
        long amount = 0;
        for (int j = 0; j < numberOfRepeats; j++) {
            List<Integer> arrayList = new ArrayList<>();
            long startTime = System.currentTimeMillis();
            for (int i = 0; i < numberOfElements; i++) {
                arrayList.add(ThreadLocalRandom.current().nextInt(0, 100));
            }
            long stopTime = System.currentTimeMillis();
            amount += stopTime - startTime;
        }
        return amount / numberOfRepeats;
    }

    public long linkedListTest(int numberOfElements, int numberOfRepeats) {
        long amount = 0;
        for (int j = 0; j < numberOfRepeats; j++) {
            List<Integer> linkedList = new LinkedList<>();
            long startTime = System.currentTimeMillis();
            for (int i = 0; i < numberOfElements; i++) {
                linkedList.add(ThreadLocalRandom.current().nextInt(0, 100));
            }
            long stopTime = System.currentTimeMillis();
            amount += stopTime - startTime;
        }
        return amount / numberOfRepeats;
    }


    public static void main(String[] args) {
        Benchmark benchmark = new Benchmark();

        System.out.println("Array List\n----------------");
        System.out.printf("%s: %7dms\n", TEN_THOUSAND ,benchmark.arrayListTest(TEN_THOUSAND, 5));
        System.out.printf("%s: %5dms\n", MILLION ,benchmark.arrayListTest(MILLION, 5));
        System.out.printf("%s: %4dms\n", TEN_MILLIONS ,benchmark.arrayListTest(TEN_MILLIONS, 5));
        System.out.println();

        System.out.println("Linked List\n---------------");
        System.out.printf("%s: %7dms\n", TEN_THOUSAND , benchmark.linkedListTest(TEN_THOUSAND, 5));
        System.out.printf("%s: %5dms\n", MILLION ,benchmark.linkedListTest(MILLION, 5));
        System.out.printf("%s: %3dms\n", TEN_MILLIONS ,benchmark.linkedListTest(TEN_MILLIONS, 5));
    }
}