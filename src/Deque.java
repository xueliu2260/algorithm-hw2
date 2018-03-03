import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
    private class DequeIterator implements Iterator<Item> {
        private Node current = first;

        public boolean hasNext() {
            return current != null;
        }

        public Item next() {
            if (current == null) {
                throw new NoSuchElementException();
            }
            Item item = current.item;
            current = current.next;
            return item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private Node first = null;
    private Node last = null;

    private int size = 0;

    private class Node {
        Item item;
        Node next;
        Node previous;
    }

    public Deque() {

    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void addFirst(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        size += 1;
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        if (oldFirst != null) oldFirst.previous = first;
        if (size == 1) last = first;
    }

    public void addLast(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        size += 1;
        Node oldLast = last;
        last = new Node();
        last.item = item;
        if (oldLast != null) oldLast.next = last;
        last.previous = oldLast;
        if (size == 1) first = last;

    }

    public Item removeFirst() {
        if (!isEmpty()) {
            size -= 1;
            Item result = first.item;
            first = first.next;
            return result;
        }
        throw new NoSuchElementException();
    }

    public Item removeLast() {
        if (!isEmpty()) {
            size -= 1;
            Item result = last.item;
            if (last.previous != null) {
                last = last.previous;
                last.next = null;
            } else {
                last = null;
                first = null;
            }
            return result;
        }
        throw new NoSuchElementException();
    }

    public Iterator<Item> iterator() {
        return new DequeIterator();
    }


    public static void main(String[] args) {
//        Deque test  = new Deque();
//
//        test.addFirst("b");
//        test.addLast("c");
//        test.addFirst("a");
//        test.addLast("d");
//
//        System.out.println("last item is : " + test.removeLast());
//        System.out.println("first item is : " + test.removeFirst());
//        for(Iterator it = test.iterator(); it.hasNext();){
//            Object current = it.next();
//            System.out.println("current item is : " + current);
//        }
//        String[] s = new String[2];
//        s[0] = "aaa";
//        String[] s2 = new String[2];
//        for (int i = 0; i < s2.length; i++)
//            s2[i] = s[i];
//        s[0] = "bbb";
//        System.out.println(s2[0]);


    }
}
