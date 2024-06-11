/*
 * Created by: Antonio Scalfaro
 * Sourced from: https://www.geeksforgeeks.org/java-program-for-heap-sort/?ref=lbp
 * Project 1 - Sorting benchmarks
 * */


package project_1;

public class HeapSort extends AbstractSort{

	private void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        incrementCount();
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        incrementCount();
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            heapify(arr, n, largest);
        }
    }

	@Override
    public void sort(int[] arr) throws UnsortedException {
        startSort();
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        }
        endSort();
        verifySorted(arr);
    }
}
