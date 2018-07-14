public class RingBuffer<Item> {
    private int available = 0;
    private int writePos = 0;
    Item[] arr;
    RingBuffer (int cap) {
        arr = (Item[]) new Object[cap];
        available = cap;
    }
    public int getAvailable() {
        return available;
    }
    public int getCapacity() {
        return arr.length;
    }
    public boolean isFull () {
        return available == arr.length;
    }
    public boolean isEmpty () {
        return available == 0;
    }
    public void push (Item a) {
        if (!isFull()) {
            arr[writePos % arr.length] = a;
            ++writePos;
            ++available;
        }
    }
    public Item pop (Item a) {
        int position = writePos - available;
        if (position < 0) {
            position += arr.length;
        }
        --available;
        return arr[position];
    }
}
