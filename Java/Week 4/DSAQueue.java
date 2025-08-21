class DSAQueue {
    /* Varialbles */
    protected int DEFAULT_CAPACITY = 100;
    protected Object queue[];
    protected int count = 0;

    /* Default Constructor */
    public DSAQueue()
    {
        queue = new Object[DEFAULT_CAPACITY];
    }

    /* Alternate Constructor */
    public DSAQueue(int maxCapacity)
    {
        queue = new Object[maxCapacity];
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
        return (count == queue.length);
    }

}

class DSAShuffleQueue extends DSAQueue {

    /* Default Constructor */
    public DSAShuffleQueue()
    {
        super();
    }

    /* Alternate Constructor */
    public DSAShuffleQueue(int maxCapacity)
    {
        super(maxCapacity);
    }

    /* Accessor Methods */
    public Object peek()
    {
        Object topVal;
        if (isEmpty())
        {
            throw new IllegalArgumentException("Error! The queue is empty!");
        } else
        {
            topVal = this.queue[0];
        }
        return topVal;
    }

    /* Mutator Methods */
    public void enqueue(Object value)
    {
        if (isFull())
        {
            throw new IllegalArgumentException("Error! The queue is full!");
        } else
        {
            queue[count] = value;
            count++;
        }
    }

    public Object dequeue()
    {
        Object topVal = peek();

        for (int ii = 1; ii < count; ii++)
        {
            queue[ii - 1] = queue[ii];
        }

        count--;
        return topVal;
    }

}

class DSACircularQueue extends DSAQueue {

    /* Variables */
    private int front = 0;
    private int back = 0;
    private final int maxCapacity;

    /* Default Constructor */
    public DSACircularQueue()
    {
        super();
        maxCapacity = DEFAULT_CAPACITY;
    }

    /* Alternate Constructor */
    public DSACircularQueue(int maxCapacity)
    {
        super(maxCapacity);
        this.maxCapacity = maxCapacity;
    }

    /* Accessor Methods */
    public Object peek()
    {
        Object topVal;
        if (isEmpty())
        {
            throw new IllegalArgumentException("Error! The queue is empty!");
        } else
        {
            topVal = queue[front];
        }
        return topVal;
    }

    /* Mutator Methods */
    public void enqueue(Object value)
    {
        if (isFull())
        {
            throw new IllegalArgumentException("Error! The queue is full!");
        } else
        {
            if(isEmpty()){
                queue[back] = value;
            } else {
               back = (back + 1) % maxCapacity;
                queue[back] = value; 
            }
            count++;
        }
    }

    public Object dequeue()
    {
        Object topVal = peek();
        count--;
        if(count != 0){
            front = (front + 1) % maxCapacity;
        }
        
        return topVal;
    }

}
