import java.util.Iterator;

public class Bag<Item> implements Iterable<Item> {
    private Node first;
    private int size = 0;
    private class Node {
        Item item;
        Node next;
    }

    public int getSize() {
        return size;
    }
    public void add (Item a) {
        Node oldFirst = first;
        first = new Node();
        first.item = a;
        first.next = oldFirst;
        ++size;
    }

    @Override
    public Iterator<Item> iterator() {
        return new BagIterator();
    }
    private class BagIterator implements Iterator<Item>{
        private Node current = first;
        @Override
        public Item next() {
            Item res = current.item;
            current = current.next;
            return res;
        }

        @Override
        public void remove() {

        }

        @Override
        public boolean hasNext() {
            return current != null;
        }
    }
}
