package dataStructures.test;

import dataStructures.LinkedListImpl;

/**
 * Created by nav on 5/10/15.
 */
public class LinkedListTest {

    public static void main(String[] args) {
        LinkedListImpl linkedListImpl = new LinkedListImpl();
        linkedListImpl.add(1);
        linkedListImpl.add(2);
        linkedListImpl.add(1);
        linkedListImpl.add(2);
        linkedListImpl.add(4, 4);
        linkedListImpl.add(0, 7);
        System.out.println(linkedListImpl);
        linkedListImpl.add(15, 5);
        System.out.println(linkedListImpl);
        linkedListImpl.swap(2, 3);
        System.out.println(linkedListImpl);
        linkedListImpl.removeDupes();
        System.out.println(linkedListImpl);
        linkedListImpl.remove(2);
        System.out.println(linkedListImpl);
        System.out.println(linkedListImpl.get(0));
        System.out.println(linkedListImpl.get(1));
        System.out.println(linkedListImpl.get(2));
        System.out.println(linkedListImpl.get(3));

        linkedListImpl.add(15);
        linkedListImpl.add(8);
        linkedListImpl.add(4);
        System.out.println(linkedListImpl.toString());

        linkedListImpl.removeFirstValue(4);
        System.out.println(linkedListImpl.toString());
        linkedListImpl.reverseOrder();
        System.out.println(linkedListImpl.toString());
        System.out.println(linkedListImpl.reorderList());
        System.out.println(linkedListImpl.toString());
        System.out.println(linkedListImpl);
    }
}

