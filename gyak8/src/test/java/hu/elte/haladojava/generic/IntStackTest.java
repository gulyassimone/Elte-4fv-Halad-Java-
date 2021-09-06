package hu.elte.haladojava.generic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

// it does not have 100% test coverage, please feel free to extend it
class IntStackTest {

    @Test
    void constructor_negativeCapacity() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new IntStack(-1));
    }

    @Test
    void push_oneElement() throws Exception {
        IntStack stack = new IntStack(10);
        stack.push(50);

        Assertions.assertFalse(stack.isEmpty());
    }

    @Test
    void push_stackIsFull() throws Exception {
        IntStack stack = new IntStack(1);
        stack.push(6);

        Assertions.assertThrows(StackOverflowException.class, () -> stack.push(100));
    }

    @Test
    void pop_removesLastElement() throws Exception {
        IntStack stack = new IntStack(1);
        stack.push(6);
        Assertions.assertFalse(stack.isEmpty());
        Assertions.assertTrue(stack.isFull());

        int lastElement = stack.pop();

        Assertions.assertEquals(6, lastElement);
        Assertions.assertTrue(stack.isEmpty());
        Assertions.assertFalse(stack.isFull());
    }

    // uncomment this test after making IntStack generic
    /*
    @Test
    void generic() {
        Stack<String> stack = new Stack<>(1);
        stack.push("pearl");

        Assertions.assertTrue(stack.pop() instanceof String);
    }*/
}