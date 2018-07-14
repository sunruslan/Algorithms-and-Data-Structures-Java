public class FixedCapacityStack <Item> {
    private Item[] arr;
    private int size = 0;
    private int capacity;
    public FixedCapacityStack (int cap) {
        arr = (Item[]) new Object[cap];
        capacity = cap;
    }
    public void push (Item a) {
        if (size < capacity) {
            arr[size++] = a;
        }
    }
    public Item pop () {
        return arr[--size];
    }
    public int getSize() {
        return size;
    }
    public int getCapacity() {
        return capacity;
    }
}
