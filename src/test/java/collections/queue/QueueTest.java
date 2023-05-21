package collections.queue;

import collections.exception.OverflowException;
import collections.exception.UnderflowException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class QueueTest {

    private Queue queue;

    @BeforeEach
    void setup() {
        queue = new Queue();
    }

    @Test
    void newQueue_IsEmpty() {
        Assertions.assertTrue(queue.isEmpty());
    }

    @Test
    void afterOneEnqueue_IsNotEmpty() {
        queue.enqueue(0);
        Assertions.assertFalse(queue.isEmpty());
    }

    @Test
    void willThrowUnderflowException_WhenEmptyQueueIsDequeued() {
        Assertions.assertThrowsExactly(UnderflowException.class, () -> queue.dequeue());
    }

    @Test
    void afterOneEnqueueAndOneDequeue_WillBeEmpty() {
        queue.enqueue(0);
        queue.dequeue();
        Assertions.assertTrue(queue.isEmpty());
    }

    @Test
    void afterTwoEnqueuesAndOneDequeue_WillNotBeEmpty() {
        queue.enqueue(0);
        queue.enqueue(0);
        queue.dequeue();
        Assertions.assertFalse(queue.isEmpty());
    }

    @Test
    void afterEnqueueingX_WillDequeueX() {
        queue.enqueue(1);
        Assertions.assertEquals(1, queue.dequeue());
        queue.enqueue(2);
        Assertions.assertEquals(2, queue.dequeue());
    }

    @Test
    void willThrowOverflowException_WhenMoreThanTenElementsAreEnqueued() {
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
        }
        Assertions.assertThrowsExactly(OverflowException.class, () -> queue.enqueue(99));
    }

    @Test
    void afterEnqueueingXAndY_WillDequeueXAndY() {
        queue.enqueue(1);
        queue.enqueue(2);
        Assertions.assertEquals(1, queue.dequeue());
        Assertions.assertEquals(2, queue.dequeue());
    }

}
