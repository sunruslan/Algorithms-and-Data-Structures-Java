public class MaxPriorityQueue <Key extends Comparable<Key>> {
    private Key[] pq;
    private int size = 0;
    MaxPriorityQueue (int maxSize) {
        pq = (Key[]) new Comparable[maxSize+1];
    }
    private boolean less (int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }
    private void exch (int i, int j) {
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }
    private void swim (int k) {
        while (k > 1 && less(k/2, k)) {
            exch(k, k/2);
            k /= 2;
        }
    }
    private void sink (int k) {
        while (2*k <= pq.length) {
            int j = 2*k;
            if (j < pq.length && less(j, j+1)) {
                ++j;
            }
            if (less(j, k)) {
                break;
            }
            exch(j, k);
            k = j;
        }
    }
    public boolean isEmpty () {
        return size == 0;
    }
    public int getSize () {
        return size;
    }
    public void insert (Key a) {
        pq[++size] = a;
        sink(size);
    }
    public Key delMax () {
        Key max = pq[1];
        exch(1, size--);
        pq[size+1] = null;
        sink(1);
        return max;
    }

}
