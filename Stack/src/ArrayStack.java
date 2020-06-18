public class ArrayStack<Item> {
    private Item[] items;
    private int N = 0;

    public ArrayStack() {
        items = (Item[]) new Object[1];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void push(Item item) {
        if (N == items.length) {
            resize(2 * items.length);
        }

        items[N++] = item;
    }

    public Item pop() {
        Item item = items[--N];
        items[N] = null;

        if (N > 0 && N == items.length/4) {
            resize(items.length / 2);
        }

        return item;
    }

    private void resize(int capacity) {
        Item[] copy = (Item[]) new Object[capacity];

        for (int i = 0; i < N; i++) {
            copy[i] = items[i];
        }

        items = copy;
    }

    public static void main(String[] args) {
        ArrayStack<String> queue = new ArrayStack<String>();

        String[] stringList = {"to", "be", "or", "not", "to", "-", "be", "-", "-", "that", "-", "-", "-", "is"};

        for (String word : stringList) {
            if (word.equals("-")) {
                System.out.print(queue.pop() + " ");
            }
            else {
                queue.push(word);
            }
        }
    }
}
