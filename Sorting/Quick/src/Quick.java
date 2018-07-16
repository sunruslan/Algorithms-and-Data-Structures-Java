import java.util.Random;

public class Quick {
    static Random random = new Random();
    private static void sort(Comparable[] a) {
        sort(a, 0, a.length-1);
    }
    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int j = partition(a, lo, hi);
        sort(a, lo, j-1);
        sort(a,j+1, hi);
    }
    private static int partition (Comparable[] a, int lo, int hi) {
        Comparable v = a[lo];
        int i = lo, j = hi+1;
        while (i < j) {
            while (less(a[++i], v) && i < hi) {}
            while (less(v, a[--j]) && j > lo) {}
            if (i < j) {
                exch(a, i, j);
            }
        }
        exch(a, lo, j);
        return j;
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
        for (int i = 0; i < a.length; ++i) {
            System.out.print(a[i] + " ");
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
        int N = 30;
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