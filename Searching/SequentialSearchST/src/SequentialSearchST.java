import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class SequentialSearchST<Key extends Comparable<Key>, Value> {
    private Node first;
    private int size = 0;
    private class Node {
        private Value value;
        private Key key;
        private Node next;
        Node (Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
    public boolean isEmpty () {
        return first == null;
    }
    public boolean contains (Key key) {
        return get(key) != null;
    }
    public Value get (Key key) {
        for (Node x = first; x != null; x = x.next) {
            if (x.key.equals(key)) {
                return x.value;
            }
        }
        return null;
    }
    public void put (Key key, Value value) {
        for (Node x = first; x != null; x = x.next) {
            if (x.key.equals(key)) {
                x.value = value;
                return;
            }
        }
        first = new Node(key, value, first);
        ++size;
    }
    public int size () {
        return size;
    }
    public boolean delete (Key key) {
        Node prev = null;
        for (Node x = first; x != null; prev = x, x = x.next) {
            if (x.key.equals(key)) {
                if (prev != null) {
                    if (x.next != null) {
                         prev.next = x.next;
                    } else {
                        prev.next = null;
                    }
                } else {
                    if (x.next != null) {
                        first = x.next;
                    } else {
                        first = null;
                    }
                }
            }
        }
        return false;
    }
    public Iterable<Key> keys () {
        List list = new ArrayList();
        for (Node x = first; x != null; x = x.next) {
            list.add(x.key);
        }
        return list;
    }
}
