package dataStructures;

/**
 * Created by nav on 5/10/15.
 */
public class Node {

    private Node next;
    private Integer data;

    public Node(Integer data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public int getData() {
        return data;
    }

    public String toString() {
        return "node has a value of " + data;
    }
}
