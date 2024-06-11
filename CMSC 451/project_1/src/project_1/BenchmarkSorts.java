package project_1;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public class BenchmarkSorts {

	private static final int[] DATA_SIZES = {1000, 2000, 3000, 4000, 5000, 6000, 7000, 8000, 9000, 10000, 11000, 12000};
    private static final int NUM_RUNS = 40;
    private static final int WARMUP_RUNS = 10;

    public static void main(String[] args) {
        System.out.println("Current working directory: " + System.getProperty("user.dir"));

        try (FileWriter mergeSortFile = new FileWriter("MergeSortResults.csv");
             FileWriter heapSortFile = new FileWriter("HeapSortResults.csv")) {

            System.out.println("MergeSortResults.csv created at: " + new java.io.File("MergeSortResults.csv").getAbsolutePath());
            System.out.println("HeapSortResults.csv created at: " + new java.io.File("HeapSortResults.csv").getAbsolutePath());

            mergeSortFile.write("DataSize,Comparisons,Time\n");
            heapSortFile.write("DataSize,Comparisons,Time\n");

            Random random = new Random();

            for (int size : DATA_SIZES) {
                warmUp(random, size);

                for (int i = 0; i < NUM_RUNS; i++) {
                    int[] data = random.ints(size, 0, 100000).toArray();

                    int[] dataForMergeSort = Arrays.copyOf(data, data.length);
                    int[] dataForHeapSort = Arrays.copyOf(data, data.length);

                    // MergeSort
                    MergeSort mergeSort = new MergeSort();
                    try {
                        mergeSort.sort(dataForMergeSort);
                    } catch (UnsortedException e) {
                        System.err.println("MergeSort failed: " + e.getMessage());
                    }
                    mergeSortFile.write(size + "," + mergeSort.getCount() + "," + mergeSort.getTime() + "\n");

                    // HeapSort
                    HeapSort heapSort = new HeapSort();
                    try {
                        heapSort.sort(dataForHeapSort);
                    } catch (UnsortedException e) {
                        System.err.println("HeapSort failed: " + e.getMessage());
                    }
                    heapSortFile.write(size + "," + heapSort.getCount() + "," + heapSort.getTime() + "\n");
                }

                System.out.println("Size: " + size + " completed.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private static void warmUp(Random random, int size) {
        int[] dummyData = random.ints(size, 0, 100000).toArray();

        for (int i = 0; i < WARMUP_RUNS; i++) {
            int[] dataForMergeSort = Arrays.copyOf(dummyData, dummyData.length);
            int[] dataForHeapSort = Arrays.copyOf(dummyData, dummyData.length);

            MergeSort mergeSort = new MergeSort();
            try {
                mergeSort.sort(dataForMergeSort);
            } catch (UnsortedException e) {
                System.err.println("Warm-up MergeSort failed: " + e.getMessage());
            }

            HeapSort heapSort = new HeapSort();
            try {
                heapSort.sort(dataForHeapSort);
            } catch (UnsortedException e) {
                System.err.println("Warm-up HeapSort failed: " + e.getMessage());
            }
        }
    }
}
