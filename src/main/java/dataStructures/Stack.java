package dataStructures;

public class Stack {
    Node top;
    int size;

    public Stack() {
    }

    public int pop() {
        if (top != null) {
            Node oldTop = top;
            top = top.getNext();
            size--;
            return oldTop.getData();
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public int peek() {
        if (top != null) {
            return top.getData();
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void push(int data) {
        Node newNode = new Node(data);
        newNode.setNext(top);
        size++;
        top = newNode;
    }

    public String toString() {
        Node currentNode = top;
        String output = "";
        while (currentNode != null) {
            output += "[" + currentNode.getData() + "]";
            currentNode = currentNode.getNext();
        }
        return output;
    }
}