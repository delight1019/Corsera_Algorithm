import java.util.Iterator;

public class LinkedListStack<Item> implements Iterable<Item> {
    private Node first = null;

    private class Node {
        Item item;
        Node next;
    }

    private class LinkedListIterator implements Iterator<Item> {
        private Node current = first;

        public boolean hasNext() {
            return current != null;
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

    public void push(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
    }

    public Item pop() {
        Item item = first.item;
        first = first.next;

        return item;
    }

    public static void main(String[] args) {
        LinkedListStack<String> stack = new LinkedListStack<>();

        String[] stringList = {"to", "be", "or", "not", "to", "-", "be", "-", "-", "that", "-", "-", "-", "is"};

        for (String word : stringList) {
            if (word.equals("-")) {
                System.out.print(stack.pop() + " ");
            }
            else {
                stack.push(word);
            }
        }
    }
}
