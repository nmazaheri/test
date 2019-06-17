package dataStructures;

import java.util.ArrayList;

public class LinkedListImpl implements LinkedList {
    private Node head = new Node(null);
    private int size = 0;

    public int size() {
        return size;
    }

    @Override
    public Integer get(int index) {
        if (index < 0 || index >= size())
            return null;

        return this.getNode(index).getData();
    }

    private Node getNode(int index) {
        if (index >= size())
            index = size() - 1;

        if (index < 0)
            return head;

        Node currentNode = head.getNext();
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNext();
        }
        return currentNode;
    }

    @Override
    public boolean add(int data) {
        return add(size(), data);
    }

    @Override
    public boolean add(int index, int data) {
        if (index < 0)
            return false;

        Node previousNode = getNode(index-1);
        Node newNode = new Node(data);
        newNode.setNext(previousNode.getNext());
        previousNode.setNext(newNode);
        size++;
        return true;
    }

    @Override
    public boolean remove() {
        return remove(0);
    }

    @Override
    public boolean remove(int index) {
        if (index < 0 || index >= size())
            return false;

        Node currentNode = getNode(index-1);
        currentNode.setNext(currentNode.getNext().getNext());
        size--;
        return true;
    }

    public String toString() {
        Node currentNode = head.getNext();
        String output = "";
        while (currentNode != null) {
            output += "[" + currentNode.getData() + "]";
            currentNode = currentNode.getNext();
        }
        return output;
    }

    public boolean removeFirstValue(int value) {
        Node currentNode = head;
        while (currentNode.getNext() != null) {
            if (currentNode.getNext().getData() == value) {
                currentNode.setNext(currentNode.getNext().getNext());
                size--;
                return true;
            }
            currentNode = currentNode.getNext();
        }

        return false;
    }

    public LinkedList reorderList() {
        int midpoint = size() / 2;
        if (size() % 2 != 0) {
            midpoint++;
        }

        LinkedList first = this.getSublist(midpoint);
        LinkedListImpl second = this.getSublist(midpoint, size());
        second.reverseOrder();

        for (int i = 1, j = 0; i < size(); i += 2, j++) {
            first.add(i, second.get(j));
        }
        return first;
    }

    public void reverseOrder() {
        // do it in place
        Node current = head.getNext();
        Node prev = null;

        while (current != null) {
            Node origNext = current.getNext();
            current.setNext(prev);
            prev = current;
            current = origNext;
        }
        head.setNext(prev);
    }

    public LinkedList getSublist(int to) {
        return this.getSublist(0, to);
    }

    public LinkedListImpl getSublist(int from, int to) {
        if (from < 0)
            return null;

        to = Math.min(to, size());
        LinkedListImpl subList = new LinkedListImpl();
        Node currentNode = getNode(from);
        for (int i = 0; i < to - from && currentNode != null; i++) {
            subList.add(currentNode.getData());
            currentNode = currentNode.getNext();
        }

        return subList;
    }

    public void removeDupes() {
        Node currentNode = head;
        int currentData;
        ArrayList<Integer> dataList = new ArrayList<>();
        int index = 0;

        while (currentNode.getNext() != null) {
            currentNode = currentNode.getNext();
            currentData = currentNode.getData();
            if (dataList.contains(currentData)) {
                this.remove(index);
            } else {
                dataList.add(currentData);
                index++;
            }
        }
    }

    public boolean swap(int index1, int index2) {
        if (index1 < 0 || index2 < 0 || index1 >= size() || index2 >= size() || index1 == index2)
            return false;

        int fartherIndex = Math.max(index1, index2);
        int closerIndex = Math.min(index1, index2);

        int fartherValue = this.get(fartherIndex);
        int closerValue = this.get(closerIndex);

        this.remove(fartherIndex);
        this.add(fartherIndex, closerValue);

        this.remove(closerIndex);
        this.add(closerIndex, fartherValue);
        return true;
    }

}
