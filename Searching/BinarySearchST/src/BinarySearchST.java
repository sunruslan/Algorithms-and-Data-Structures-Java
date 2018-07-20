import sun.invoke.empty.Empty;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchST<Key extends Comparable<Key>, Value> {
    private Key[] keys;
    private Value[] vals;
    private int size = 0;
    public BinarySearchST (int capacity) {
        keys = (Key[]) new Comparable[capacity];
        vals = (Value[])new Object[capacity];
    }
    public void put (Key key, Value val) {
        int i = rank(key, 0, size-1);
        if (i < size && keys[i].compareTo(key) == 0) {
            vals[i] = val;
            return;
        }
        for (int j = size; j > i; --j) {
            keys[j] = keys[j-1];
            vals[j] = vals[j-1];
        }
        vals[i] = val;
        keys[i] = key;
        size++;
    }
    public Value get (Key key) {
        if (size == 0) {
            return null;
        }
        int i = rank(key, 0, size-1);
        if (i < size && keys[i].compareTo(key) == 0) {
            return vals[i];
        } else {
            return null;
        }
    }
    public int rank (Key key, int lo, int hi) {
        if (lo > hi) {
            return lo;
        }
        int mid = (hi - lo) / 2;
        int cmp = keys[mid].compareTo(key);
        if (cmp < 0) {
            return rank(key, mid+1, hi);
        } else if (cmp > 0) {
            return rank(key, lo, mid-1);
        } else {
            return mid;
        }
    }
    public boolean isEmpty () {
        return size == 0;
    }
    public boolean isFull () {
        return size == vals.length;
    }
    public boolean contains (Key key) {
        return get(key) != null;
    }
    public Iterable<Key> keys (Key lo, Key hi) {
        List<Key> list = new ArrayList<>();
        for (int i = rank(lo, 0, size-1); i < rank(hi, 0, size-1); ++i) {
            list.add(keys[i]);
        }
        if (contains(hi)) {
            list.add(keys[rank(hi, 0, size-1)]);
        }
        return list;
    }
    public Key min () {
        return keys[0];
    }
    public Key max () {
        return keys[size-1];
    }
    public Key select (int k) {
        return keys[k];
    }
    public Key floor (Key key) {
        return keys[rank(key, 0, size-1)];
    }
    public Key ceiling (Key key) {
        if (contains(key)) {
            return key;
        }
        int r;
        if ((r = rank(key, 0, size-1))+1 < size) {
            return keys[r];
        } else {
            return null;
        }
    }
    public boolean deleteMax () {
        return delete(max());
    }
    public boolean deleteMin () {
        return delete(min());
    }
    public boolean delete (Key key) {
        if (isEmpty() && !contains(key)) {
            return false;
        }
        for (int i = rank(key, 0, size-1); i < size-1; ++i) {
            keys[i] = keys[i+1];
            vals[i] = vals[i+1];
        }
        --size;
        return true;
    }
}
