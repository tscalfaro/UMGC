package project_1;

public abstract class AbstractSort {

	private long startTime;
    private long endTime;
    private int counter;

    public AbstractSort() {
        this.counter = 0;
    }

    public abstract void sort(int[] arr) throws UnsortedException;

    protected void startSort() {
        counter = 0;
        startTime = System.currentTimeMillis();
    }

    protected void endSort() {
        endTime = System.currentTimeMillis();
    }

    protected void incrementCount() {
        counter++;
    }

    public int getCount() {
        return counter;
    }

    public long getTime() {
        return endTime - startTime;
    }
    
    protected void verifySorted(int[] arr) throws UnsortedException {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                throw new UnsortedException("Array is not sorted at index " + i);
            }
        }
    }
}
