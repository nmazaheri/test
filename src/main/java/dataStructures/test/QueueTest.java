package dataStructures.test;

import dataStructures.Queue;

/**
 * Created by nav on 5/17/15.
 */
public class QueueTest {
    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.enqueue(3);
        queue.enqueue(5);
        queue.enqueue(1);
        queue.enqueue(8);
        queue.enqueue(9);
        System.out.println(queue.toString());
        System.out.println(queue.dequeue());
        System.out.println(queue.toString());
    }
}

