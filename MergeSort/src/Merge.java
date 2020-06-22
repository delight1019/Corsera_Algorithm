public class Merge {
    private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
        assert isSorted(a, lo, mid);
        assert isSorted(a, mid + 1, hi);

        int i = lo;
        int j = mid + 1;

        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                aux[k] = a[j++];
            }
            else if (j > hi) {
                aux[k] = a[i++];
            }
            else if (less(a[j], a[i])) {
                aux[k] = a[j++];
            }
            else {
                aux[k] = a[i++];
            }
        }

        assert isSorted(aux, lo, hi);
    }

    private static boolean isSorted(Comparable[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++) {
            if (less(a[i], a[i-1])) {
                return false;
            }
        }

        return true;
    }

    private static boolean less(Comparable w, Comparable v) {
        return w.compareTo(v) < 0;
    }

    private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
        final int CUTOFF = 1;

        if (hi <= lo + CUTOFF - 1) {
            //Insertion.sort(a, lo, hi);
            return;
        }

        int mid = lo + (hi - lo) / 2;

        sort(aux, a, lo, mid);
        sort(aux, a, mid + 1, hi);

        if (!less(a[mid + 1], a[mid])) {
            return;
        }

        merge(a, aux, lo, mid, hi);
    }

    public static void sort(Comparable[] a) {
        Comparable[] aux = new Comparable[a.length];
        sort(a, aux, 0, a.length - 1);
    }
}
