import java.util.Random;
import java.util.concurrent.ConcurrentMap;

public class Quick3way {
    static Random random = new Random();
    private static void sort(Comparable[] a) {
        sort(a, 0, a.length-1);
    }
    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int lt = lo, i = lo+1, gt = hi;
        Comparable v = a[lo];
        while (i <= gt) {
            int cmp = v.compareTo(a[i]);
            if (cmp > 0) {
                exch(a, i++, lt++);
            } else if (cmp < 0) {
                exch(a, gt--, i);
            } else {
                ++i;
            }
        }
        sort(a, lo, lt-1);
        sort(a, gt+1, hi);
    }
    private static boolean less (Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }
    private static void exch (Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
    private static void show (Comparable[] a) {
        for (Comparable e: a) {
            System.out.print(e + " ");
        }
        System.out.println();
    }
    private static boolean isSorted (Comparable[] a) {
        for (int i = 1; i < a.length; ++i) {
            if (less(a[i], a[i-1])) {
                return false;
            }
        }
        return true;
    }
    public static void main (String[] args) {
        int N = 10;
        Integer[] arr = new Integer[N];
        for (int i = 0; i < N; ++i) {
            arr[i] = random.nextInt(100);
        }
        show(arr);
        sort(arr);
        System.out.println("sorted: " + (isSorted(arr)?"true":"false"));
        show(arr);
    }
}