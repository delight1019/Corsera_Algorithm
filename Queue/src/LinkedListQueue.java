import java.util.Iterator;

public class LinkedListQueue<Item> implements Iterable<Item> {
    private Node first, last;

    private class Node {
        Item item;
        Node next;
    }

    private class LinkedListIterator implements Iterator<Item> {
        private Node current = first;

        public boolean hasNext() {
            return (current != last.next);
        }

        public Item next() {
            Item item = current.item;
            current = current.next;

            return item;
        }
    }

    public Iterator<Item> iterator() {
        return new LinkedListIterator();
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void enqueue(Item item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;

        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
    }

    public Item dequeue() {
        Item item = first.item;
        first = first.next;

        if (isEmpty()) {
            last = null;
        }

        return item;
    }

    public static void main(String[] args) {
        LinkedListQueue<String> queue = new LinkedListQueue<>();

        String[] stringList = {"to", "be", "or", "not", "to", "-", "be", "-", "-", "that", "-", "-", "-", "is"};

        for (String word : stringList) {
            if (word.equals("-")) {
                //System.out.print(queue.dequeue() + " ");
            }
            else {
                queue.enqueue(word);
            }
        }

        System.out.print("\n");

        for (String word : queue) {
            System.out.print(word + " ");
        }
    }
}
