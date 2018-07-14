import java.util.Random;

public class Shell {
    static Random random = new Random();
    public static void sort(Comparable[] a) {
        int h = 1;
        while (h < a.length) {
            h = 3*h + 1;
        }
        while (h >= 1) {
            for (int i = h; i < a.length; ++i) {
                for (int j = i; j >= h && less(a[j], a[j-h]); j -= h) {
                    exch(a, j, j-h);
                }
            }
            h /= 3;
        }
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
    public static boolean isSorted (Comparable[] a) {
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
