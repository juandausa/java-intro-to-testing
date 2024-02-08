package collections.stack;

import collections.exception.UnderflowException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StackTest {

    private Stack stack;

    @BeforeEach
    void setUp() {
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
    void willThrowUnderflowException_WhenEmptyStackIsPopped() {
        Assertions.assertThrows(UnderflowException.class, stack::pop);
    }

    @Test
    void afterOnePushAndOnePop_WillBeEmpty() {
        stack.push(0);
        stack.pop();
        Assertions.assertTrue(stack.isEmpty());
    }

    @Test
    void afterTwoPushesAndOnePop_WillNotBeEmpty() {
        stack.push(0);
        stack.push(0);
        stack.pop();
        Assertions.assertFalse(stack.isEmpty());
    }

    @Test
    void afterPushingX_WillPopX() {
        stack.push(42);
        Assertions.assertEquals(42, stack.pop());
    }

    @Test
    void afterPushingXAndY_WillPopYAndX() {
        stack.push(42);
        stack.push(100);
        Assertions.assertEquals(100, stack.pop());
        Assertions.assertEquals(42, stack.pop());
    }

}