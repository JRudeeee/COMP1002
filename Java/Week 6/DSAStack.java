
import java.util.NoSuchElementException;

/* This class was modified from my week 4 code */

class DSAStack {
    /* Varialbles */
    private final DSALinkedList stack;
    
    /* Default Constructor */
    public DSAStack()
    {
        stack = new DSALinkedList();
    }

    public Boolean isEmpty()
    {
        return stack.isEmpty();
    }


    public Object top()
    {
        Object topVal;
        if (isEmpty())
        {
            throw new NoSuchElementException("Error! The stack is empty!");
        } else
        {
            topVal = stack.peekLast();
        }
        return topVal;
    }

    /* Mutator Methods */
    public void push(Object value)
    {
        stack.insertLast(value);
    }

    public Object pop()
    {
        Object topVal = stack.peekLast();
        stack.removeLast();
        
        return topVal;
    }
}
