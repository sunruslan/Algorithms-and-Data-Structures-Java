import java.util.Iterator;
public class ResizingArrayStack <Item> implements Iterable<Item> {

    private Item[] arr;
    private int size = 0;

    public ResizingArrayStack (int cap) {
        arr = (Item[]) new Object[cap];
    }

    public void resize (int newSize) {
        Item[] temp = (Item[]) new Object[newSize];
        System.arraycopy(arr, 0, temp, 0, size);
        arr = temp;
    }

    public void push (Item a) {
        if (size == arr.length) {
            resize(2 * arr.length);
        }
        arr[size++] = a;
    }

    public Item pop () {
        Item res = arr[--size];
        arr[size] = null;
        if (size < arr.length / 4) {
            resize(arr.length / 2);
        }
        return res;
    }

    public int getSize () {
        return size;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<Item> {
        private int i = size;

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public Item next() {
            return arr[--i];
        }

        @Override
        public void remove() {}
    }
}
