
class DSAStack {
    /* Varialbles */
    private final int DEFAULT_CAPACITY = 100;
    private final Object stack[];
    private int count = 0;

    /* Default Constructor */
    public DSAStack()
    {
        stack = new Object[DEFAULT_CAPACITY];
    }

    /* Alternate Constructor */
    public DSAStack(int maxCapacity)
    {
        stack = new Object[maxCapacity];
    }

    /* Accessor Methods */
    public int getCount()
    {
        return count;
    }

    public Boolean isEmpty()
    {
        return (count == 0);
    }

    public Boolean isFull()
    {
        return (count == stack.length);
    }

    public Object top()
    {
        Object topVal;
        if (isEmpty())
        {
            throw new IllegalArgumentException("Error! The stack is empty!");
        } else
        {
            topVal = stack[count - 1];
        }
        return topVal;
    }

    /* Mutator Methods */
    public void push(Object value)
    {
        if (isFull())
        {
            throw new IllegalArgumentException("Error! The stack is full!");
        } else
        {
            stack[count] = value;
            count++;
        }
    }

    public Object pop()
    {
        Object topVal = top();
        count--;
        return topVal;
    }
}
