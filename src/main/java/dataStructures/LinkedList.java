package dataStructures;

/**
 * Created by nav on 6/29/15.
 */
public interface LinkedList {
    Integer get(int index);

    boolean add(int data);

    boolean add(int index, int data);

    boolean remove();

    boolean remove(int index);
}
