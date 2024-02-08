package collections.stack;

import collections.exception.OverflowException;
import collections.exception.UnderflowException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StackTest {

    private Stack stack;

    @BeforeEach
    void setup() {
        stack = new Stack();
    }

    @Test
    void newStack_IsEmpty() {
        Assertions.assertTrue(stack.isEmpty());
    }

    @Test
    void afterOnePush_IsNotEmpty() {
        stack.push(0);
        Assertions.assertFalse(stack.isEmpty());
    }

    @Test
    void willThrowUnderflowException_WhenEmptyStackIsDequeued() {
        Assertions.assertThrowsExactly(UnderflowException.class, () -> stack.pop());
    }

    @Test
    void afterOnePushAndOnePop_WillBeEmpty() {
        stack.push(0);
        stack.pop();
        Assertions.assertTrue(stack.isEmpty());
    }

}
