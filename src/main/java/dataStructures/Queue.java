package dataStructures;

/**
 * Created by nav on 5/30/15.
 */
public class Queue {
    private LinkedListImpl list = new LinkedListImpl();

    public boolean isEmpty() {
        return (list.size() == 0);
    }

    public void enqueue(int item) {
        list.add(item);
    }

    public void add(int item) {
        enqueue(item);
    }

    public int dequeue() {
        int item = list.get(0);
        list.remove(0);
        return item;
    }

    public int remove() {
        return dequeue();
    }

    public int peek() {
        return list.get(1);
    }

    public String toString() {
        return list.toString();
    }
}
