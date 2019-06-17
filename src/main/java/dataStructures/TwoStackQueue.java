package dataStructures;

import java.util.LinkedList;

/**
 * Created by nav on 11/27/15.
 */
public class TwoStackQueue {
    java.util.Queue<Integer> in = new LinkedList<>();
    java.util.Queue<Integer> out = new LinkedList<>();

    public void enqueue(int num) {
        in.add(num);
    }

    public int dequeue() {
        if (out.isEmpty()) {
            while(!in.isEmpty()) {
                out.add(in.poll());
            }
        }
        return out.poll();
    }

    public static void main (String args []) {
        TwoStackQueue queue = new TwoStackQueue();
        queue.enqueue(1);
        System.out.println(queue.dequeue());
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println(queue.dequeue());
        queue.enqueue(4);
        queue.enqueue(5);
        System.out.println(queue.dequeue());
        queue.enqueue(6);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }

}
