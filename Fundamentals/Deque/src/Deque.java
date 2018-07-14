import java.util.Iterator;

public class Deque<Item> implements Iterable<Item> {
    private Node left = null;
    private Node right = null;
    private int size = 0;

    private class Node {
        Item item;
        Node left;
        Node right;
    }
    public boolean isEmpty () {
        return left == null;
    }
    public int getSize () {
        return size;
    }
    public void pushLeft (Item a) {
        Node oldLeft = left;
        left = new Node();
        left.item = a;
        left.left = null;
        if (isEmpty()) {
            right = left;
        } else {
            left.right = left;
        }
        ++size;
    }
    public void pushRight (Item a) {
        Node oldRight = right;
        right = new Node();
        right.item = a;
        right.right = null;
        if (isEmpty()) {
            left = right;
        } else {
            right.left = oldRight;
        }
        ++size;
    }
    public Item popLeft () {
        Item item = left.item;
        left = left.right;
        if (isEmpty()) {
            right = null;
        }
        return item;
    }
    public Item popRight () {
        Item item = right.item;
        right = right.left;
        if (isEmpty()) {
            left = null;
        }
        return item;
    }
    @Override
    public Iterator<Item> iterator() {
        return new DequeIterator();
    }
    private class DequeIterator implements Iterator<Item> {
        private Node current = left;
        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public void remove() {

        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.right;
            return item;
        }
    }
}
