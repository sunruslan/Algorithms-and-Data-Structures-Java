import java.util.Iterator;

public class Queue<Item> implements Iterable<Item> {
    private int size = 0;
    private Node first;
    private Node last;
    private class Node {
        Node next;
        Item item;
    }

    public int getSize () {
        return size;
    }
    public boolean isEmpty () {
        return first == null;
    }
    public void enqueue (Item item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
        ++size;
    }
    public Item dequeue () {
        Item res = first.item;
        first = first.next;
        if (isEmpty()) {
            last = null;
        }
        --size;
        return res;
    }

    @Override
    public Iterator<Item> iterator() {
        return new QueueIterator();
    }
    private class QueueIterator implements Iterator<Item>{
        private Node current = first;

        @Override
        public void remove() {

        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            Item res = current.item;
            current = current.next;
            return res;
        }
    }
}
