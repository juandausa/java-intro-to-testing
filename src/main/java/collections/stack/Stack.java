package collections.stack;

import collections.exception.OverflowException;
import collections.exception.UnderflowException;

public class Stack {
    private static final int CAPACITY = 10;

    private final int[] elements = new int[CAPACITY];
    private int size = 0;
    private int headIdx = CAPACITY;
    
    public boolean isEmpty() {
        return size == 0;
    }

    private boolean isFull() {
        return size == elements.length;
    }

    public void push(int element) {
        if (isFull()) {
            throw new OverflowException();
        }

        headIdx--;
        size++;
        elements[headIdx] = element;
    }

    public int pop() {
        if (isEmpty()) {
            throw new UnderflowException();
        }

        size--;
        return elements[headIdx--];
    }
}
