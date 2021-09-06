package hu.elte.haladojava.generic;

public class IntStack {
    private final int[] elements;
    private final int capacity;
    private int pointer = - 1;

    public IntStack(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("capacity cannot be negative: " + capacity);
        }
        this.capacity = capacity;
        this.elements = new int[capacity];
    }

    public void push(int element) throws StackOverflowException {
        if (isFull()) {
            throw new StackOverflowException("the stack is full, element cannot be pushed");
        }
        elements[++pointer] = element;
    }

    public int pop() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException("the stack is empty, there is no element to pop");
        }
        return elements[pointer--];
    }

    public int size() {
        return pointer + 1;
    }

    public boolean isEmpty() {
        return pointer == -1;
    }

    public boolean isFull() {
        return pointer == capacity - 1;
    }
}