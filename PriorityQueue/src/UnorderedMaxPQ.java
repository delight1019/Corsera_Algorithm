public class UnorderedMaxPQ<Key extends Comparable<Key>> {
    private Key[] priorityQueue;
    private int N;

    public UnorderedMaxPQ(int capacity) {
        priorityQueue = (Key[]) new Comparable[capacity];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void insert(Key x) {
        priorityQueue[N++] = x;
    }

    public Key deleteMax() {
        int max = 0;

        for (int i = 1; i < N; i++) {
            if (less(max, i)) {
                max = i;
            }
        }

        exchange(max, N - 1);

        return priorityQueue[--N];
    }

    private boolean less(int p, int q) {
        return priorityQueue[p].compareTo(priorityQueue[q]) < 0;
    }

    private void exchange(int p, int q) {
        Key swap = priorityQueue[p];
        priorityQueue[p] = priorityQueue[q];
        priorityQueue[q] = swap;
    }
}
