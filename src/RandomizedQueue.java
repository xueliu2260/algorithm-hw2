import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

public class RandomizedQueue<Item> implements Iterable<Item> {
    public RandomizedQueue() {

    }

    private int size = 0;
    private Item[] s = (Item[]) new Object[1];
    private Random rand = new Random();

    private class RandomizeQueueIterator<Item> implements Iterator<Item> {
        int iteratorSize = size;
        Random rand = new Random();
        private Item[] iteratorS = (Item[]) new Object[iteratorSize];

        public RandomizeQueueIterator() {
            for (int i = 0; i < size; i++) {
                iteratorS[i] = (Item) s[i];
            }
        }

        public Item next() {
            if (iteratorSize == 0) {
                throw new NoSuchElementException();
            }
            int random = rand.nextInt(iteratorSize);
            Item result = iteratorS[random];
            iteratorS[random] = iteratorS[iteratorSize - 1];
            iteratorSize -= 1;
            return result;
        }

        public boolean hasNext() {
            return iteratorSize > 0;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void enqueue(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        s[size] = item;
        size += 1;
        if (size == s.length) resize(2 * s.length);

    }

    private void resize(int capacity) {
        Item[] copy = (Item[]) new Object[capacity];
        int len = Math.min(capacity, s.length);
        for (int i = 0; i < len; i++)
            copy[i] = s[i];
        s = copy;
    }

    public Item dequeue() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        int random = rand.nextInt(size);
        Item result = s[random];
        s[random] = s[size - 1];
        size -= 1;
        if (size > 0 && size == s.length / 4) resize(s.length / 2);
        return result;

    }

    public Item sample() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        int random = rand.nextInt(size);
        Item result = s[random];
        return result;
    }

    public Iterator<Item> iterator() {
        return new RandomizeQueueIterator();
    }

    public static void main(String[] args) {
//        RandomizedQueue test = new RandomizedQueue();
//        test.enqueue(null);
//        test.enqueue(3);
//        test.enqueue(5);
//        test.dequeue();
//        test.dequeue();
//        for (Iterator it = test.iterator(); it.hasNext(); ) {
//            System.out.println(it.next());
//        }
    }
}