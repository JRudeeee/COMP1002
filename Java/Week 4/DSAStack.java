
class DSAStack {
    // Varialbles
    private final int DEFAULT_CAPACITY = 100;
    private final Object ADT[];
    private  int count = 0;
    /* This exception should change */
    private final String e = "this is an exception\n";

    public DSAStack()
    {
        ADT = new Object[DEFAULT_CAPACITY];
    }

    public int getCount(){
        return this.count;
    }

    public Boolean isEmpty(){
        return (this.count == 0);
    }

    public Boolean isFull(){
         return (this.count == this.ADT.length);
    }

    public void push(Object value){
        if (isFull()){
            System.out.print(e); // exception need to change
        } else {
            ADT[this.count] = value;
            this.count++;
        }
    }

    public Object pop(){
        Object topVal = top();
        this.count--;
        return topVal;
    }

    public Object top(){
        Object topVal = 0;
        if(isEmpty()){
            System.out.print(e); // exception needs to change
        } else {
            topVal = this.ADT[this.count-1];
        }
        return topVal;
    }
}
