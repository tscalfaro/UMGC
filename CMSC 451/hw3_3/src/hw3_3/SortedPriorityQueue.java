package hw3_3;

public class SortedPriorityQueue {
    private int[] array;
    private int size;
    private int capacity;

    public SortedPriorityQueue(int capacity) {
        this.capacity = capacity;
        this.array = new int[capacity];
        this.size = 0;
    }

    public void add(int value) {
        if (size == capacity) {
            throw new RuntimeException("Queue is full");
        }

        int i = size - 1;
        while (i >= 0 && array[i] > value) {
            array[i + 1] = array[i];
            i--;
        }
        array[i + 1] = value;
        size++;
    }

    public int remove() {
        if (size == 0) {
            throw new RuntimeException("Queue is empty");
        }

        int minValue = array[0];

        for (int i = 1; i < size; i++) {
            array[i - 1] = array[i];
        }
        size--;

        return minValue;
    }

    public int peek() {
        if (size == 0) {
            throw new RuntimeException("Queue is empty");
        }
        return array[0];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public int getSize() {
        return size;
    }

    public static void main(String[] args) {
        SortedPriorityQueue pq = new SortedPriorityQueue(5);
        pq.add(4);
        pq.add(1);
        pq.add(3);
        pq.add(5);
        pq.add(2);

        //Comment this out to test adding to full queue exception
//        System.out.println("Removed: " + pq.remove());
//        System.out.println("Removed: " + pq.remove());
//        System.out.println("Removed: " + pq.remove());
//        System.out.println("Removed: " + pq.remove());
//        System.out.println("Removed: " + pq.remove());

        //Uncomment to test exception when adding to a full queue
        pq.add(6); // This should throw a RuntimeException

        // Uncomment to test exception when removing from an empty queue
        //pq.remove(); // This should throw a RuntimeException
    }
}
