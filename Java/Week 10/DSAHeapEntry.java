class DSAHeapEntry {
    /* Global Variables */
    private int priority;
    private Object value;

    /* Default Constructor */
    public DSAHeapEntry()
    {
        priority = 0;
        value = null;
    }

    /* Constructor */
    public DSAHeapEntry(int inPriority, Object inValue)
    {
        priority = inPriority;
        value = inValue;
    }

    /* Accessors */
    public int getPriority()
    {
        return priority;
    }

    public Object getValue()
    {
        return value;
    }

    /* Mutators */
    public void setPriority(int inPriority)
    {
        priority = inPriority;
    }

    public void setValue(Object inValue)
    {
        value = inValue;
    }
}