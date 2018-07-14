public class FixedCapacityStack <Item> {
    private Item[] arr;
    private int size = 0;
    public FixedCapacityStack (int cap) {
        arr = (Item[]) new Object[cap];
    }
    public void push (Item a) {
        if (size < arr.length) {
            arr[size++] = a;
        }
    }
    public Item pop () {
        return arr[--size];
    }
    public int getSize() {
        return size;
    }
}
