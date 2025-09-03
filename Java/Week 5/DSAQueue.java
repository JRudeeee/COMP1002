import java.util.NoSuchElementException;

/* This class was modified from my week 4 code */

class DSAQueue {
    /* Varialbles */
    private final DSALinkedList queue;

    /* Default Constructor */
    public DSAQueue()
    {
        queue = new DSALinkedList();
    }

    /* Accessor Methods */
    public Boolean isEmpty()
    {
        return queue.isEmpty();
    }

    public Object peek(){
        Object frontVal;
        if (isEmpty())
        {
            throw new NoSuchElementException("Error! The queue is empty!");
        }
            frontVal = queue.peekFirst();
        return frontVal;
    }

    public void enqueue(Object value){
        queue.insertLast(value);
    }

    public Object dequeue(){
        Object frontVal = queue.peekFirst();
        queue.removeFirst();
        return frontVal;
    }

}
