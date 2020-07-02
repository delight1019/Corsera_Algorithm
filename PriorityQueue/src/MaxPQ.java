public class MaxPQ<Key extends Comparable<Key>> {
    private Key[] priorityQueue;
    private int N;

    public MaxPQ(int capacity) {
        priorityQueue = (Key[]) new Comparable[capacity + 1];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void insert(Key key) {
        priorityQueue[++N] = key;
        swim(N);
    }

    public Key deleteMax() {
        Key max = priorityQueue[1];
        exchange(1, N--);
        sink(1);
        priorityQueue[N+1] = null;
        return max;
    }

    private void swim(int k) {
        while (k > 1 && less(k/2, k)) {
            exchange(k , k/2);
            k = k / 2;
        }
    }

    private void sink(int k) {
        while (2 * k  <= N) {
            int j = 2 * k;

            if (j < N && less(j, j+1)) {
                j++;
            }

            if (!less(k, j)) {
                break;
            }

            exchange(k, j);
            k = j;
        }
    }

    private boolean less(int i, int j) {
        return priorityQueue[i].compareTo(priorityQueue[j]) < 0;
    }

    private void exchange(int i, int j) {
        Key swap = priorityQueue[i];
        priorityQueue[i] = priorityQueue[j];
        priorityQueue[j] = swap;
    }
}
