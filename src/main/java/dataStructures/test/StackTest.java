package dataStructures.test;

import dataStructures.Stack;

/**
 * Created by nav on 5/10/15.
 */
public class StackTest {
    public static void main(String[] args) {
        Stack stack = new Stack();
        System.out.println(stack.isEmpty());
        stack.push(3);
        System.out.println(stack.isEmpty());
        stack.push(2);
        stack.push(1);
        System.out.println(stack);
        System.out.println("pop value = " + stack.pop());
        System.out.println(stack);

        stack.push(8);
        stack.push(15);
        stack.push(7);
        System.out.println(stack);
        stack = StackTest.sort(stack);
        System.out.println(stack);
    }

    public static Stack sort(Stack original) {
        Stack sortedStack = new Stack();
        while (!original.isEmpty()) {
            int temp = original.pop();
            while (!sortedStack.isEmpty() && temp < sortedStack.peek()) {
                original.push(sortedStack.pop());
            }
            sortedStack.push(temp);
        }
        return sortedStack;
    }
}