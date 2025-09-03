import java.util.NoSuchElementException;

class DSALinkedList {

    /* Class Fields */
    DSAListNode head;
    DSAListNode tail;

    /* Default Constructor */
    public DSALinkedList(){
        head = null;
        tail = null;
    }

    /* Accessors */

    public boolean isEmpty(){
        boolean empty = false;

        if (head == null){
            empty = true;
        }

        return empty;
    }

    public Object peekFirst(){
        Object nodeValue;

        if (isEmpty()){
            throw new NoSuchElementException("The list is empty!\n");
        } else {
            nodeValue = head.getValue();
        }
        
        return nodeValue;
    }

    public Object peekLast(){
        Object nodeValue;

        if (isEmpty()){
            throw new NoSuchElementException("The list is empty!\n");
        } else {
            nodeValue = tail.getValue();
        }
        return  nodeValue;
    }
    
    /* Mutators */

    public void insertFirst(Object newValue){
        DSAListNode newNd = new DSAListNode(newValue);

        if (isEmpty()){
            head = newNd;
            tail = newNd;
        } else {
            newNd.setNext(head);
            head.setPrev(newNd);
            head = newNd;
        }
    }

    public void insertLast(Object newValue){
        DSAListNode newNd = new DSAListNode(newValue);
        if (isEmpty()){
            head = newNd;
            tail = newNd;
        } else {
            newNd.setPrev(tail);
            tail.setNext(newNd);
            tail = newNd;
        }
    }

    public Object removeFirst(){
        Object nodeValue;

        if (isEmpty()){
            throw new NoSuchElementException("The list is empty!\n");
        } else if (head.getNext() == null) { 
            nodeValue = head.getValue();
            head = null;
            tail = null;
        } else {
            nodeValue = head.getValue();
            head = head.getNext();
        }

        return nodeValue;
    }

    public Object removeLast(){
        Object nodeValue;

        if (isEmpty()){
            throw new NoSuchElementException("The list is empty!\n");
        } else if (tail.getPrev() == null) {
            nodeValue = tail.getValue();
            head = null;
            tail = null;
        } else {
            DSAListNode prevNd = tail.getPrev();
            
            prevNd.setNext(null);
            nodeValue = tail.getValue();
            tail = prevNd;
        }

        return nodeValue;
    }

    /* Private Inner Class */
    private class DSAListNode {
    
        /* Class Fields */
        private Object value;
        private DSAListNode next;
        private DSAListNode prev;

        /* Constructor */
        public DSAListNode(Object inValue) {
            value = inValue;
            next = null;
            prev = null;
        }

        /* Accessors */
        private Object getValue(){
            return value;
        }

        private DSAListNode getNext(){
            return next;
        }

        private DSAListNode getPrev(){
            return prev;
        }

        /* Mutators */
        private void setValue(Object inValue){
            value = inValue;
        }

        private void setNext(DSAListNode newNext){
            next = newNext;
        }

        private void setPrev(DSAListNode newPrev){
            prev = newPrev;
        }
    }
    
}
