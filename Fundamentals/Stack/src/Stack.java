import java.util.Iterator;

public class Stack<Item> implements Iterable<Item> {
    private Node top;
    private int size = 0;
    private class Node {
        Item item;
        Node next;
    }
    public boolean isEmpty () {
        return size == 0;
    }
    public int getSize () {
        return size;
    }
    public void push (Item a) {
        Node oldTop = top;
        top = new Node();
        top.item = a;
        top.next = oldTop;
        ++size;
    }
    public Item pop () {
        Item item = top.item;
        top = top.next;
        --size;
        return item;
    }
    public Item peek () {
        return top.item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ReverseStackIterator();
    }
    private class ReverseStackIterator implements Iterator<Item>{
        Node first = top;

        @Override
        public Item next() {
            Item item = first.item;
            first = first.next;
            return item;
        }

        @Override
        public boolean hasNext() {
            return first != null;
        }

        @Override
        public void remove() {

        }
    }
}
